package rise.automation.testsute;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rise.automation.common.CommonBase;
import rise.automation.constaint.AccountConstaint;
import rise.automation.page.DashBoardPage;
import rise.automation.page.LoginPage;
import rise.automation.page.ProjectsPage;
public class ProjectFillter extends CommonBase{
	@BeforeTest
	public void init() {
	driver= initChromeDriver(AccountConstaint.webURL);	
	LoginPage page = new LoginPage(driver);
	page.LoginFuntion("admin@demo.com", "riseDemo");
	DashBoardPage dashboard = new DashBoardPage(driver);
	dashboard.redirectProject();
	}
	@Test (priority =1)
	public void checkFilterHighProject() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		Thread.sleep(1000);
		project.filterHighProject();
		pause(3000);
		boolean expect = project.checkRecordByLabel(2, "High Priority");
		project.clearFilter();
		assertEquals(expect, true);
	}
	@Test (priority =2)
	public void checkFilterUpcomingProject() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		Thread.sleep(1000);
		project.filterUpcomingProject();
		pause(3000);
		boolean expect =  project.checkRecordByLabel(2, "Upcoming");
		project.clearFilter();
		assertEquals(expect, true);
	}
	@Test (priority =3)
	public void checkFilterOpenProject() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		Thread.sleep(1000);
		project.filterOpenProject();
		pause(3000);
		boolean expect= project.checkRecordByStatus(8, "Open");
		assertEquals(expect, true);
		project.clearFilter();
	}
	@Test (priority =4)
	public void checkFilterCompleteProject() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		Thread.sleep(1000);
		project.filterCompletedProject();
		pause(3000);
		boolean expect= project.checkRecordByStatus(8, "Completed");
		assertEquals(expect, true);
		project.clearFilter();
	}
	@Test (priority =5)
	public void checkFilterAllProject() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		Thread.sleep(1000);
		boolean expect= project.checkTotalProject();
		assertEquals(expect, true);
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
