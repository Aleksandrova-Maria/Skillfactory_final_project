import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Main {
    public static void main(String[] args) {
     System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();

     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
