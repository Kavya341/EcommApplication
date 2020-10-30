package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FifthTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/");

    }

    @Test
    public void first() throws InterruptedException {

        driver.findElement(By.xpath("(//a[@title='My Account'])[2]")).click();
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.id("firstname")).sendKeys("Test");
        driver.findElement(By.id("lastname")).sendKeys("User");
        driver.findElement(By.id("email_address")).sendKeys("test@gmail.com.au");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        driver.findElement(By.cssSelector("li.level0.nav-2.last>a")).click();
        driver.findElement(By.xpath("(//a[text()='Add to Wishlist'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();

        driver.findElement(By.id("email_address")).sendKeys("test@gmail.com.au");
        driver.findElement(By.id("message")).sendKeys("some message");
        driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();

        String actual = driver.findElement(By.cssSelector("li.success-msg>ul>li>span")).getText();
        Assert.assertEquals(actual,"Your Wishlist has been shared.");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
