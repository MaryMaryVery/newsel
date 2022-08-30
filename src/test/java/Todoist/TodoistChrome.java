package Todoist;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Robot;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoistChrome {
    public static WebDriver driver = null;
    private final String baseUrl = "https://todoist.com";

    @Test
    @Order(1)
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/selenium driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Order(2)
    public void GetTitle() throws InterruptedException {
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().toUpperCase()
                .contains("todoist".toUpperCase()));

    }


    @Test
    @Order(3)
    public void GoToLink() throws InterruptedException {
        driver.get(baseUrl + "/auth/login");
        Thread.sleep(1000);


    }


    @Test
    @Order(4)
    public void SignIn() throws InterruptedException {
        WebElement input = driver.findElement(By.id("element-0"));
        input.sendKeys("kalchenko.marya@gmail.com");
        input = driver.findElement(By.id("element-3"));
        input.sendKeys("seledkasmolokom28");
    }

    @Test
    @Order(5)
    public void PressButton() throws AWTException, InterruptedException {
        WebElement button = driver.findElement(By.id("todoist_app"));
        Robot rr = new Robot();
        rr.keyPress(KeyEvent.VK_ENTER);
        rr.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
    }



    @Test
    @Order(6)
    public void AddTask() throws AWTException, InterruptedException {
        WebElement  task = driver.findElement(By.id("quick_add_task_holder"));
        Robot rr = new Robot();
        rr.keyPress(KeyEvent.VK_ENTER);
        rr.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

    }



    }

