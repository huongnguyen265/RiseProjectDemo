package rise.automation.testsute;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rise.automation.common.CommonBase;
import rise.automation.constaint.AccountConstaint;
import rise.automation.page.DashBoardPage;
import rise.automation.page.LoginPage;
import rise.automation.page.ProjectsPage;

public class ProjectsTestShowAndHiddenCol extends CommonBase {
	@BeforeTest
	public void init() {
	driver= initChromeDriver(AccountConstaint.webURL);	
	LoginPage page = new LoginPage(driver);
	page.LoginFuntion("admin@demo.com", "riseDemo");
	DashBoardPage dashboard = new DashBoardPage(driver);
	dashboard.redirectProject();
	}
	/**
	 * Test case test show one or more column 
	 * Test case test hidden one or more column
	 * @throws InterruptedException
	 */
	@Test(priority= 1)
	public void checkDisplayDefault() throws InterruptedException {
		pause(3000);
		ProjectsPage project = new ProjectsPage(driver);
		boolean expect = project.checkColDisplayDefault();
		Assert.assertEquals(expect, true);
	}
	@Test (priority = 2)

	public void hiddenOneCol() throws InterruptedException  {
		pause(3000);
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenOneColumnID("//th[text()= 'ID']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 3)
	public void DisplayOneColumn()throws InterruptedException {
		pause(3000);
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayOneColumnID("//th[text()= 'ID']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 4)
	public void hiddenTwoCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenTwoColumn("//th[text()= 'ID']","//th[text()= 'Title']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 5)
	public void showTwoCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayTwoColumn("//th[text()= 'ID']","//th[text()= 'Title']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 6)
	public void hiddenThreeCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenThreeColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 7)
	public void showThreeCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayThreeColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 8)
	public void hiddenFourCol() throws InterruptedException  {		pause(3000);
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenFourColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 9)
	public void showFourCol() throws InterruptedException{
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayFourColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 10)
	public void hiddenFiveCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenFiveColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//li[text()= 'Start date']" );
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 11)
	public void showFiveCol()throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayFiveColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 12)
	public void hiddenSixCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenSixColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']" ,"//th[text()= 'Deadline']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 13)
	public void showSixCol() throws InterruptedException{
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displaySixColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']","//th[text()= 'Deadline']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 14)
	public void hiddenSevenCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenSevenColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']" ,"//th[text()= 'Deadline']","//th[text()= 'Progress']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 15)
	public void showSevenCol() throws InterruptedException{
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displaySevenColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']","//th[text()= 'Deadline']","//th[text()= 'Progress']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 16)
	public void hiddenEightCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenEightColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']" ,"//th[text()= 'Deadline']","//th[text()= 'Progress']","//th[text()= 'Status']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 17)
	public void showEightCol()throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayEightColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']","//th[text()= 'Deadline']","//th[text()= 'Progress']","//th[text()= 'Status']");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 18)
	public void hiddenNineCol() throws InterruptedException {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.hiddenNineColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']" ,"//th[text()= 'Deadline']","//th[text()= 'Progress']","//th[text()= 'Status']","(//table[@id= 'project-table']//child::th)[9]");
		Assert.assertEquals(actual, true);
	}
	@Test (priority = 19)
	public void showNineCol() {
		ProjectsPage project = new ProjectsPage(driver);
		boolean actual = project.displayNineColumn("//th[text()= 'ID']","//th[text()= 'Title']","//th[text()= 'Client']","//th[text()= 'Price']",
				"//th[text()= 'Start date']","//th[text()= 'Deadline']","//th[text()= 'Progress']","//th[text()= 'Status']","(//table[@id= 'project-table']//child::th)[9]");
		Assert.assertEquals(actual, true);
	}
	@AfterTest
	public void closePage() {
		driver.close();
	}
}
