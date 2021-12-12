package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Main page")
public class MainPage extends BasePage {

    @ElementTitle(value = "Create new repository")
    @FindBy(xpath = "//a[@href='/new' and contains(@class,'btn')]")
    public WebElement createNewReposButton;

    @ElementTitle(value = "Password field")
    @FindBy(xpath = "//input[@name='password']")
    public WebElement textField_Password;

    @ElementTitle(value = "SignIn button")
    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement button_SignIn;

    @ElementTitle(value = "Error message")
    @FindBy(xpath = "//div[contains(@class,'flash-error ')]")
    public WebElement error_Message;

    @ElementTitle(value = "Successful login")
    @FindBy(xpath = "//h2[text()='Discover interesting projects and people to populate your personal news feed.']")
    public WebElement successful_Login;

}
