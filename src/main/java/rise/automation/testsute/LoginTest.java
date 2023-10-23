package rise.automation.testsute;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rise.automation.common.CommonBase;
import rise.automation.constaint.AccountConstaint;
import rise.automation.page.DashBoardPage;
import rise.automation.page.LoginPage;

public class LoginTest extends CommonBase {
	@BeforeTest
	public void init() {
	driver= initChromeDriver(AccountConstaint.webURL);	
	}
	/**
	 * Test case validate login function successfully or not in case
	 * NotValid: IncorrectEmail, incorrectPassword, incorrectEmail and password
	 * Valid: Correct email and password
	 */
	@Test (priority = 4)
	public void loginSuccess() {
		LoginPage page = new LoginPage(driver);
		page.LoginFuntion("admin@demo.com", "riseDemo");
		DashBoardPage dashboard = new DashBoardPage(driver);
		WebElement expected = driver.findElement(dashboard.dashboardText);
		assertTrue(expected.isDisplayed());
	}
	@Test (priority = 1)
	public void login_IncorrectEmail() {
		LoginPage page = new LoginPage(driver);
		page.LoginFuntion("admin@demo.com1", "riseDemo");
		WebElement expected= driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
		
	}
	@Test (priority = 2)
	public void login_IncorrectPassword() {
		LoginPage page = new LoginPage(driver);
		page.LoginFuntion("admin@demo.com", "riseDemo1");
		WebElement expected= driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());	
	}
	@Test (priority = 3)
	public void login_IncorrectEmailPassword() {
		LoginPage page = new LoginPage(driver);
		page.LoginFuntion("admin@demo.com1", "riseDemo1");
		WebElement expected= driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());	
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
