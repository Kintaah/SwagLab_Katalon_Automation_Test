import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginPage {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I open Swag Labs website")
	def open_website() {
		WebUI.openBrowser(GlobalVariable.URL)
		WebUI.maximizeWindow()
	}

	@When("I input {string} value on the {string} text field")
	def input_value_on_text_field(String value, String placeholder) {
		WebUI.setText(findTestObject('Object Repository/001_LoginPage/input_Field', [param:placeholder]), value)
	}

	@When("I click on {string} button")
	def click_on_button(String value) {
		switch(value) {
			case 'Login':
				WebUI.click(findTestObject('Object Repository/001_LoginPage/input_LoginButton'))
				break
			case 'Cart':
				WebUI.click(findTestObject('Object Repository/002_HomePage/div_CartIcon'))
				break	
		}
	}

	@Then("User can see the home page")
	def I_verify_the_status_in_step() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/002_HomePage/div_HeaderLogo'))
	}

	@Then("User can see the {string} error message")
	def user_can_see_error_message(String value) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/001_LoginPage/div_ErrorMessage',[param:value]))
	}
}