package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ShopLogin {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\juaracooding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://shop.demoqa.com/";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");



        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("/html/body/p/a")).click();
        driver.get("https://shop.demoqa.com/my-account/");

        // login
        driver.findElement(By.name("username")).sendKeys("Widya");
        driver.findElement(By.id("password")).sendKeys("Cobacoba123");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span")).click(); //show password
        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }

        driver.findElement(By.name( "rememberme")).click();
        driver.findElement(By.name("login")).click();
        js.executeScript("window.scrollBy(0,1000)"); // pada saat ini web eror login
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/a")).click(); //  lost your password
        js.executeScript("window.scrollBy(0,500)"); // new windows scroll
        driver.findElement(By.name("user_login")).sendKeys("Widya"); // forgot password user login
        driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/p[3]/button")).click(); // reset pass button
        System.out.println("Login done");


    }
}
