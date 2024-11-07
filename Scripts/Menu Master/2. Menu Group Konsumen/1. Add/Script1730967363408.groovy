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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Group Konsumen']"]));

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '1. Add' + '/' + "1. Menu Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Add New Group Konsumen']"]));

Robot robot = new Robot();

robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_MINUS);
robot.keyRelease(KeyEvent.VK_MINUS);
robot.keyRelease(KeyEvent.VK_CONTROL);

WebUI.delay(2);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '1. Add' + '/' + "2. Add Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaGroup']"]), NamaGroupKonsumen);

WebUI.delay(2);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '1. Add' + '/' + "3. Input Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save']"]));

WebUI.delay(2);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Group Konsumen' + '/' + '1. Add' + '/' + "4. Setelah Add Group Konsumen") + '.png', FailureHandling.STOP_ON_FAILURE);