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


public class TestAddCart {
    WebDriver driver;



    @BeforeClass
        public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\juaracooding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }


        @Test (priority = 1)
        public void url() {
        delay( 3 );
            String url = "https://shop.demoqa.com/";
            driver.get(url);
            System.out.println("Get URL");
            driver.manage().window().maximize();
            System.out.println("Maximize Browser");
            String titleHeader = driver.getTitle();
            System.out.println("Title Header : " + titleHeader);
            Assert.assertEquals(titleHeader, "Shop Demoqa");
        }

        @Test (priority = 2)
        public void addcart () {
        delay( 3);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
            driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")).click(); // 1
            System.out.println("add cart");
            js.executeScript("window.scrollBy(0,1000)");
            System.out.println("=== Delay 3 second===");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.findElement(By.xpath("//*[@id='product-704']/div[1]/div[2]/form/div/div[2]/button")).click(); // 2
            js.executeScript("window.scrollBy(0,400)");
            System.out.println(" Product has been added");
            driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a")).click();  // 3
            js.executeScript("window.scrollBy(0,500)");
            System.out.println("View Cart Product");

            System.out.println("=== Delay 3 second===");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click(); // 4
            System.out.println("proceed checkout");

            //Tesing unit
            WebElement addProduct = driver.findElement(By.xpath(" //*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")); //1
            Assert.assertTrue(addProduct.isDisplayed());
            WebElement addCart = driver.findElement(By.xpath(" ///*[@id='product-704']/div[1]/div[2]/form/div/div[2]/button")); //2
            Assert.assertTrue(addCart.isDisplayed());
            WebElement viewCard = driver.findElement(By.xpath(" //*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a")); //3
            Assert.assertTrue(viewCard.isDisplayed());
            WebElement checkout = driver.findElement(By.xpath(" //*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")); //4
            Assert.assertTrue(checkout.isDisplayed());



        }

        @AfterClass
        public void quitbrowser () {
            delay(3);
            driver.quit();
            System.out.println("Quit Browser");
        }

        static void delay ( int detik){
            try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }






