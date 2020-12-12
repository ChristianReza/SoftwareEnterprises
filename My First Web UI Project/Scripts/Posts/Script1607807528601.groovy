import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://ec2-18-222-43-76.us-east-2.compute.amazonaws.com:8080/SoftwareEnterprises/login.html')

WebUI.setText(findTestObject('Object Repository/Page_/input_Email_j_username'), 'DemoUser@test.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_/input_Password_j_password'), 'PblvLzUlPsM=')

WebUI.click(findTestObject('Object Repository/Page_/input'))

WebUI.click(findTestObject('Object Repository/Page_/a_Create New Post'))

WebUI.setText(findTestObject('Object Repository/Page_/input_Subject BodyAre optionalCategories_subject'), 'subject')

WebUI.setText(findTestObject('Object Repository/Page_/textarea_Subject BodyAre optionalCategories_body'), 'posting a body')

WebUI.click(findTestObject('Object Repository/Page_/input'))

WebUI.navigateToUrl('http://ec2-18-222-43-76.us-east-2.compute.amazonaws.com:8080/SoftwareEnterprises/Feed')



