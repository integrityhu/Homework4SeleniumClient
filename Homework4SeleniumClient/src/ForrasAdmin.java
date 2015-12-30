import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

//@RunWith(JUnit4.class)
public class ForrasAdmin {
    private static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    
    @Before
    public void setUp() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(profile);
        baseUrl = "http://win7pro-wlan:8080/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    // @Test
    public void testForras() throws Exception {
        driver.get(baseUrl + "/forras-admin/index.xhtml");
        SeleniumActions.clickMenuById(driver,"adminisztracio");
        driver.findElement(By.id("foglalkozasaim")).click();
        driver.findElement(By.id("j_username")).clear();
        driver.findElement(By.id("j_username")).sendKeys("admin@host.hu");
        driver.findElement(By.id("j_password")).clear();
        driver.findElement(By.id("j_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        SeleniumActions.clickMenuById(driver, "rendszer");
        driver.findElement(By.id("kilepes")).click();
        driver.findElement(By.cssSelector("body")).click();
    }

}
