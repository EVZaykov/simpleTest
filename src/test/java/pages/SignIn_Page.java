package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SignIn_Page extends BasePage {
	public @FindBy(xpath = "//input[@name='login']")
    WebElement textfield_Username;
	public @FindBy(xpath = "//input[@name='password']")
    WebElement textfield_Password;
	public @FindBy(xpath = "//input[@value='Sign in']")
    WebElement button_SignIn;
	public @FindBy(xpath = "//div[contains(@class,'flash-error ')]")
    WebElement error_Message;
	public @FindBy(xpath = "//h2[text()='Discover interesting projects and people to populate your personal news feed.']")
    WebElement successful_Login;
	
	public SignIn_Page() throws IOException {
		super();
	}
	
	public SignIn_Page getLoginPage() throws IOException {
		getDriver().get("https://github.com/login");
		return new SignIn_Page();
	}
	
	public SignIn_Page enterUsername(String userName) throws Exception {
		sendKeysToWebElement(textfield_Username, userName);
		return new SignIn_Page();
	}
	
	public SignIn_Page enterPassword(String password) throws Exception {
		sendKeysToWebElement(textfield_Password, password);
		return new SignIn_Page();
	}

	public SignIn_Page clickOnSignInButton() throws Exception {
		waitAndClickElement(button_SignIn);
		return new SignIn_Page();
	}

	public SignIn_Page checkErrorMessage() throws Exception {
		WaitUntilWebElementIsVisible(error_Message);
		return new SignIn_Page();
	}

	public SignIn_Page checkSuccessfulLogin() throws Exception {
		WaitUntilWebElementIsVisible(successful_Login);
		return new SignIn_Page();
	}

}
