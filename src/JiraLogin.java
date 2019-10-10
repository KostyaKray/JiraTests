import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class JiraLogin extends BaseTest {

    By userNameInput = By.xpath("//*[@name='os_username']");
    By passwordInput = By.xpath("//*[@name='os_password']");
    By enterButton = By.xpath("//*[@name='login']");
    By avatarOfUser = By.xpath("//*[@title='User profile for Kostya Kray']");
    String userName = "kostyan4ik";
    String password = "kostyan4ik";

    @Test
    public void firstTest() {
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        driver.findElement(userNameInput).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(enterButton).click();
        assertTrue(driver.findElement(enterButton).isDisplayed());
    }

}
