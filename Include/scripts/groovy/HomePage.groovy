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

class HomePage {
	@When("I click on {string} product image")
	def i_click_product_image(String value) {
		WebUI.click(findTestObject('Object Repository/002_HomePage/div_ProductImage',[param:value]))
	}
	
	@Then('User can see the {string} product details')
	def user_see_product_details(String value) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/002_HomePage/div_ProductText',[param:value]))
	}
	
	@When("I click on {string} add to cart button")
	def i_click_add_to_cart_button(String value) {
		WebUI.click(findTestObject('Object Repository/002_HomePage/div_AddToCart',[param:value]))
	}
	
	@Then('User can see the {string} in add to cart page')
	def user_see_add_to_cart(String value) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/002_HomePage/div_ProductText',[param:value]))
	}
	
	@When("Verify {string} sort function in {string} order")
	def verify_sort_func(String sortBy, String sortType) {
		String xpath = ""

		switch (sortBy.toLowerCase()) {
			case "name":
				xpath = 'Object Repository/002_HomePage/div_NameData'
				break
			case "price":
				xpath = 'Object Repository/002_HomePage/div_PriceData'
				break
			default:
				throw new IllegalArgumentException("Invalid sorting type: " + sortBy)
		}

		List<String> tableValues = CustomKW.getTextOfListElements(findTestObject(xpath))

		println("Original Values: $tableValues")

		List referenceValues

		if (sortBy.toLowerCase() == "price") {
			// Convert price strings to numeric values
			referenceValues = tableValues.collect { it.replace('$', '').toFloat() }
		} else {
			// For name data, no conversion is required
			referenceValues = new ArrayList<>(tableValues)
		}

		// Sort the reference list based on the sort order
		switch (sortType.toLowerCase()) {
			case "ascending":
				referenceValues.sort()
				break
			case "descending":
				referenceValues.sort(Collections.reverseOrder())
				break
			default:
				throw new IllegalArgumentException("Invalid sorting order: " + sortType)
		}

		println("Sorted Reference Values: $referenceValues")

		// If dealing with price, convert tableValues to Float for comparison
		if (sortBy.toLowerCase() == "price") {
			List<Float> numericValues = tableValues.collect { it.replace('$', '').toFloat() }
			assert numericValues == referenceValues : "Sorting validation failed"
		} else {
			assert tableValues == referenceValues : "Sorting validation failed"
		}
	}



	
	@When("I select {string} on the sort dropdown")
	def select_sort_dropdown(String value) {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/002_HomePage/select_SortOption',[param:value]), value, false)
	}
	
}