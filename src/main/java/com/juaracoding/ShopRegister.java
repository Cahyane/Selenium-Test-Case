package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShopRegister {
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

        //register
        driver.findElement(By.id("reg_username")).sendKeys("Widya");
        driver.findElement(By.name("email")).sendKeys("widya.cahyani@gmail.com");
        driver.findElement(By.id("reg_password")).sendKeys("Cobacoba123");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/span/span")).click(); //show password
        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
        driver.findElement(By.xpath(" //*[@id=\"customer_login\"]/div[2]/form/p[4]/button")).click();
        js.executeScript("window.scrollBy(0,500)");
        System.out.println(" Register done");

    }
}
