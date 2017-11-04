import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class CalculatorTests {

    private static WebDriver driver;


    @BeforeClass
    public static void start() {
        File file = new File("C:/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/margo/Desktop/Calc/calc.html");
    }

    @Before
    public void cleanup() {
        driver.findElement(By.xpath("//input[@value='C']")).click();

    }

    @Test
    public void add_test() {
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("9", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void subtraction_test() {
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("1", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void multiply_test() {
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("20", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void divide_test() {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("3", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @AfterClass
    public static void stop() {
        driver.close();
    }

}
