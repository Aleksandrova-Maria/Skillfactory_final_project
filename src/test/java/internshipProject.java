import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class internshipProject {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @Test
    public void rostelecom() {
        // Test name: Проверка наличия формы проекта от Ростелеком "Тестировщик-автоматизатор"
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1536, 824));
        js.executeScript("window.scrollTo(0,6.400000095367432)");

        WebElement element = driver.findElement(By.linkText("на курсе «Тестировщик-автоматизатор»"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("на курсе «Тестировщик-автоматизатор»")).click();

        String newWindow = waitForWindow(2000);
        driver.switchTo().window(newWindow);

        String expectedUrl = "https://skillfactory.ru/testirovshik-avtomatizator";
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            System.out.println("Открыт неправильный сайт: " + actualUrl);
            assertEquals("URL не соответствует ожидаемому", expectedUrl, actualUrl);
        } else {
            System.out.println("Открыт правильный сайт: " + actualUrl);
        }
        driver.switchTo().window(vars.get("root").toString());
    }
    @Test
    public void programAvtoTest() {
        // Test name: Проверка доуступности программы курса "Тестировщик-автоматизатор"
        driver.get("https://skillfactory.ru/qa-engineer-python-testirovshchik-programmnogo-obespecheniya");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Программа курса")).click();
        {
            WebElement element = driver.findElement(By.linkText("Программа курса"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
    }

    @Test
    public void getPlace() {
        // Test name: Проверка записи на курс без введенния данных
        driver.get("https://skillfactory.ru/qa-engineer-python-testirovshchik-programmnogo-obespecheniya");
        driver.manage().window().setSize(new Dimension(1536, 824));

        driver.findElement(By.cssSelector(".tn-form__submit:nth-child(10) > .t-submit")).click();

        js.executeScript("window.scrollTo(0, 51.20000076293945)");

        String expectedWarningText = "Обязательное поле";
        WebElement warningElement = driver.findElement(By.cssSelector(".t-input-error"));

        if (warningElement.isDisplayed()) {
            String actualWarningText = warningElement.getText();
            assertEquals("Текст предупреждения не соответствует ожидаемому", expectedWarningText, actualWarningText);
        } else {
            fail("Предупреждение не отображается, хотя должно было");
        }
    }

    @Test
    public void volgaCTF() {
        // Test name: Проверка наличия формы проекта от VolgaCTF "Белый хакер"
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1536, 824));

        js.executeScript("window.scrollTo(0, 1501.5999755859375)");
        js.executeScript("window.scrollTo(0, 3000)");

        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("#green a")).click();

        String newWindow = waitForWindow(2000);
        driver.switchTo().window(newWindow);

        String expectedUrl = "https://skillfactory.ru/cyber-security-etichnij-haker";
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            System.out.println("Открыт неправильный сайт: " + actualUrl);
            assertEquals("URL не соответствует ожидаемому", expectedUrl, actualUrl);
        } else {
            System.out.println("Открыт правильный сайт: " + actualUrl);
        }
        driver.switchTo().window(vars.get("root").toString());
    }

    @Test
    public void courseProgram() {
        // Test name: Проверка доуступности программы курса "Белый хакер"
        driver.get("https://skillfactory.ru/cyber-security-etichnij-haker");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Программа курса")).click();
        {
            WebElement element = driver.findElement(By.linkText("Программа курса"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
    }

    @Test
    public void singUpForWhiteHaker() {
        // Test name: Проверка доступности записи на курс
        driver.get("https://skillfactory.ru/cyber-security-etichnij-haker");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Записаться на курс")).click();
    }

    @Test
    public void getProgram() {
        // Test name: Проверка всплывающего окна при получении курса без ввода данных
        driver.get("https://skillfactory.ru/cyber-security-etichnij-haker");
        driver.manage().window().setSize(new Dimension(1536, 824));

        driver.findElement(By.className(".t-submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement warningElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".t-form__errorbox-item")));

        String expectedWarningText = "Пожалуйста, заполните все обязательные поля";
        String actualWarningText = warningElement.getText();

        assertEquals("Текст предупреждения не соответствует ожидаемому", expectedWarningText, actualWarningText);
    }

    @Test
    public void shopiland() {
        // Test name: Проверка наличия формы проекта от Shopiland "Тестировщик-автоматизатор"
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1536, 824));

        js.executeScript("window.scrollTo(0, 1020)");
        js.executeScript("window.scrollTo(0, 2800)");

        WebElement element = driver.findElement(By.cssSelector("#pink a"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("#pink a")).click();

        String newWindow = waitForWindow(2000);
        driver.switchTo().window(newWindow);

        String expectedUrl = "https://skillfactory/shopiland.ru";  // Указан ожидаемый URL
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            System.out.println("Открыт неправильный сайт: " + actualUrl);
            assertEquals("URL не соответствует ожидаемому", expectedUrl, actualUrl);
        } else {
            System.out.println("Открыт правильный сайт: " + actualUrl);
        }

        driver.switchTo().window(vars.get("root").toString());
        WebElement body = driver.findElement(By.tagName("body"));
        builder.moveToElement(body, 0, 0).perform();
    }


    @Test
    public void sCan() {
        // Test name: Проверка наличия формы проекта от SCan «Fullstack-разработчик»
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1536, 824));

        js.executeScript("window.scrollTo(0, 998.4000244140625)");
        js.executeScript("window.scrollTo(0, 2201.60009765625)");

        WebElement element = driver.findElement(By.linkText("на курсе «Fullstack-разработчик»"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("на курсе «Fullstack-разработчик»")).click();

        String newWindow = waitForWindow(2000);
        driver.switchTo().window(newWindow);

        String expectedUrl = "https://skillfactory.ru/python-fullstack-web-developer";
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            System.out.println("Открыт неправильный сайт: " + actualUrl);
            assertEquals("URL не соответствует ожидаемому", expectedUrl, actualUrl);
        } else {
            System.out.println("Открыт правильный сайт: " + actualUrl);
        }

        driver.switchTo().window(vars.get("root").toString());
        WebElement body = driver.findElement(By.tagName("body"));
        builder.moveToElement(body, 0, 0).perform();
    }
    @Test
    public void fullstackProgram() {
        // Test name: Проверка доступности формы записи на курс
        driver.get("https://skillfactory.ru/python-fullstack-web-developer");

        driver.manage().window().setSize(new Dimension(1536, 824));
        js.executeScript("window.scrollTo(0,517.5999755859375)");
        driver.findElement(By.linkText("Записаться на курс")).click();

    }
}







