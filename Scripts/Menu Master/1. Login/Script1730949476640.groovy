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

WebUI.openBrowser(GlobalVariable.url);
WebUI.maximizeWindow();

WebUI.delay(2);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Login' + '/' + "1. Halaman Login") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='userid']"]), GlobalVariable.username);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='password']"]), GlobalVariable.password);

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Login' + '/' + "2. Input Login") + '.png', FailureHandling.STOP_ON_FAILURE);

println("Login = " + GlobalVariable.username);
println("Password = " + GlobalVariable.password);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[@type='submit']"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Mengerti']"]));
WebUI.delay(2);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Login' + '/' + "3. Halaman Dashboard") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='list-app-item' and .//div[text()='New Plafond']]//img"]));

WebUI.delay(2);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Login' + '/' + "4. Halaman Aplikasi Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);




