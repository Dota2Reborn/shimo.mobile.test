package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.google.common.base.Preconditions;

import elementFile.CustomFieldDecorator;
import elementFile.MyElementLocatorFactory;

public class baseFunc {
	private int environment;// 切换测试环境
	private String test_url;// 测试地址
	public WebDriver driver;
	String os;// 系统信息

	public baseFunc() {
		environment = 1; // 1为release 2为dev
	}

	/**
	 * 加载json
	 * 
	 * @author 刘晨
	 * @throws MalformedURLException
	 * @Time 2017-11-20
	 *
	 */
	public WebDriver initData(Object xx, String browser, String nodeIp, String local) throws MalformedURLException {
		if (local.equals("true")) {
			os = System.getProperties().getProperty("os.name");
			Preconditions.checkArgument(StringUtils.isNotEmpty(os), "OS info is missing.");
			if (os.startsWith("Windows") && browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

				ChromeOptions option = new ChromeOptions();
				option.addArguments("--user-agent=iPhone X");
				driver = new ChromeDriver(option);
			} else {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--user-agent=iPhone X");
				driver = new ChromeDriver(option);
			}
		} else {
				ChromeOptions option = new ChromeOptions();
				option.setCapability("browserName", "chrome");
				option.setCapability("version", "67");
				option.setCapability("plaform", "ANY");
				option.addArguments("--user-agent=iPhone 6");
				URL remoteAddress = new URL(nodeIp + "/wd/hub");
				driver = new RemoteWebDriver(remoteAddress, option);
		}
		
		driver.manage().window().setSize(new Dimension(600, 900));
		ElementLocatorFactory locatorFactory = new MyElementLocatorFactory(driver);
		FieldDecorator customFieldDecorator = new CustomFieldDecorator(locatorFactory);
		PageFactory.initElements(customFieldDecorator, xx);
		return driver;

	}

	/**
	 * 获取测试地址
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public String getUrl() {
		if (environment == 1) {
			test_url = "https://release.shimodev.com/";
		} else if (environment == 2) {
			test_url = "https://shimodev.com/";
		}
		return test_url;
	}

}
