import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

//@RunWith(JUnit4.class)
public class JavaConv {
    private static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(profile);
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /*
     * http://sqa.stackexchange.com/questions/12892/how-to-send-basic-authentication
     * -headers-in-selenium
     */

    @Test
    public void testJavaConv() throws Exception {
        driver.get(baseUrl + "/geoserver/web/?wicket:bookmarkablePage=:org.geoserver.web.demo.ReprojectPage");
        // ERROR: Caught exception [Error: locator strategy either id or name
        // must be specified explicitly.]
        driver.findElement(By.name("\"targetCRS:srs\"")).clear();
        driver.findElement(By.name("\"targetCRS:srs\"")).sendKeys("EPSG:63266405");
        driver.findElement(By.name("\"sourceGeom\"")).clear();
        driver.findElement(By.name("\"sourceGeom\"")).sendKeys("779790.55 308720.15");
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
