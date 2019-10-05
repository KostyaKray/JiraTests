import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class JiraLogin {

  WebDriver driver;

  @BeforeTest
  public void setUp() {
    // Fix for - The path to the driver executable must be set by the webdriver.chrome.driver system property
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Java Projects\\Drivers\\chromedriver.exe");
    // Create a new instance of the Chrome driver
    this.driver = new ChromeDriver();
  }

  By userNameInput = By.xpath("//*[@name='os_username']");
  By passwordInput = By.xpath("//*[@name='os_password']");
  By enterButton = By.xpath("//*[@name='login']");
  By avatarOfUser = By.xpath("//*[@title='User profile for Kostya Kray']");
  String userName = "kostyan4ik";
  String password = "kostyan4ik";

  @Test
  public void firstTest() throws InterruptedException {
    this.driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    this.driver.findElement(userNameInput).sendKeys(userName);
    this.driver.findElement(passwordInput).sendKeys(password);
    this.driver.findElement(enterButton).click();

    Thread.sleep(2000);
    assertTrue(this.driver.findElement(avatarOfUser).isDisplayed());
  }

  @AfterTest
  public void tearDown() {
    // Close the driver
    this.driver.quit();
  }
}

