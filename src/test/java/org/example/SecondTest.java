package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/");

    }

    @Test
    public void first() {

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        String price_list = driver.findElement(By.xpath("(//div[@class='price-box']/span/span)[1]")).getText();

        driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();

        String price_details = driver.findElement(By.xpath("//div[@class='price-box']/span/span")).getText();

        Assert.assertEquals(price_list,price_details);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
