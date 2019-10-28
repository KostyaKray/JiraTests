package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends  BasePage{

    WebDriver driver = null; //это тоже самое что и без null
    //login
    By userNameInput = By.xpath("//*[@name='os_username']");
    By passwordInput = By.xpath("//*[@name='os_password']");
    By enterButton = By.xpath("//*[@name='login']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get(baseURL+ "/login.jsp");
    }

    public void enterUsername(String name){
        driver.findElement(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public  void clickLogin(){
        driver.findElement(enterButton).click();
    }

    public void Login(String name, String password) {
    enterUsername(name);
    enterPassword(password);
    clickLogin();
    }
}
