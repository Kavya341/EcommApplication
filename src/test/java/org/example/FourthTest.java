package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class FourthTest {

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
        driver.findElement(By.xpath("(//a[text()='Add to Compare'])[1]")).click();
        driver.findElement(By.xpath("(//a[text()='Add to Compare'])[2]")).click();
        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();

        String parent = itr.next();
        String child = itr.next();

        driver.switchTo().window(child);
        String expected_heading = "COMPARE PRODUCTS";
        String actual_heading = driver.findElement(By.cssSelector("div.page-title.title-buttons>h1")).getText();
        String mobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
        String mobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
        // Heading check
        Assert.assertEquals(expected_heading, actual_heading);

        // Mobile selected check
        Assert.assertEquals("IPHONE", mobile1);
        Assert.assertEquals("SONY XPERIA", mobile2);

        driver.findElement(By.cssSelector("button[title='Close Window']")).click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
