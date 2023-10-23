package rise.automation.testsute;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rise.automation.common.CommonBase;
import rise.automation.constaint.AccountConstaint;
import rise.automation.page.DashBoardPage;
import rise.automation.page.LoginPage;

public class LogoutTest extends CommonBase{
	@BeforeTest
	public void init() {
	driver= initChromeDriver(AccountConstaint.webURL);
	LoginPage page = new LoginPage(driver);
	page.LoginFuntion("admin@demo.com", "riseDemo");
	}
	@Test (priority = 1)
	public void logOut() {
		DashBoardPage dashboardpage= new DashBoardPage(driver);
		dashboardpage.logOut();
		WebElement expect = driver.findElement(By.xpath("//h2[text()= 'Sign in']"));
		assertTrue(expect.isDisplayed());
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
