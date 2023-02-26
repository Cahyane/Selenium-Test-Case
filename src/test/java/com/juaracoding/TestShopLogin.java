package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestShopLogin {
    WebDriver driver;
    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracooding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void url ()
    {
        String url = "https://shop.demoqa.com/";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String titleHeader = driver.getTitle();
        System.out.println("Title Header : " +titleHeader);
        Assert.assertEquals(titleHeader, "Shop Demoqa");

    }


    @Test (priority = 2)
    public void login()
    {
        driver.findElement(By.name("username")).sendKeys("Widya"); // 1
        driver.findElement(By.id("password")).sendKeys("Cobacoba123"); // 2
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span")).click(); //show password // 3
        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }

        driver.findElement(By.name( "rememberme")).click(); // 4
        driver.findElement(By.name("login")).click(); // 5
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/a")).click(); // 6
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.name("user_login")).sendKeys("Widya"); //7
        driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/p[3]/button")).click(); // 8
        System.out.println("Login done");

        // testing unit
        String txtName = driver.findElement(By.xpath("//*[@id=\"username\"]")).getText();
        Assert.assertTrue(txtName.contains("Widya")); // 1
        String txtPasword = driver.findElement(By.xpath("//*[@id=\"password\"]")).getText();
        Assert.assertTrue(txtPasword.contains("Cobacoba123")); // 2

        WebElement displayPasswrod = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span")); // 3
        Assert.assertTrue(displayPasswrod.isDisplayed());

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"rememberme\"]")); // 4
        Assert.assertTrue(checkbox.isDisplayed());
        WebElement login = driver.findElement(By.xpath("\"//*[@id=\\\"customer_login\\\"]/div[1]/form/p[4]/a\"")); // 5
        Assert.assertFalse(login.isEnabled());

        WebElement submitforgotPass = driver.findElement(By.xpath("\"//*[@id=\\\"customer_login\\\"]/div[1]/form/p[4]/a\"")); // 6
        Assert.assertTrue(submitforgotPass.isDisplayed());
        String txtLogin = driver.findElement(By.xpath("//*[@id=\"username\"]")).getText();
        Assert.assertTrue(txtLogin.contains("Widya")); // 7
        WebElement resetPassword = driver.findElement(By.xpath(" /html[1]/body[1]/div[1]/div[2]/main[1]/article[1]/div[1]/div[1]/form[1]/p[3]/button[1]")); //8
        Assert.assertTrue(resetPassword.isDisplayed());

    }





}
