package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ShopAddCart {
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


        // add to cart

  //      driver.get("https://shop.demoqa.com/");
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")).click();
        System.out.println("add cart");
        js.executeScript("window.scrollBy(0,1000)");
        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.xpath("//*[@id='product-704']/div[1]/div[2]/form/div/div[2]/button")).click();
        js.executeScript("window.scrollBy(0,400)");
        System.out.println(" Product has been added");
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a")).click();
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("View Cart Product");
        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click();
        System.out.println("proceed checkout");

        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //checkout
        js.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.name("billing_first_name")).sendKeys("Widya");
        System.out.println("Nama Depan ");
        driver.findElement(By.name("billing_last_name")).sendKeys("Cahyani");
        System.out.println("Nama Panjang ");
        driver.findElement(By.id("billing_company")).sendKeys("-");
        


    //    WebElement selectCountry = null;
        driver.findElement(By.xpath("//*[@id=\"billing_country_field\"]/span/span/span[1]/span/span[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[1]/input[1]")).sendKeys("Indonesia");
//        Select country = new Select(selectCountry);
//        country.selectByIndex(4);
        driver.findElement(By.name("billing_address_1")).sendKeys("Perum Nusa Indah");
        driver.findElement(By.name("billing_address_1")).sendKeys("Kecamatan Tanah Maju");
        driver.findElement(By.name("billing_city")).sendKeys("Jakarta");
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.name("billing_city")).sendKeys("Jakarta");

        WebElement selectProvince = null;
        driver.findElement(By.xpath("//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]")).click();
        Select province = new Select(selectProvince);
        province.selectByIndex(15);
        driver.findElement(By.id("billing_postcode")).sendKeys("123456");
        System.out.println("Postal Code");
        driver.findElement(By.name("billing_phone")).sendKeys("08123456789");
        System.out.println("Phone Number");
        driver.findElement(By.name("billing_email")).sendKeys("widya.cahyani@gmail.com");
        System.out.println(" Email Address ");
        js.executeScript("window.scrollBy(0,500)");


        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.name("terms")).click();
        System.out.println("Term and Condition");
        driver.findElement(By.id("place_order")).click();
        System.out.println("Proser Bayar Ok");







////    add to Whistlist
//        driver.get("https://shop.demoqa.com/");
//        js.executeScript("window.scrollBy(0,1000)");
//        driver.findElement(By.xpath("//*[@id=\"product-704\"]/div[1]/div[2]/div[2]/div/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")).click();
//        js.executeScript("window.scrollBy(0,1000)");
//        System.out.println("=== Delay 3 second===");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e); }

//            driver.findElement(By.id("pa_color")).click(); // pilih warna
//            WebElement selectColor = driver.findElement(By.id("pa_color"));
//            Select color = new Select(selectColor);
//            color.selectByIndex(1);
//
//            WebElement selectSize = driver.findElement(By.id("pa_size"));
//            Select size = new Select(selectSize);
//            color.selectByIndex(1);
//            driver.findElement(By.id("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")).click();
//            driver.findElement(By.id("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")).click();

        }
    }






