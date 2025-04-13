import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.UUID;

public class AddTravelStoryTest {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1️⃣ Navigate to the Login Page
            driver.get("http://localhost:5173/login"); // Update with actual URL
            driver.manage().window().maximize();

            // 2️⃣ Login to the Dashboard
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
            emailField.sendKeys("goyalpari70@gmail.com");

            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("Sanwaragoyal");

            WebElement loginButton = driver.findElement(By.xpath("//button[text()='LOGIN']"));
            loginButton.click();

            // Wait for Dashboard to Load
            wait.until(ExpectedConditions.urlContains("/dashboard"));

            // 3️⃣ Click the "ADD STORY" Button on Dashboard
            WebElement addStoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-small') and contains(text(), 'ADD STORY')]")));
            
            // Scroll into view before clicking (in case the button is not visible)
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addStoryButton);
            Thread.sleep(500);

            // Click using JavaScript if normal click fails
            try {
                addStoryButton.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", addStoryButton);
            }

            // 4️⃣ Fill in the Add Story Form
            String randomTitle = "Trip to " + UUID.randomUUID().toString().substring(0, 5);
            String randomStory = "An unforgettable journey full of adventures!";
            String randomLocation = "Paris, France";

            // Enter Title
            WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='A Day at the Great Wall']")));
            titleField.sendKeys(randomTitle);

            // Select Date
            WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='date']")));
            dateField.sendKeys("2024-03-15");

            // Upload Image
            WebElement imageUpload = driver.findElement(By.xpath("//input[@type='file']"));
            imageUpload.sendKeys("C:\\Users\\Admin\\Pictures\\travel_story.jpg"); // Update with actual image path

            // Enter Story
            WebElement storyTextArea = driver.findElement(By.xpath("//textarea[@placeholder='Your Story']"));
            storyTextArea.sendKeys(randomStory);

            // Add Visited Location
            WebElement locationField = driver.findElement(By.xpath("//input[@placeholder='Enter location and press enter']"));
            locationField.sendKeys(randomLocation);
            locationField.submit(); // Simulate pressing "Enter"

            // 5️⃣ Click the "ADD STORY" Button in the Form
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-small') and contains(text(), 'ADD STORY')]")));
            
            // Scroll into view before clicking
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            Thread.sleep(500);

            // Click using JavaScript if normal click fails
            try {
                submitButton.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
            }

            // 6️⃣ Validate Success Message
            Thread.sleep(3000); // Wait for toast message
            if (driver.getPageSource().contains("Story Added Successfully")) {
                System.out.println("✅ Travel Story Added Successfully!");
            } else {
                System.out.println("❌ Failed to Add Travel Story.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
