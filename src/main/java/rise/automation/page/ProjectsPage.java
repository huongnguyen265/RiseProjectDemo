package rise.automation.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rise.automation.common.CommonBase;

public class ProjectsPage extends CommonBase {
	 private WebDriver driver;
	 public By xpathBtnEditCol = By.xpath("//button[@class='btn btn-default column-show-hide-popover']");
	 public By xpathId = By.xpath("//li[text()= 'ID']");
	 public By xpathTitle = By.xpath("//li[text()= 'Title']");
	 public By xpathClient = By.xpath("//li[text()= 'Client']");
	 public By xpathPrice= By.xpath("//li[text()= 'Price']");
	 public By xpathStartDate= By.xpath("//li[text()= 'Start date']");
	 public By xpathDeadline= By.xpath("//li[text()= 'Deadline']");
	 public By xpathProgress= By.xpath("//li[text()= 'Progress']");
	 public By xpathStatus= By.xpath("//li[text()= 'Status']");
	 public By xpathLine= By.xpath("//li[@data-column= '10']");
 
	 public By xpathColId= By.xpath("//th[text()= 'ID']");
	 public By xpathColTitle= By.xpath("//th[text()= 'Title']");
	 public By xpathColClient= By.xpath("//th[text()= 'Client']");
	 public By xpathColPrice= By.xpath("//th[text()= 'Price']");
	 public By xpathColStartdate= By.xpath("//th[text()= 'Start date']");
	 public By xpathColDeadline= By.xpath("//th[text()= 'Deadline']");
	 public By xpathColProgress= By.xpath("//th[text()= 'Progress']");
	 public By xpathColStatus= By.xpath("//th[text()= 'Status']");
	 public By xpathColLine= By.xpath("(//table[@id= 'project-table']//child::th)[9]");
	 public By xpathNoRecord = By.xpath("//td[text()= 'No record found.']");
	 public By xpathDeleteID1 = By.xpath("(//a[@title= 'Delete project'])[1]");
	 public By xpathBtnConfirmDele=  By.xpath("//button[@id= 'confirmDeleteButton']");
	 public By button_Next = By.xpath("//li[@id= 'project-table_next']//child::a");
	 
	 private By buttonProjects = By.xpath("//span[text()='Projects' and @class='menu-text ']");
	 private By buttonAddProjects = By.xpath("//a[text()=' Add project' and @title='Add project' ]");
	 private By txtTitle = By.id("title");
	 private By buttonSave = By.xpath("//button[@type='submit' and text()=' Save']");
	 private By start_Date = By.xpath("//input[@name='start_date']");
	 private By label = By.xpath("//input[@id='s2id_autogen8']");
	 private By inputSearch = By.xpath("//input[@type= 'search']");
	 
	 public ProjectsPage (WebDriver driver) {
		 this.driver = driver;
	 }
	 
	public void AddProject( String title, String start_date, String label1,String label2  ) {
			click(buttonProjects);
			click(buttonAddProjects);
			type(txtTitle, title);
			type(start_Date, start_date);
			type(label, label1);
			driver.findElement(label).sendKeys(Keys.TAB);
			type(label, label2);
			driver.findElement(label).sendKeys(Keys.TAB);
			click(buttonSave);	
		}
	 public void search(String stg) {
		 driver.findElement(inputSearch).sendKeys(stg);
	 }
	 public boolean checkColDisplayDefault() throws InterruptedException {
		 WebElement colId = driver.findElement(xpathColId);
		 System.out.println("1");
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 System.out.println("2");
		 WebElement colClient = driver.findElement(xpathColClient);
		 System.out.println("3");
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 System.out.println("4");
		 WebElement colStartdate = driver.findElement(xpathColStartdate);
		 System.out.println("5");
		 WebElement colDeadline = driver.findElement(xpathColDeadline);
		 System.out.println("6");
		 WebElement colProgress = driver.findElement(xpathColProgress);
		 System.out.println("7");
		 WebElement colStatus = driver.findElement(xpathColStatus);
		 System.out.println("8");
		 WebElement colLine = driver.findElement(xpathColLine);
		 System.out.println("9");
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed() && colPrice.isDisplayed() && colStartdate.isDisplayed() 
				 && colDeadline.isDisplayed() && colProgress.isDisplayed() && colStatus.isDisplayed() && colLine.isDisplayed() ) {
			 System.out.println("10");
			return true;
		 }

