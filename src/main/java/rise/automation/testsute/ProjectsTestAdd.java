package rise.automation.testsute;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rise.automation.common.CommonBase;
import rise.automation.constaint.AccountConstaint;
import rise.automation.page.DashBoardPage;
import rise.automation.page.LoginPage;
import rise.automation.page.ProjectsPage;

public class ProjectsTestAdd extends CommonBase{
	/**
	 * Add project successfully and compare result
	 */
	@BeforeTest
	public void init() {
		driver= initChromeDriver(AccountConstaint.webURL);	
		LoginPage page = new LoginPage(driver);
		page.LoginFuntion("admin@demo.com", "riseDemo");
		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.redirectProject();
	}
	@Test
	public void loginSuccessfully() throws InterruptedException {
	    Random random = new Random();
		String name = "huongnl"+random.nextInt(10000);
		ProjectsPage addProjects = new ProjectsPage(driver);
		addProjects.AddProject( name, "10-10-2023", "On track","Perfect");
		addProjects.search(name);
		System.out.println("Name " +name);
		boolean expect =  addProjects.checkRecordByName(2, name);
		
		assertEquals(expect, true);
		
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}
