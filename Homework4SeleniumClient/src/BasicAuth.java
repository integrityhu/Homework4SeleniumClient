import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(JUnit4.class)
public class BasicAuth {
    private static WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    
	@Before
    public void setUp() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(profile);
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
	
    @Test
    public void testBasicAturh() throws Exception {
        login(baseUrl + "/Homework4BaseAuth/admin/index.html", "admin@host.hu", "admin");
    }

    public void login(String url, String username, String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        try {
            driver.get(url);
        } catch (TimeoutException e) {

        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();// .authenticateUsing(credentials);
        alert.sendKeys(username);
        Robot robot;
		try {
			robot = new Robot();
			SeleniumActions.pressTabKey(robot);
			Thread.sleep(2000);
			SeleniumActions.typeKeys(robot, password);
			Thread.sleep(2000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        
        alert.accept();        
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