		 else {
			 System.out.println("11");
			 return false;
		 }
		
	 }
	// Ẩn 1 cột ID 
	 public boolean hiddenOneColumnID(String element) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 if(colId.isDisplayed()) {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
			 }
		 } 
		 return !isElementDisplayed(driver,element);
	 }
	// Hiện 1 cột ID 
	 public boolean displayOneColumnID(String element) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,element)) {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
			 }
		 } 
		 return isElementDisplayed(driver,element);
	 }
	// Ẩn 2 cột ID, Title 
	 public boolean hiddenTwoColumn(String e1, String e2) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 if(colId.isDisplayed() && colTitle.isDisplayed()) {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
			 }
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2);
	 }
	 //Hiện 2 cột ID, Title
	 public boolean displayTwoColumn(String e1, String e2) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2)) {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2);
	 }
	// Ẩn 3 cột ID, Title, Clients 
	 public boolean hiddenThreeColumn(String e1, String e2, String e3) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()) {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
			 }
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3);
	 }
	 //Hiện 3 cột ID, Title, Clients
	 public boolean displayThreeColumn(String e1, String e2, String e3) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3)) {
			 if(btnEditColumns.isDisplayed()) 
			 {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3);
	 }
	 // Ẩn 4 cột ID, Title, Clients, Price
	 public boolean hiddenFourColumn(String e1, String e2, String e3, String e4) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()&& colPrice.isDisplayed() ) {
			 if(btnEditColumns.isDisplayed()) 
			 {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();
			 }
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4);
	 }
	 // Hiện 4 cột ID, Title, Clients, Price
	 public boolean displayFourColumn(String e1, String e2, String e3,String e4) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4)) {
			 if(btnEditColumns.isDisplayed()) 
			 {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3) && isElementDisplayed(driver, e4);
	 }
	 //Ẩn 5 cột ID, Title, Clents, Price, Start date
	 public boolean hiddenFiveColumn(String e1, String e2, String e3, String e4, String e5) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 WebElement colStartdate = driver.findElement(xpathColStartdate);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()&& colPrice.isDisplayed() 
				 && colStartdate.isDisplayed() ) 
		 {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();
			 }
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4)
				  && !isElementDisplayed(driver, e5);
	 }
	 //Hiển 5 cột ID, Title, Clents, Price, Start date 
	 public boolean displayFiveColumn(String e1, String e2, String e3,String e4, String e5) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4) && !isElementDisplayed(driver, e5)) {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 Thread.sleep(5000);
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 Thread.sleep(5000);
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3) && isElementDisplayed(driver, e4)
				 && isElementDisplayed(driver,e5);
	 }
	 //Ẩn 6 cột ID, Title, Clents, Price, Start date , Deadline
	 public boolean hiddenSixColumn(String e1, String e2, String e3, String e4, String e5, String e6) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 WebElement colStartdate = driver.findElement(xpathColStartdate);
		 WebElement colDealine = driver.findElement(xpathColDeadline);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()&& colPrice.isDisplayed() 
				 && colStartdate.isDisplayed()&& colDealine.isDisplayed() ) 
		 {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
			 }
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4)
				  && !isElementDisplayed(driver, e5) && !isElementDisplayed(driver, e6);
	 }
	 //Hiện 6 cột ID, Title, Clents, Price, Start date , Deadline	 
	 public boolean displaySixColumn(String e1, String e2, String e3,String e4, String e5, String e6) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4) 
				 && !isElementDisplayed(driver, e5) && !isElementDisplayed(driver, e6)) 
		 {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3) && isElementDisplayed(driver, e4)
				 && isElementDisplayed(driver,e5)  && isElementDisplayed(driver,e6);
	 }
	 //Ẩn 7 cột ID, Title, Clents, Price, Start date , Deadline, Progress
	 public boolean hiddenSevenColumn(String e1, String e2, String e3, String e4, String e5, String e6,String e7) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 WebElement colStartdate = driver.findElement(xpathColStartdate);
		 WebElement colDealine = driver.findElement(xpathColDeadline);
		 WebElement colProgress = driver.findElement(xpathColProgress);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()&& colPrice.isDisplayed() 
				 && colStartdate.isDisplayed()&& colDealine.isDisplayed() && colProgress.isDisplayed()) {
			 if(btnEditColumns.isDisplayed()) 
			 {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
				 btnEditColumns.click();
				 driver.findElement(xpathProgress).click();
			 }
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4)
				  && !isElementDisplayed(driver, e5)&& !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e7);
	 }
	 //Hiện 7 cột ID, Title, Clents, Price, Start date , Deadline, Progress	 
	 public boolean displaySevenColumn(String e1, String e2, String e3,String e4, String e5, String e6, String e7) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4) 
				 && !isElementDisplayed(driver, e5) && !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e7)) {
			 if(btnEditColumns.isDisplayed()) 
			 {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
				 btnEditColumns.click();
				 driver.findElement(xpathProgress).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3) && isElementDisplayed(driver, e4)
				 && isElementDisplayed(driver,e5)  && isElementDisplayed(driver,e6)&& isElementDisplayed(driver, e6) && isElementDisplayed(driver, e7);
	 }
	 //Ẩn 8 cột ID, Title, Clents, Price, Start date , Deadline, Progress, Status 
	 public boolean hiddenEightColumn(String e1, String e2, String e3, String e4, String e5, String e6,String e7,String e8) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 WebElement colStartdate = driver.findElement(xpathColStartdate);
		 WebElement colDealine = driver.findElement(xpathColDeadline);
		 WebElement colProgress = driver.findElement(xpathColProgress);
		 WebElement colStatus = driver.findElement(xpathColStatus);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()&& colPrice.isDisplayed() 
				 && colStartdate.isDisplayed()&& colDealine.isDisplayed() && colProgress.isDisplayed()&& colStatus.isDisplayed()) {
			 if(btnEditColumns.isDisplayed()) 
			 {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
				 btnEditColumns.click();
				 driver.findElement(xpathProgress).click();
				 btnEditColumns.click();
				 driver.findElement(xpathStatus).click();
			 }
			 
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4)
				  && !isElementDisplayed(driver, e5)&& !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e7)
				  && !isElementDisplayed(driver, e8);
	 }
	 //Hiện 8 cột ID, Title, Clents, Price, Start date , Deadline, Progress, Status 	 
	 public boolean displayEightColumn(String e1, String e2, String e3,String e4, String e5, String e6,String e7, String e8) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4) 
				 && !isElementDisplayed(driver, e5) && !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e7)&& !isElementDisplayed(driver, e8)) 
		 {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
				 btnEditColumns.click();
				 driver.findElement(xpathProgress).click();
				 btnEditColumns.click();
				 driver.findElement(xpathStatus).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3) && isElementDisplayed(driver, e4)
				 && isElementDisplayed(driver,e5)  && isElementDisplayed(driver,e6)&& isElementDisplayed(driver, e7)
				 && isElementDisplayed(driver, e8);
	 }
	 //Ẩn 9 cột ID, Title, Clents, Price, Start date , Deadline, Progress, Status , Line	 
	 public boolean hiddenNineColumn(String e1, String e2, String e3, String e4, String e5, String e6,String e7,String e8, String e9) throws InterruptedException {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 WebElement colId = driver.findElement(xpathColId);
		 WebElement colTitle = driver.findElement(xpathColTitle);
		 WebElement colClient = driver.findElement(xpathColClient);
		 WebElement colPrice = driver.findElement(xpathColPrice);
		 WebElement colStartdate = driver.findElement(xpathColStartdate);
		 WebElement colDealine = driver.findElement(xpathColDeadline);
		 WebElement colProgress = driver.findElement(xpathColProgress);
		 WebElement colStatus = driver.findElement(xpathColStatus);
		 WebElement colLine = driver.findElement(xpathColLine);
		 if(colId.isDisplayed() && colTitle.isDisplayed() && colClient.isDisplayed()&& colPrice.isDisplayed() 
				 && colStartdate.isDisplayed()&& colDealine.isDisplayed()&& colProgress.isDisplayed()&& colStatus.isDisplayed()&& colLine.isDisplayed()) 
		 {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
				 btnEditColumns.click();
				 driver.findElement(xpathProgress).click();
				 btnEditColumns.click();
				 driver.findElement(xpathStatus).click();
				 btnEditColumns.click();
				 driver.findElement(xpathLine).click();
			 }
			 
		 } 
		 return !isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4)
				  && !isElementDisplayed(driver, e5)&& !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e7)
				  && !isElementDisplayed(driver, e8)&& !isElementDisplayed(driver, e9);
	 }
	 //Hiện 9 cột ID, Title, Clents, Price, Start date , Deadline, Progress, Status , Line	 
	 public boolean displayNineColumn(String e1, String e2, String e3,String e4, String e5, String e6,String e7, String e8,String e9) {
		 WebElement btnEditColumns = driver.findElement(xpathBtnEditCol);
		 if(!isElementDisplayed(driver,e1)&& !isElementDisplayed(driver,e2) && !isElementDisplayed(driver, e3) && !isElementDisplayed(driver, e4) 
				 && !isElementDisplayed(driver, e5) && !isElementDisplayed(driver, e6)&& !isElementDisplayed(driver, e7)
				 && !isElementDisplayed(driver, e8)&& !isElementDisplayed(driver, e9)) 
		 {
			 if(btnEditColumns.isDisplayed()) {
				 btnEditColumns.click();
				 driver.findElement(xpathId).click();
				 btnEditColumns.click();
				 driver.findElement(xpathTitle).click();
				 btnEditColumns.click();
				 driver.findElement(xpathClient).click();
				 btnEditColumns.click();
				 driver.findElement(xpathPrice).click();			 
				 btnEditColumns.click();
				 driver.findElement(xpathStartDate).click();	
				 btnEditColumns.click();
				 driver.findElement(xpathDeadline).click();
				 btnEditColumns.click();
				 driver.findElement(xpathProgress).click();
				 btnEditColumns.click();
				 driver.findElement(xpathStatus).click();
				 btnEditColumns.click();
				 driver.findElement(xpathLine).click();
			 }
		 } 
		 return isElementDisplayed(driver,e1)&& isElementDisplayed(driver,e2) && isElementDisplayed(driver, e3) && isElementDisplayed(driver, e4)
				 && isElementDisplayed(driver,e5)  && isElementDisplayed(driver,e6)&& isElementDisplayed(driver, e7)
				 && isElementDisplayed(driver, e8) && isElementDisplayed(driver, e9);
	 }
	 
	 public boolean isElementDisplayed(WebDriver driver, String yourLocator) {
		 try {
			 WebElement locator;
			 locator = driver.findElement(By.xpath(yourLocator));
			 return locator.isDisplayed();
		 } catch (NoSuchElementException e) {
			 return false;
		 }
		 }
	 
