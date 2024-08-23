import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SendMessagePoll {

    public static void main(String[] args) {
        // Substitua pelos valores reais
        String apiKey = "GLOBAL_API_KEY";
        String sessionId = "SESSION_ID";
        String phoneNumber = "557183196364";
        String urlString = "https://zip-zop.site/client/sendMessage/" + sessionId;

        // Dados da mensagem
        String chatId = phoneNumber + "@c.us";
        String pollName = "Cats or Dogs?";
        String[] pollOptions = {"Cats", "Dogs"};
        String allowMultipleAnswers = "true";

        // Crie o corpo da requisição JSON
        StringBuilder pollOptionsBuilder = new StringBuilder();
        for (int i = 0; i < pollOptions.length; i++) {
            pollOptionsBuilder.append("\"").append(pollOptions[i]).append("\"");
            if (i < pollOptions.length - 1) {
                pollOptionsBuilder.append(",");
            }
        }
        String jsonInputString = String.format(
            "{\"chatId\": \"%s\", \"contentType\": \"Poll\", \"content\": {\"pollName\": \"%s\", \"pollOptions\": [%s], \"options\": {\"allowMultipleAnswers\": %s}}}",
            chatId, pollName, pollOptionsBuilder.toString(), allowMultipleAnswers
        );

        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("x-api-key", apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // Envia os dados da requisição
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Obtém o código de resposta HTTP
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Lê e exibe a resposta da requisição
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line).append("\n");
                }
                System.out.println("Response Body: " + response.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
