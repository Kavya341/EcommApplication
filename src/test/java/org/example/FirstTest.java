package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/");

    }

    // Verify title of home page
    @Test
    public void first() {

        String actual = driver.getTitle();
        Assert.assertEquals(actual, "Home page");

    }

    // Verify title after clicking on mobile link
    @Test
    public void second() {

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "Mobile");

    }

    // Verify if products are sorted by name
    @Test
    public void third() {

        Select sel = new Select(driver.findElement(By.xpath("//select[@title='Sort By']")));
        sel.selectByIndex(1);

        List<WebElement> phone_list = driver.findElements(By.cssSelector("div.product-info>h2>a"));

        // Copy list to a array list
        ArrayList<String> actual_list = new ArrayList<>();
        for (WebElement e : phone_list) {
            actual_list.add(e.getText());
        }

        // Create a temporary array and sort the array
        ArrayList<String> sorted_list = new ArrayList<>();
        for (String s : actual_list) {
            sorted_list.add(s);
        }
        Collections.sort(sorted_list);

        // Compare sorted array with original array
        Assert.assertEquals(sorted_list, actual_list);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
