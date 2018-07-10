package base;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import elementFile.elementFile;
import testNG.TestListener;

@Listeners({ TestListener.class })
public class TestInit extends elementFile {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Actions action = null;
	public String test_url;
	baseFunc init = new baseFunc();
	public String className;
	String browser;
	String nodeIp;
	String local;

	public TestInit() {

	}

	@Parameters({ "browser", "nodeIp", "local" })
	@BeforeClass
	public void firstMethod(String browser, String nodeIp, String local) throws MalformedURLException {
		test_url = init.getUrl();
		driver = init.initData(this, browser, nodeIp, local);
		action = new Actions(driver);
		driver.navigate().to(test_url + "login");
		wait = new WebDriverWait(driver, 6);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		String url = driver.getCurrentUrl();
		if (!url.equals(test_url + "login")) {
			logout();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		pageInit();
	}

	@AfterClass
	public void lastMethod() {
		// 关闭浏览器
		// driver.close();
		driver.quit();
	}

	/**
	 * 登录
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void login(String user, String pwd) {

		if (!driver.getCurrentUrl().equals(test_url + "login")) {
			driver.navigate().to(test_url + "login");
		}
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.clear();
		sendKeys(userEmail, user);
		userPwd.clear();
		sendKeys(userPwd, pwd);
		click(login_submit);
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
	}

	/**
	 * 登录（For登录报错验证）
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	public void login_error(String user, String pwd) {
		driver.navigate().to(test_url + "login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		click(login_submit);
	}

	/**
	 * 登出
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void logout() {
		try {
			driver.navigate().to(test_url + "logout");
			driver.switchTo().alert().accept();
			action.sendKeys(Keys.ESCAPE);
		} catch (UnhandledAlertException e) {
			// 报错
			driver.switchTo().alert().accept();
			driver.navigate().to(test_url + "logout");
			System.out.println("Unhandled Alert!!!!");
		} catch (NoAlertPresentException e) {
			// 正常情况
			action.sendKeys(Keys.ESCAPE);
		}
	}

	/**
	 * 页签切换
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void switchToPage(int i) {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(i));
	}

	/**
	 * 删除浏览器多余标签页
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void pageInit() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		for (int i = 0; i < n - 1; i++) {
			driver.switchTo().window(it.get(i));
			driver.close();
		}

		winHandels = driver.getWindowHandles();
		it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(0));
	}

	/**
	 * Log
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public void printLog(String classname, String userID) {
		System.out.println(classname + "[" + userID + "]");

	}

	/**
	 * 获取当前时间
	 * 
	 * @author 刘晨
	 * @Time 2018-04-19
	 *
	 */
	public String getDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmm");
		String time = format.format(date);
		return time;
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public boolean doesWebElementExist(By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public boolean doesWebElementExist(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			// TODO
			return false;
		}
	}

	/**
	 * 右键点击moveToElement
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public void contextClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.contextClick(element).perform();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}

	}

	/**
	 * 鼠标移动到元素
	 * 
	 * @author 刘晨
	 * @Time 2018-04-19
	 *
	 */
	public void moveToElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			action.moveToElement(element).perform();

		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}

	}

	/**
	 * 左键点击
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2018-03-23
	 * 
	 */
	public void click(WebElement element) {
		try {
			if (element.toString().equals(btn_doc_back.toString())) {
				// 离开文档表格编辑页
				wait.until(ExpectedConditions.elementToBeClickable(element));
				checkPageIsReady();
				wait.until(ExpectedConditions
						.invisibilityOfElementWithText(By.xpath("//span[@id='save-status']//span[2]"), "正在保存..."));
				element.click();
				driver.switchTo().alert().accept();
			} else if (element.toString().equals(desktop_file_del.toString())
					|| element.toString().equals(addCollaborator_del_btn.toString())) {
				element.click();
				driver.switchTo().alert().accept();
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			}

		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
			assertTrue(false);
		} catch (ElementClickInterceptedException e) {
			// 被遮挡
			System.out.println(element + "is obscuring");
			assertTrue(false);
		} catch (ElementNotVisibleException e) {
			// 不可见
			System.out.println(element + "is not visible");
			assertTrue(false);
		} catch (UnhandledAlertException e) {
			// 报错
			driver.switchTo().alert().accept();
			System.out.println("Unhandled Alert!!!!");
			assertTrue(false);
		} catch (TimeoutException e) {
			// 超时
			System.out.println("time out ->" + element);
			assertTrue(false);
		} catch (NoAlertPresentException e) {
			// 正常情况
		} catch (JavascriptException e) {
			String msg = driver.switchTo().alert().getText();
			System.out.println("Unhandled Alert :" + msg);
			System.out.println("javascript Error:" + e.getMessage());
			assertTrue(false);
		} finally {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			checkPageIsReady();
		}
	}

	public void addCollaborator(WebElement element) {
		String msg = getText(element);
		if (msg.equals("添加")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} else {
			// wait.until(ExpectedConditions.elementToBeClickable(element));
			// element.click();
			// wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
			// click(list_addCollaborator_4);
			// assertTrue(false);
		}
	}

	/**
	 * 获取文本信息
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public String getText(WebElement element) {
		String msg = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			msg = element.getText();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}
		return msg;
	}

	/**
	 * 获取文本信息
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public String getText(By element) {
		String msg = "";
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			msg = driver.findElement(element).getText();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}
		return msg;
	}

	/**
	 * 输入内容
	 * 
	 * @param
	 * @author 刘晨
	 * @Time 2018-04-16
	 *
	 */
	public void sendKeys(WebElement element, String msg) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(msg);
	}

	/**
	 * 通过JS判断页面是否加载完毕
	 * 
	 * @author 刘晨
	 * @Time 2018-04-10
	 *
	 */
	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 10; i++) {
			if ("complete".equals(js.executeScript("return document.readyState").toString())) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * 等待元素加载
	 * 
	 * @author 刘晨
	 * @Time 2018-01-25
	 *
	 */
	public void waitFor() {

	}

	/**
	 * UI像素比对截图
	 * 
	 * @author 刘晨
	 * @Time 2018-05-23
	 *
	 */
	public void screenShot() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String className = new Exception().getStackTrace()[1].getMethodName();
		ScreenShot st = new ScreenShot(driver);
		st.takeScreenshot(className);
	}

}
