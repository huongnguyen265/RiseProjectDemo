package rise.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {
	public By dashboardText = By.xpath( "//span[text()='Dashboard']");
	 private By xpathUser = By.xpath("//a[@id= 'user-dropdown']");
	 public By btnLogOut = By.xpath("//a[contains(normalize-space(),'Sign Out')]");
	 public By clientLink = By.xpath("//span[text()= 'Clients']");
	 public By xpathProject = By.xpath("//span[text()='Projects']//parent::a");

	 private WebDriver driver;
	 public DashBoardPage (WebDriver driver) {
		 this.driver = driver;
	 }
	 public void logOut() {
		 WebElement userProfile= driver.findElement(xpathUser);
		 WebElement btnLogout = driver.findElement(btnLogOut);
		 if(userProfile.isDisplayed()) {
			 userProfile.click();
			 if(btnLogout.isDisplayed()) {
				 btnLogout.click();
			 }
		 } 
	 }
	 public void redirectProject() {
		 WebElement projects = driver.findElement(xpathProject);
		 if(projects.isDisplayed()) {
			 projects.click();
		 }	 
	 }
}
