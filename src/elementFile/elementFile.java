package elementFile;

import org.openqa.selenium.WebElement;

public class elementFile {
	/**
	 * loginPage
	 * 登录页面
	 *
	 */
	@SearchWith(pageName = "loginPage", elementName = "userEmail", noteName = "用户名")
	public WebElement userEmail;
	@SearchWith(pageName = "loginPage", elementName = "userPwd", noteName = "密码")
	public WebElement userPwd;
	@SearchWith(pageName = "loginPage", elementName = "login_submit", noteName = "登录按钮")
	public WebElement login_submit;
	@SearchWith(pageName = "loginPage", elementName = "login_register", noteName = "注册页面下一步按钮")
	public WebElement login_register;
	
	/**
	 * homePage
	 * 官网首页
	 *
	 */
	@SearchWith(pageName = "homePage", elementName = "homePage_register", noteName = "首页注册按钮")
	public WebElement homePage_register;
	@SearchWith(pageName = "homePage", elementName = "homePage_login", noteName = "首页登录按钮")
	public WebElement homePage_login;
	
	/**
	 * desktop
	 * 桌面
	 *
	 */
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc", noteName = "新建文档按钮")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting", noteName = "桌面左上角菜单栏")
	public WebElement desktop_setting;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_btn", noteName = "新建文件夹按钮")
	public WebElement desktop_newFolder_btn;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_input", noteName = "新建文件夹文件夹名输入")
	public WebElement desktop_newFolder_input;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_confirm_btn", noteName = "新建文件夹文件夹名输入确认按钮")
	public WebElement desktop_newFolder_confirm_btn;
	@SearchWith(pageName = "desktop", elementName = "folder_backToDesktop_btn", noteName = "文件夹返回桌面按钮")
	public WebElement folder_backToDesktop_btn;
	@SearchWith(pageName = "desktop", elementName = "desktop_personSetting", noteName = "个人资料按钮")
	public WebElement desktop_personSetting;
	@SearchWith(pageName = "desktop", elementName = "desktop_file_1", noteName = "桌面第一个文件文件名")
	public WebElement desktop_file_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_file_1_setting", noteName = "桌面第一个文件菜单")
	public WebElement desktop_file_1_setting;
	@SearchWith(pageName = "desktop", elementName = "desktop_file_del", noteName = "桌面文件菜单删除按钮")
	public WebElement desktop_file_del;
	@SearchWith(pageName = "desktop", elementName = "desktop_file_share", noteName = "桌面文件菜单分享按钮")
	public WebElement desktop_file_share;
	@SearchWith(pageName = "desktop", elementName = "desktop_file_move", noteName = "桌面文件菜单移动按钮")
	public WebElement desktop_file_move;
	@SearchWith(pageName = "desktop", elementName = "desktop_file_moveToFolder_1", noteName = "列表中第一个文件夹")
	public WebElement desktop_file_moveToFolder_1;
	@SearchWith(pageName = "desktop", elementName = "addCollaborator_input", noteName = "添加协作者邮箱地址输入")
	public WebElement addCollaborator_input;
	@SearchWith(pageName = "desktop", elementName = "addCollaborator_btn", noteName = "协作列表中添加按钮")
	public WebElement addCollaborator_btn;
	@SearchWith(pageName = "desktop", elementName = "addCollaborator_info_email", noteName = "协作列表中第一个协作者邮箱地址")
	public WebElement addCollaborator_info_email;
	@SearchWith(pageName = "desktop", elementName = "addCollaborator_edit_btn", noteName = "协作列表编辑按钮")
	public WebElement addCollaborator_edit_btn;
	@SearchWith(pageName = "desktop", elementName = "addCollaborator_del_btn", noteName = "协作列表删除协作者按钮")
	public WebElement addCollaborator_del_btn;
	@SearchWith(pageName = "desktop", elementName = "message_btn", noteName = "消息按钮")
	public WebElement message_btn;
	
	/**
	 * doc
	 * 文档
	 *
	 */
	@SearchWith(pageName = "doc", elementName = "btn_doc_back", noteName = "文档返回桌面按钮")
	public WebElement btn_doc_back;
	@SearchWith(pageName = "doc", elementName = "input_doc_title", noteName = "文档标题输入")
	public WebElement input_doc_title;
	@SearchWith(pageName = "doc", elementName = "input_doc", noteName = "文档内容输入")
	public WebElement input_doc;
	@SearchWith(pageName = "doc", elementName = "doc_setting", noteName = "文档设置菜单")
	public WebElement doc_setting;
	@SearchWith(pageName = "doc", elementName = "doc_setting_share", noteName = "文档设置菜单-分享tab")
	public WebElement doc_setting_share;
	@SearchWith(pageName = "doc", elementName = "doc_share_editable", noteName = "分享状态-可写")
	public WebElement doc_share_editable;
	@SearchWith(pageName = "doc", elementName = "doc_share_readonly", noteName = "分享状态-只读")
	public WebElement doc_share_readonly;
	@SearchWith(pageName = "doc", elementName = "doc_share_private", noteName = "分享状态-禁用")
	public WebElement doc_share_private;
	@SearchWith(pageName = "doc", elementName = "doc_share_info", noteName = "分享状态-详细信息")
	public WebElement doc_share_info;
	@SearchWith(pageName = "doc", elementName = "backToDoc_btn", noteName = "分享页面返回到文档")
	public WebElement backToDoc_btn;
}
