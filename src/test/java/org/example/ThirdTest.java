package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThirdTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/");

    }

    @Test
    public void first() {
        String actual;

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("(//button[@title='Add to Cart'])[1]")).click();
        driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("1000");
        driver.findElement(By.xpath("//button[@title='Update']")).click();
        actual = driver.findElement(By.xpath("//li[@class='error-msg']/ul/li/span")).getText();
        Assert.assertEquals(actual,"Some of the products cannot be ordered in requested quantity.");

        driver.findElement(By.xpath("//button[@title='Empty Cart']")).click();
        actual = driver.findElement(By.cssSelector("div.col-main>div>h1")).getText();
        Assert.assertEquals(actual,"SHOPPING CART IS EMPTY");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
