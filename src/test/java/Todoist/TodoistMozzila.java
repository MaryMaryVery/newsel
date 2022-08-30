package Todoist;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoistMozzila {
    public static WebDriver driver = null;
    private final String baseUrl = "https://todoist.com";


    @Test
    @Order(1)
    public void openBrowser() {
        System.setProperty("webdriver.firefox.driver", "D:/selenium driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
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
/*
    @Test
    @Order(6)
    public void Addproject() throws InterruptedException {
        WebElement project = driver.findElement(By.id("list_holder"));
        Robot rr = null;
        try {
            rr = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        rr.keyPress(KeyEvent.VK_ENTER);
        rr.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }
        /*WebElement name = driver.findElement(By.id("edit_project_modal_field_name"));
        name.sendKeys("12345");
        Thread.sleep(3000);
        WebElement add = driver.findElement(By.id("reactist-modal-box-8"));
        add.click();
        Thread.sleep(1000);*/


    @Test
    @Order(6)
    public void AddTask() throws AWTException, InterruptedException {
        WebElement task = driver.findElement(By.id("quick_add_task_holder"));
        Robot rr = new Robot();
        rr.keyPress(KeyEvent.VK_ENTER);
        rr.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

    }
}

   /* @Test
    @Order(6)
    public String generate(){
        String s = "";
        Random random = new Random();
        for (int i=0; i<4; i++){
            int n = random.nextInt(127-97+1)+97;
            char c =(char)n;
            s+=c;
        }

        int number = random.nextInt(1000)+1000;
        s+=String.valueOf(number);
        s+="@gmail.com";
        return s;
    }


}*/
