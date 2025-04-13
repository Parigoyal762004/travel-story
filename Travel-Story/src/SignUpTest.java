import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class SignUpTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {

            driver.get("http://localhost:5173/signUp"); 
            driver.manage().window().maximize();

            String randomName = "TestUser" + UUID.randomUUID().toString().substring(0, 5);
            String randomEmail = "test" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";
            String password = "Test@123";

 
            WebElement nameField = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
            nameField.sendKeys(randomName);


            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
            emailField.sendKeys(randomEmail);

            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys(password);

            WebElement signUpButton = driver.findElement(By.xpath("//button[text()='CREATE ACCOUNT']"));
            signUpButton.click();


            Thread.sleep(3000); 
            if (driver.getCurrentUrl().contains("/dashboard")) {
                System.out.println("SignUp Test Passed: Successfully redirected to dashboard!");
            } else {
                System.out.println("SignUp Test Failed: Redirection to dashboard unsuccessful.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
            driver.quit();
        }
    }
}
