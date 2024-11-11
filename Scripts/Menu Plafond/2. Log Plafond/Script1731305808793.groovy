import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.Robot
import java.awt.event.KeyEvent

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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Log Plafond']"]));

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Log Plafond' + '/' + '2. Log' + '/' + "1. Halaman log plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

if(StartDate != "" && EndDate != "") {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//p-calendar//input)[1]"]), StartDate);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//p-calendar//input)[2]"]), EndDate);
}

if(Search != "") {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='value']"]), Search);
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Search']"]));

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Log Plafond' + '/' + '2. Log' + '/' + "2. Hasil Search") + '.png', FailureHandling.STOP_ON_FAILURE);

Robot robot = new Robot();

try {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='View Log']"]));
	
	for(int i=0; i<4; i++) {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Log Plafond' + '/' + '2. Log' + '/' + "3. Hasil Log") + '.png', FailureHandling.STOP_ON_FAILURE);
	
} catch (Exception e) {
	e.printStackTrace();
}