//	 public void deleteProject() {
//
//	 }
//	 public boolean fillterAllproject() {
//		 return true;
//	 }
	 // Check filter record by label
	 public boolean checkRecordByLabel(int column,String input) throws InterruptedException {
		boolean check= false;
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		int pageTotalInt = getPageTotal();
		List < WebElement > totalRows = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
		Thread.sleep(2);
		for(int i= 1; i <= pageTotalInt ; i++) {
			if(i!= 1) {
				driver.findElement(button_Next).click();
			}
			for(int j=1; j<= totalRows.size() ; j++ ) {
			    WebElement label = driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr[" + i + "]/td[" + column + "]//span"));
			    if(label.getText().equals(input)) {
			    	check = true;
			    }
			    else return false;
			}
		}
		return check;
	 }
	 
	 // Check filter record by Name
	 public boolean checkRecordByName(int column,String input) throws InterruptedException {
		boolean check= false;
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		int pageTotalInt = getPageTotal();
		List < WebElement > totalRows = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
		Thread.sleep(2);
		for(int i= 1; i <= pageTotalInt ; i++) {
			if(i!= 1) {
				driver.findElement(button_Next).click();
			}
			for(int j=1; j<= totalRows.size() ; j++ ) {
			    WebElement label = driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr[" + i + "]/td[" + column + "]//a"));
			    if(label.getText().equals(input)) {
			    	check = true;
			    }
			    else return false;
			 System.out.println(label.getText());
			}
		}
		return check;
	 }
	 
	// check filter record by status
	 public boolean checkRecordByStatus(int column,String input) throws InterruptedException {
		boolean check= false;
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		int pageTotalInt = getPageTotal();
		List < WebElement > totalRows = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
		Thread.sleep(1);
		for(int i= 1; i<= pageTotalInt; i++) {
			if(i!= 1) {
				driver.findElement(button_Next).click();
			}
			for(int j=1; j<=totalRows.size() ; j++ ) {
			    WebElement label = driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr[" + i + "]/td[" + column + "]"));
			    if(label.getText().equals(input)) {
			    	check = true;
			    }
			    else
			    	return false;
			}
		}
		return check;
	 }	 
	 public boolean checkTotalProject() {
		 filterAllProject();
		 pause(5000);
		 int actual = getNumRecord();
		 clearFilter();
		 pause(5000);
		 int expect = countAllProject();
		 if(actual==expect) {
			 return true;
		 }
		 return false;
	 }
 
	 // get total data in table
	 public By label_Infor_PageTotal = By.xpath("//div[@id= 'project-table_info']");
	 public int getPageTotal() {
		String info = driver.findElement(label_Infor_PageTotal).getText();
		ArrayList < String > arrayListString = new ArrayList < > ();
		for (String s: info.split(" ")) {
			 arrayListString.add(s);
		}
		int itemTotal = Integer.parseInt(arrayListString.get(2));
		int itemTotalOnePage= 10; 			
		double pageTotal = (double) itemTotal / (double) itemTotalOnePage;
		int pageTotalInt = (int) Math.ceil(pageTotal);
		return pageTotalInt;
	 }
	 // get number record
	 public int getNumRecord() {
		String info = driver.findElement(label_Infor_PageTotal).getText();
		ArrayList < String > arrayListString = new ArrayList < > ();
		for (String s: info.split(" ")) {
		    arrayListString.add(s);
		}
		int itemTotal = Integer.parseInt(arrayListString.get(2));
		return itemTotal;
	 }
	 
	 
	 // clear filter
	 public By btnFilter = By.xpath("//button[@class='btn btn-default smart-filter-dropdown dropdown-toggle caret']");
	 public By btnClear = By.xpath("//a[text()='Clear']");
	 public void clearFilter() {
		 driver.findElement(btnFilter).click();
		 driver.findElement(btnClear).click();
	 }
	 // Filter all project
	 public By btnFilterAllProject = By.xpath("//button[text()='All projects']");
	 public void filterAllProject() {
		 driver.findElement(btnFilterAllProject).click();
	 }
	 // Filter project completed
	 public By btnFilterProjectCompleted = By.xpath("//button[@data-id='tiyhayaffv']");
	 public void filterCompletedProject() {
		 driver.findElement(btnFilterProjectCompleted).click();
	 }
	 // Filter project high priority
	 public By btnFilterHighProject = By.xpath("//button[text()='High Priority']");
	 public void filterHighProject() {
		 driver.findElement(btnFilterHighProject).click();
	 }
	 // Filter project open priority
	 public By btnFilterOpenProject = By.xpath("//button[@data-id='ohenbtrdgc']");
	 public void filterOpenProject() {
		 driver.findElement(btnFilterOpenProject).click();
	 }
	 // Filter project upcoming 
	 public By btnFilterUpcomingProject = By.xpath("//button[text()='Upcoming']");
	 public void filterUpcomingProject() {
		 driver.findElement(btnFilterUpcomingProject).click();
	 }
	 //Count all project= status O+ status C
	 public int countAllProject() {
		 int totalProject= 0;
		 filterOpenProject();
		 pause(3000);
		 int open =getNumRecord();
		 clearFilter();
		 pause(3000);
		 filterCompletedProject();
		 pause(3000);
		 int complete= getNumRecord();
		 totalProject= complete+open;
		 clearFilter();
		 return totalProject;
	 }

}
