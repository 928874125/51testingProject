package com.ecshopnew.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	@FindBy(partialLinkText = "ÇëµÇÂ¼")
	private WebElement loginLink;
	@FindBy(partialLinkText= "Ãâ·Ñ×¢²á")
	private WebElement regLink;
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void click_login_link() {
		loginLink.click();
	}
	public void click_reg_link() {
		regLink.click();
	}
}
