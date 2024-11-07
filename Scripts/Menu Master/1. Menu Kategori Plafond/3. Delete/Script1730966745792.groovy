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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Kategori Plafond']"]));

WebUI.delay(1);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '3. Delete' + '/' + "1. Menu Kategori Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@placeholder='Search...']"]), KategoriPlafond);

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '3. Delete' + '/' + "2. Search Kategori Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.delay(1);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[@icon='pi pi-trash']"]));

WebUI.delay(1);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '3. Delete' + '/' + "3. Delete Kategori Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.delay(2);

try {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Yes']"]));
} catch (Exception e) {
	e.printStackTrace();
}

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '3. Delete' + '/' + "4. Setelah Delete") + '.png', FailureHandling.STOP_ON_FAILURE);
