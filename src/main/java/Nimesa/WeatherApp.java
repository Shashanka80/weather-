package Nimesa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherApp {

    private static final String API_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\n1. Get weather\n2. Get Wind Speed\n3. Get Pressure\n0. Exit");
                System.out.print("Enter your choice: ");
                int option = readInt();

                if (option == 1) {
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date = readString();
                    getWeatherData(date);
                } else if (option == 2) {
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date = readString();
                    getWindSpeedData(date);
                } else if (option == 3) {
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date = readString();
                    getPressureData(date);
                } else if (option == 0) {
                    System.out.println("Terminating the program.");
                    break;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }
    }

    private static void getWeatherData(String date) throws IOException {
        String jsonData = fetchJsonData(API_URL);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray list = jsonObject.getJSONArray("list");
        for (int i = 0; i < list.length(); i++) {
            JSONObject entry = list.getJSONObject(i);
            if (entry.getString("dt_txt").contains(date)) {
                double temperature = entry.getJSONObject("main").getDouble("temp");
                System.out.printf("Temperature on %s: %.2f°C\n", date, temperature);
                return;
            }
        }
        System.out.println("No weather data available for the given date.");
    }

    private static void getWindSpeedData(String date) throws IOException {
        String jsonData = fetchJsonData(API_URL);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray list = jsonObject.getJSONArray("list");
        for (int i = 0; i < list.length(); i++) {
            JSONObject entry = list.getJSONObject(i);
            if (entry.getString("dt_txt").contains(date)) {
                double windSpeed = entry.getJSONObject("wind").getDouble("speed");
                System.out.printf("Wind Speed on %s: %.2f m/s\n", date, windSpeed);
                return;
            }
        }
        System.out.println("No weather data available for the given date.");
    }

    private static void getPressureData(String date) throws IOException {
        String jsonData = fetchJsonData(API_URL);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray list = jsonObject.getJSONArray("list");
        for (int i = 0; i < list.length(); i++) {
            JSONObject entry = list.getJSONObject(i);
            if (entry.getString("dt_txt").contains(date)) {
                double pressure = entry.getJSONObject("main").getDouble("pressure");
                System.out.printf("Pressure on %s: %.2f hPa\n", date, pressure);
                return;
            }
        }
        System.out.println("No weather data available for the given date.");
    }

    private static String fetchJsonData(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        connection.disconnect();
        return response.toString();
    }

    private static int readInt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    private static String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
