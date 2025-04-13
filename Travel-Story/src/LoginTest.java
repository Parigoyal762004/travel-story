import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            
            driver.get("http://localhost:5173/login");
            driver.manage().window().maximize();

            
            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
            emailField.sendKeys("goyalpari70@gmail.com"); 

            
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("Sanwaragoyal"); 

            
            WebElement loginButton = driver.findElement(By.xpath("//button[text()='LOGIN']"));
            loginButton.click();

            
            Thread.sleep(3000); 
            if (driver.getCurrentUrl().contains("/dashboard")) {
                System.out.println("Login Test Passed: Successfully redirected to dashboard!");
            } else {
                System.out.println("Login Test Failed: Redirection to dashboard unsuccessful.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}
