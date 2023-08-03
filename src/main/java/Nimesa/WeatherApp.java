package Nimesa;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherApp {
    private static final String API_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Uncomment this line if you don't want to see the browser window
        try {
            driver.get("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22"); // Replace with the URL containing JSON data

            // Fetch JSON data from a web element (example: div element with id "json_data")
            String jsonData = driver.findElement(By.id("json_data")).getText();

            // Use Jackson ObjectMapper to parse JSON data
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);
}
        driver = new ChromeDriver(options);
        driver.get(API_URL);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Get weather");
            System.out.println("2. Get Wind Speed");
            System.out.println("3. Get Pressure");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getWeather();
                    break;
                case 2:
                    getWindSpeed();
                    break;
                case 3:
                    getPressure(choice);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);

        driver.quit();
        scanner.close();
    }

    private static void getWeather() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date (YYYY-MM-DD HH:MM:SS): ");
        String date = scanner.nextLine();

        String jsonString = driver.findElement(By.tagName("body")).getText();
        // Use any JSON parsing library to extract the temperature for the specified date
        // For simplicity, let's assume we are using a library named "json-parser"
        double temperature = jsonParser.extractTemperature(jsonString, date);

        System.out.println(String.format("Temperature on %s: %.2f Kelvin", date, temperature));
    }

    private static void getWindSpeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date (YYYY-MM-DD HH:MM:SS): ");
        String date = scanner.nextLine();

        String jsonString = driver.findElement(By.tagName("body")).getText();
        // Use any JSON parsing library to extract the wind speed for the specified date
        // For simplicity, let's assume we are using a library named "json-parser"
        double windSpeed = jsonParser.extractWindSpeed(jsonString, date);

        System.out.println(String.format("Wind Speed on %s: %.2f m/s", date, windSpeed));
    }

    private static void getPressure(Object jsonParser) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date (YYYY-MM-DD HH:MM:SS): ");
        String date = scanner.nextLine();

        String jsonString = driver.findElement(By.tagName("body")).getText();
        // Use any JSON parsing library to extract the pressure for the specified date
        // For simplicity, let's assume we are using a library named "json-parser"
        double pressure = jsonParser.extractPressure(jsonString, date);

        System.out.println(String.format("Pressure on %s: %.2f hPa", date, pressure));
    }
}
