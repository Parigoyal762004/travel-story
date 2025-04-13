import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        // Set the ChromeDriver path (if not set in system environment variables)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        // 1️⃣ Open the website
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();
        Thread.sleep(2000); // Wait for page to load

        // 2️⃣ Login with username and password
        driver.findElement(By.id("username")).sendKeys("tiet@gmail.com");
        driver.findElement(By.id("password")).sendKeys("tiet@1234#");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000); // Wait for login to complete

        // 3️⃣ Click on “Shop”
        driver.findElement(By.linkText("Shop")).click();
        Thread.sleep(2000);

        // 4️⃣ Click on “JavaScript” from Product Category
        driver.findElement(By.linkText("JavaScript")).click();
        Thread.sleep(2000);

        // 5️⃣ Click on the book “Functional Programming in JS”
        driver.findElement(By.xpath("//h3[text()='Functional Programming in JS']")).click();
        Thread.sleep(2000);

        // 6️⃣ Set Quantity = 2
        WebElement quantityBox = driver.findElement(By.name("quantity"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        // 7️⃣ Click “Add to Basket”
        driver.findElement(By.name("add-to-cart")).click();
        Thread.sleep(2000);

        // 8️⃣ Click on “View Basket”
        driver.findElement(By.linkText("View Basket")).click();
        Thread.sleep(2000);

        // 9️⃣ Click on “Proceed to Checkout”
        driver.findElement(By.linkText("Proceed to Checkout")).click();
        Thread.sleep(2000);

        // 🔟 Close the browser
        driver.quit();
    }
}
