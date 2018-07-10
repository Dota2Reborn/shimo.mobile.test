package cases.mobile;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.TestInit;

public class testMobile extends TestInit {

	/**
	 * 首页点击跳转到登录页面
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void pageToLogin() {
		driver.navigate().to(test_url);
		click(homePage_login);
		boolean r1 = getText(login_submit).equals("登录");
		boolean r2 = driver.getCurrentUrl().equals(test_url + "login");
		assertTrue(r1 && r2);
	}

	/**
	 * 首页点击跳转到注册页面
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void pageToRegister() {
		driver.navigate().to(test_url);
		click(homePage_register);
		boolean r1 = getText(login_register).equals("下一步");
		boolean r2 = driver.getCurrentUrl().equals(test_url + "register");
		assertTrue(r1 && r2);

	}

	/**
	 * 新建文件并删除
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void newFile() {
		login("mobile_test@shimo.im", "123123");
		click(desktop_newDoc);

		String time = getDate();
		sendKeys(input_doc_title, time);
		sendKeys(input_doc, "One for all");
		click(btn_doc_back);
		boolean r1 = getText(desktop_file_1).equals(time);
		click(desktop_file_1_setting);
		click(desktop_file_del);
		assertTrue(r1);
	}

	/**
	 * 新建文件夹
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void newFolder() {
		login("mobile_test@shimo.im", "123123");
		click(desktop_setting);
		click(desktop_newFolder_btn);

		String time = getDate();
		sendKeys(desktop_newFolder_input, time);
		click(desktop_newFolder_confirm_btn);
		click(folder_backToDesktop_btn);
		boolean r1 = getText(desktop_file_1).equals(time);
		click(desktop_file_1_setting);
		click(desktop_file_del);
		assertTrue(r1);
	}

	/**
	 * 移动文件到文件夹中
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void moveToFolder() throws InterruptedException {
		login("mobile_test@shimo.im", "123123");
		click(desktop_newDoc);

		String time = getDate();
		sendKeys(input_doc_title, time);
		sendKeys(input_doc, "One for all");
		click(btn_doc_back);
		click(desktop_file_1_setting);
		click(desktop_file_move);
		click(desktop_file_moveToFolder_1);
		boolean r1 = getText(desktop_file_1).equals(time);
		Thread.sleep(200);
		click(desktop_file_moveToFolder_1);
		click(desktop_file_1_setting);
		click(desktop_file_del);
		assertFalse(r1);
	}

	/**
	 * 添加协作者
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void addCollaborator() {
		login("mobile_test@shimo.im", "123123");
		click(desktop_file_1_setting);
		click(desktop_file_share);
		sendKeys(addCollaborator_input, "liuchen@shimo.im");
		click(addCollaborator_btn);
		boolean r1 = getText(addCollaborator_info_email).equals("liuchen@shimo.im");
		click(addCollaborator_edit_btn);
		click(addCollaborator_del_btn);

		assertTrue(r1);
	}

	/**
	 * 点击消息按钮跳转
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void pageToMessage() {
		login("mobile_test@shimo.im", "123123");
		click(desktop_setting);
		click(message_btn);

		boolean r1 = driver.getCurrentUrl().equals(test_url + "notifications");
		assertTrue(r1);
	}

	/**
	 * 文件分享
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void doc_share() throws InterruptedException {
		login("mobile_test@shimo.im", "123123");
		click(desktop_newDoc);
		click(doc_setting);
		click(doc_setting_share);

		click(doc_share_editable);
		boolean r1 = getText(doc_share_info).equals("允许其他人编辑及分享此文档");

		click(doc_share_readonly);
		boolean r2 = getText(doc_share_info).equals("允许其他人查阅及分享此文档");

		click(doc_share_private);
		boolean r3 = getText(doc_share_info).equals("关闭此文档公开链接");

		click(backToDoc_btn);
		Thread.sleep(3000);

		click(btn_doc_back);
		click(desktop_file_1_setting);
		click(desktop_file_del);

		assertTrue(r1 && r2 && r3);
	}

	/**
	 * 个人设置页面跳转
	 * 
	 * @author 刘晨
	 * @Time 2018-7-10
	 *
	 */
	@Test
	public void pageToProfile() {
		login("mobile_test@shimo.im", "123123");
		click(desktop_personSetting);

		boolean r1 = driver.getCurrentUrl().equals(test_url + "profile");
		assertTrue(r1);
	}
}
