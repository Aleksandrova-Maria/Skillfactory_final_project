import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PageDataAnalystTest {
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
    public void DataAnalytics() {
        // Test name: Проверка наличия формы курса "Аналитика данных"
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1536, 824));
        {
            WebElement element = driver.findElement(By.linkText("Программирование"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(3) > .directions__list-link > span")).click();
        vars.put("win2654", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2654").toString());
        js.executeScript("window.scrollTo(0,51.20000076293945)");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("#Type-6-pink .card__additional-img")).click();
        vars.put("win8428", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8428").toString());
    }

    @Test
    public void entryForm() {
        // Test name: Проверка наличия формы для записи на курс
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Записаться на курс")).click();
    }

    @Test
    public void applicationForm() {
        // Test name: Оформление заявки на курс с корректными данными
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));
        {
            WebElement element = driver.findElement(By.linkText("Записаться на курс"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.linkText("Записаться на курс")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("input_1495810359387")).click();
        driver.findElement(By.id("input_1495810359387")).sendKeys("Мария");
        driver.findElement(By.id("input_1495810354468")).click();
        driver.findElement(By.id("input_1495810354468")).sendKeys("mvbugrova@yandex.ru");
        driver.findElement(By.id("input_1495810410810")).click();
        driver.findElement(By.cssSelector("#form518543697 .t-submit")).click();

    }

    @Test
    public void noData() {
        // Test name: Оформление заявки без ввода данных
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Записаться на курс")).click();
        driver.findElement(By.cssSelector("#form518543697 .t-submit")).click();
        {
            WebElement element = driver.findElement(By.linkText("Пожалуйста, заполните все обязательные поля"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.linkText("Пожалуйста, заполните все обязательные поля")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
    }

    @Test
    public void promoCode() {
        // Test name: Проверка наличия окна для введения промокода
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Записаться на курс")).click();
        driver.findElement(By.linkText("У меня есть промокод")).click();
        driver.findElement(By.id("input_1663062898471")).click();
    }

    @Test
    public void playVideoReview() {
        // Test name: Проверка коррекности воспроизведения видеоотзыва на курс
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));
        {
            WebElement element = driver.findElement(By.linkText("Отзывы"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.linkText("Отзывы")).click();
        js.executeScript("window.scrollTo(0,17468)");
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".tn-elem__5845127841689585566105 circle")).click();
        driver.switchTo().frame(9);
        driver.findElement(By.cssSelector(".ytp-fullscreen-button")).click();
        driver.findElement(By.cssSelector(".video-stream")).click();
    }

    @Test
    public void review() {
        // Test name: Проверка корректного перехода по ссылке с отзывом на Яндексе
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));

        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".tn-elem__7133461201692767588884 u")).click();
        vars.put("win8602", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8602").toString());
    }

    @Test
    public void baseFormPay() {
        // Test name: Проверка наличия формы оплаты базового курса
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));

        driver.findElement(By.cssSelector(".tn-elem__6925387551705400815943 > .tn-atom")).click();
    }

    @Test
    public void optimalFormPay() {
        // Test name: Проверка наличия формы оплаты оптимального курса
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));

        driver.findElement(By.cssSelector(".tn-elem__6925387551705400815946 > .tn-atom")).click();
    }

    @Test
    public void vipFormPay() {
        // Test name: Проверка наличия формы оплаты Vip курса
        driver.get("https://skillfactory.ru/data-analyst-pro");
        driver.manage().window().setSize(new Dimension(1536, 824));

        driver.findElement(By.linkText("Оплатить курс сразу")).click();
    }
}



