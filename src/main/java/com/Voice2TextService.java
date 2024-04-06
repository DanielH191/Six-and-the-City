package com;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class Voice2TextService {

    @Value("${open.api.key}")
    private String apiKey; // Ihr OpenAI API Schlüssel

    @Autowired
    private TextSummarizerService textSummarizerService;


    /**
     * Sendet eine Audio-Datei an OpenAI für die Transkription.
     * should have the file path as input param but for quick testing it's currently added in the method
     *
     * @return Die transkribierte Textantwort von OpenAI.
     */
    public JsonNode transcribeAudioFile(String filePath) {
        String boundary = Long.toHexString(System.currentTimeMillis()); // Zufällige Grenze
        String CRLF = "\r\n"; // Zeilenumbruch im Internet-Stil
        HttpURLConnection connection = null;

        System.out.println("before voice to text");

        try {
            URL url = new URL("https://api.openai.com/v1/audio/translations");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("Authorization", "Bearer " + apiKey); //TODO needs to be set manually after pull

            try (OutputStream output = connection.getOutputStream();
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true)) {

                // Senden der Audio-Datei
                writer.append("--" + boundary).append(CRLF);
                writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + filePath + "\"").append(CRLF);
                writer.append("Content-Type: " + Files.probeContentType(Paths.get(filePath))).append(CRLF); // Automatische Bestimmung des Content-Types
                writer.append(CRLF).flush();
                Files.copy(Paths.get(filePath), output);
                output.flush(); // Wichtig vor weiteren schriftlichen Aktionen
                writer.append(CRLF).flush(); // CRLF ist wichtig! Es trennt verschiedene Teile der Daten.

                // Modell-Parameter
                writer.append("--" + boundary).append(CRLF);
                writer.append("Content-Disposition: form-data; name=\"model\"").append(CRLF);
                writer.append(CRLF).append("whisper-1").append(CRLF).flush(); // Modellname gemäß Ihrer Anforderung

                // Ende des Körpers
                writer.append("--" + boundary + "--").append(CRLF).flush();
            }

            // Antwort von OpenAI
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("works till here");
                System.out.println("after voice to text");
                /**
                 * TextSummarizer Part
                 */
                System.out.println("before long text to short text");
                System.out.println("Before parsing:" + response);
                //String text = JsonPath.parse(response).read("$.text");
                //parse json from response to String:
                //String parsedResponse = extractSubstring(response.toString(), 3, 4);
                // $.text

                String parsedResponse = parseStringBuffer(response);
                System.out.println("After parsing: " + parsedResponse);
                JsonNode reply = textSummarizerService.getDataFromText("Hello? I live next to Guenther Jauch. Here is an Emergency at Wannsee Street 1. " +
                        "I can hardly belief it. Saw two men with guns leaving his apartment. Please, send help now!"); //FIXME

               // return response.toString();
                return reply;

            } else {
                System.out.println("HTTP Fehlercode: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public String parseStringBuffer(StringBuffer original) {
        int nrGaenzefuechschen = 0;
        String parsed = "";
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == '\"') { // Double quote character
                nrGaenzefuechschen++;
            }
            if (nrGaenzefuechschen == 3) { // Change condition here
                parsed += original.charAt(i);
            }
        }
        if (parsed.startsWith("\"")) {
            parsed = parsed.substring(1);
        }
        return parsed;
    }


}
