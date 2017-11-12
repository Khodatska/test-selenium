import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Winnium {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void start() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Users\\margo\\Desktop\\Calculator_exec_b2\\Calculator.exe");
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), cap);
        wait = new WebDriverWait(driver, 30);

    }

    @Before
    public void cleanup() {
        driver.findElement(By.id("2")).click();

    }

//    @Test
//    public void calculatorTest() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));
//
//        driver.findElement(By.name("1")).click();
//        driver.findElement(By.name("2")).click();
//        driver.findElement(By.name("3")).click();
//        driver.findElement(By.name("+")).click();
//        driver.findElement(By.name("4")).click();
//        driver.findElement(By.name("=")).click();
//
//        Assert.assertEquals("127",driver.findElement(By.id("1000")).getText());
//
//    }


    @Test
    public void add_test() {
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("9",driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void subtraction_test() {
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("-")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("1",driver.findElement(By.id("1000")).getText());  }

    @Test
    public void multiply_test() {
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("*")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("20",driver.findElement(By.id("1000")).getText());    }

    @Test
    public void divide_test() {
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("/")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("3",driver.findElement(By.id("1000")).getText());   }


    @AfterClass
    public static void stop() {

        driver.quit();
    }


}
