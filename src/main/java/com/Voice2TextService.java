package com;

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

    public static void main(String[] args){
        System.out.println("start");
        System.out.println(transcribeAudioFile());
        System.out.println("end");

    }

    /**
     * Sendet eine Audio-Datei an OpenAI für die Transkription.
     * should have the file path as input param but for quick testing it's currently added in the method
     * @return Die transkribierte Textantwort von OpenAI.
     */
    public static String transcribeAudioFile() {
        String boundary = Long.toHexString(System.currentTimeMillis()); // Zufällige Grenze
        String CRLF = "\r\n"; // Zeilenumbruch im Internet-Stil
        HttpURLConnection connection = null;

        String fp = "C:\\Users\\a_n_n\\Documents\\Audioaufzeichnungen\\Aufzeichnung - Test1.m4a";

        try {
            URL url = new URL("https://api.openai.com/v1/audio/translations");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("Authorization", "Bearer "); //TODO needs to be set manually after pull

            try (OutputStream output = connection.getOutputStream();
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true)) {

                // Senden der Audio-Datei
                writer.append("--" + boundary).append(CRLF);
                writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + fp + "\"").append(CRLF);
                writer.append("Content-Type: " + Files.probeContentType(Paths.get(fp))).append(CRLF); // Automatische Bestimmung des Content-Types
                writer.append(CRLF).flush();
                Files.copy(Paths.get(fp), output);
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

                return response.toString();
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
}
