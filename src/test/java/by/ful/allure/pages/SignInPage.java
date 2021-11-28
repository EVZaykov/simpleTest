package by.ful.allure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public void goTo(String URL){
        this.driver.get(URL);
        this.wait.until(ExpectedConditions.visibilityOf(this.loginField));
    }

    public void enterUserCredentials(String login, String password) {
        this.loginField.sendKeys(login);
        this.passwordField.sendKeys(password);
    }

    public void pushSignInButton(){
        this.signInButton.click();
    }
}
