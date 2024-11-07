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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String baseDir = System.getProperty('user.dir');

WebUI.callTestCase(findTestCase("Test Cases/Menu Master/1. Login"), null);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Group Konsumen']"]));

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '2. Edit' + '/' + "1. Menu Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@placeholder='Search...']"]), NamaGroupKonsumen);

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Group Konsumen' + '/' + '2. Edit' + '/' + "2. Search Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.delay(1);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[@icon='pi pi-pencil']"]));

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaGroup']"]), NewNamaGroupKonsumen);

WebUI.delay(2);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '2. Edit' + '/' + "3. Edit Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save']"]));

WebUI.delay(2);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '3. Edit' + '/' + "4. Setelah Edit Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);