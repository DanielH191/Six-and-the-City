package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class TextSummarizerService {

    @Value("${open.api.key}")
    private String apiKey;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getDataFromText(String text) {
        try {

            // TODO maybe put the connection to openAI while starting the application
            // Specify the URL
            URL url = new URL("https://api.openai.com/v1/chat/completions");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("POST");

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);

            // Enable output and input streams
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Create JSON payload
            String jsonPayload = "{"
                    + "\"model\": \"gpt-3.5-turbo\","
                    + "\"messages\": ["
                    + "{"
                    + "\"role\": \"system\","
                    + "\"content\": \"Filter the following for location and occurrence - separate by semicolon\""
                    + "},"
                    + "{"
                    + "\"role\": \"user\","
                    + "\"content\": \"" + text + "\""
                    + "}"
                    + "]}";


            // Write JSON payload to the connection output stream
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonPayload);
            outputStream.flush();
            outputStream.close();

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response body
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonNode jnode = objectMapper.readTree(response.toString());
            //System.out.println(jnode.toString());
            return jnode;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
