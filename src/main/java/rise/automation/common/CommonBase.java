package rise.automation.common;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

	public class CommonBase {
		public static WebDriver driver;	
		public int initWaitTime = 10;
		public WebDriver initChromeDriver(String URL)
		{
			ChromeOptions options = new ChromeOptions();
//			options.setHeadless(true);
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");		
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(URL);
			return driver;
		}
		public WebDriver initFirefoxDriver(String URL)
		{
			System.setProperty("webdriver.edge.driver","C:\\edgedriver_win64\\msedgedriver.exe");	
			FirefoxOptions options= new FirefoxOptions();
	        driver = new FirefoxDriver(options);
	        driver.manage().window().maximize();
	        return driver;
		}
		public WebDriver initMicrosoftEdge(String URL)
		{
			System.setProperty("webdriver.edge.driver","C:\\edgedriver_win64\\msedgedriver.exe");	
			EdgeOptions options = new EdgeOptions();
	        driver = new EdgeDriver(options);
	        driver.manage().window().maximize();
	        return driver;
		}
		  public static WebDriver setupDriver(String browserName) {
		        switch (browserName.trim().toLowerCase()) {
		            case "chrome":
		                driver = initChromeDriver();
		                break;
		            case "firefox":
		                driver = initFirefoxDriver();
		                break;
		            case "edge":
		            	driver = initMicrosoftEdge();
		            default:
		                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
		                driver = initChromeDriver();
		        }
		        return driver;
		    } 
		public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) {
			WebElement element = driver.findElement(inputElement);
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
			} catch (StaleElementReferenceException ex) {
				pause(1000);
				inputTextJavaScriptInnerHTML(inputElement, companyName);
			}
		}
		
		public void inputTextJavaScriptValue(By locator, String value) {
			WebElement element = getElementPresentDOM(locator);
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
			} catch (StaleElementReferenceException ex) {
				pause(1000);
				inputTextJavaScriptValue(locator, value);
			}
		}
		
		public void scrollToElement(By locator) {
			WebElement element = getElementPresentDOM(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void clickJavaScript(By locator)
		{
			WebElement element = getElementPresentDOM(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
		
		public WebElement getElementPresentDOM(By locator)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
			return driver.findElement(locator);
		}
		
		public boolean isElementPresent(By locator)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isDisplayed();
		}
		
		public void click(By locator)
		{
			WebElement element = getElementPresentDOM(locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
		
		public void type(By locator, String value)
		{
			WebElement element = getElementPresentDOM(locator);
			element.sendKeys(value);
		}
		/**
		 * pause driver in timeInMillis
		 * 
		 * @param timeInMillis
		 */
		public void pause(long timeInMillis) {
			try {
				Thread.sleep(timeInMillis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * get absolute path of file
		 * 
		 * @param relativeFilePath
		 * @return
		 */
		public String getAbsoluteFilePath(String relativeFilePath) {
			String curDir = System.getProperty("user.dir");
			String absolutePath = curDir + relativeFilePath;
			return absolutePath;
		}

		public void quitDriver(WebDriver dr) {
			if (dr.toString().contains("null")) {
				System.out.print("All Browser windows are closed ");
			} else {
				dr.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS); 
				dr.manage().deleteAllCookies();
				dr.close();
			}
		}
		
		public int findIFrame() {
			int indexOfIframe =0;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println("So luong frame: "+size);
			for (int i = 0; i < size; i++) {
				driver.switchTo().frame(i);
				int numberOfIFrame = driver.findElements
						(By.xpath("//button[text()='Gửi ngay']")).size();
				System.out.println("elementCanTim ở vị trí:" +numberOfIFrame);
				if(numberOfIFrame!=0)
				{
					indexOfIframe = i;
					driver.switchTo().defaultContent();	
					return indexOfIframe;
				}
				// Sau khi in ra element cần tìm phải trở về frame cha để tìm tiếp đến hết
				driver.switchTo().defaultContent();	
			}
			System.out.println("indexOfIframe: " +indexOfIframe);
			return indexOfIframe;
		}
		
		public int findIFrameCopy(String xpath) {
			pause(20000);
			int indexOfIframe =0;
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println("So luong frame: "+size);
			for (int i = 0; i < size; i++) {
				driver.switchTo().frame(i);
				int numberOfIFrame = driver.findElements
				(By.xpath(xpath)).size();
				if(numberOfIFrame!=0)
				{
					indexOfIframe = i;
					driver.switchTo().defaultContent();	
					return indexOfIframe;
				}
				// Sau khi in ra element cần tìm phải trở về frame cha để tìm tiếp đến hết
				driver.switchTo().defaultContent();	
			}
			System.out.println("indexOfIframe: " +indexOfIframe);
			return indexOfIframe;
		}
		

	    private static WebDriver initChromeDriver() {
	        System.out.println("Launching Chrome browser...");
	        ChromeOptions options = new ChromeOptions();
//			System.setProperty("webdriver.chrome.driver",
//			System.getProperty("user.dir") + "C:\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			return driver;
	    }
	    public static WebDriver initFirefoxDriver() {
	        System.out.println("Launching Firefox browser...");
//	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//	        capabilities.setCapability("marionette", true);
	       // FirefoxProfile fxProfile = new FirefoxProfile();
//			System.setProperty("webdriver.gecko.driver",
//			System.getProperty("user.dir") + "C:\\geckodriver-v0.32.0-win32\\geckodriver.exe");	
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.32.0-win32\\geckodriver.exe");	
			FirefoxOptions options= new FirefoxOptions();
	        driver = new FirefoxDriver(options);
//	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        return driver;
	    }
	    
	    public static WebDriver initMicrosoftEdge() {
	    	System.out.print("Launching MicrosoftEdge browser...");
//			System.setProperty("webdriver.edge.driver",
//			System.getProperty("user.dir") + "C:\\edgedriver_win64\\msedgedriver.exe");	
			System.setProperty("webdriver.edge.driver","C:\\edgedriver_win64\\msedgedriver.exe");	  
			EdgeOptions options = new EdgeOptions();
	        driver = new EdgeDriver(options);
//	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        return driver;
	    }
	    
	}
