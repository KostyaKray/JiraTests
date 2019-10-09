import okio.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import javax.swing.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CreateNewIssue {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Java Projects\\Drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }
    //Main Page
    By userNameInput = By.xpath("//*[@name='os_username']");
    By passwordInput = By.xpath("//*[@name='os_password']");
    By enterButton = By.xpath("//*[@name='login']");
    String userName = "kostyan4ik";
    String password = "kostyan4ik";

    //Dashboard
    By avatarOfUser = By.xpath("//*[@title='User profile for Kostya Kray']");
    By NewTicket = By.xpath("//*[@id='create_link']");
    By ProjectName = By.xpath("//*[@id='project-field']");
    By IssueType = By.xpath("//*[@id='issuetype']");
    By Summary = By.xpath("//*[@id='summary']");
    By Reporter = By.xpath("//*[@id='reporter-field']");
    By Description = By.xpath("//*[@id= 'description']");
    By CreateButton = By.xpath("//*[@class ='aui-button aui-button-primary']");
    By textfield = By.xpath("//*[@class = 'aui-nav-selected'=1]");

    @Test
    public void AddingNewIssue() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();

        //Log in
        this.driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(enterButton).click();
        assertTrue(this.driver.findElement(NewTicket).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='User profile for Kostya Kray']")));

        // Create new issue
        this.driver.findElement(NewTicket).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='summary']")));
      //this.driver.findElement(ProjectName).clear();
      //this.driver.findElement(ProjectName).sendKeys("QAAUTO-8 (QAAUT8)", Keys.ENTER);
      //this.driver.findElement(IssueType).sendKeys("Bug");
        this.driver.findElement(Summary).sendKeys("New issue");
      //this.driver.findElement(Reporter).sendKeys("Kostya Kray");
        this.driver.findElement(textfield).click();
        this.driver.findElement(Description).sendKeys("Description of the issue");
        this.driver.findElement(CreateButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("New issue")));

        // Check that issue is created
        assertTrue(this.driver.findElement(By.partialLinkText("New issue")).isDisplayed());
    }

    @AfterTest
        public void tearDown() { this.driver.quit(); }
}
