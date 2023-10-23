package rise.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	 private By txtemail= By.xpath("//input[@id='email']");
	 private By txtpassword = By.xpath("//input[@id='password']");
	 private By buttonLogin = By.xpath("//button[text()='Sign in']");
	 public By authenFailText= By.xpath("//div[normalize-space()='Authentication failed!' and @role='alert']") ;
	 public LoginPage (WebDriver driver) {
		 this.driver = driver;
	 }
	 public void LoginFuntion (String email, String password) {
		 WebElement textboxEmail = driver.findElement(txtemail);
		 if(textboxEmail.isDisplayed()) {
			 textboxEmail.clear();
			 textboxEmail.sendKeys(email);
		 }
		 WebElement textboxPassword = driver.findElement(txtpassword);
		 if(textboxPassword.isDisplayed()) {
			 textboxPassword.clear();
			 textboxPassword.sendKeys(password);
		 }
		 WebElement btnLogin = driver.findElement(buttonLogin);
		 if(btnLogin.isDisplayed()) {
			 btnLogin.click();
		 }
	 }
}
