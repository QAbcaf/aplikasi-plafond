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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Register Plafond']"]));

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Aplikasi Plafond' + '/' + '1. Menu Plafond' + '/' + "1. Halaman Register Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@placeholder='Search...']"]), Nama);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//tr[td[span[text()='Nama'] and contains(text(), '$Nama')] and td[span[text()='Group Konsumen'] and contains(text(), '$GroupKonsumen')]]//span[@class='p-button-icon pi pi-pencil']"]));

Robot robot = new Robot();

for(int i=0; i<4; i++) {
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_MINUS);
	robot.keyRelease(KeyEvent.VK_MINUS);
	robot.keyRelease(KeyEvent.VK_CONTROL);
}

for(int i=1; i<=2; i++) {
	WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Aplikasi Plafond' + '/' + '1. Menu Plafond' + '/' + "2. Halaman Plafond " + i) + '.png', FailureHandling.STOP_ON_FAILURE);
	
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
}

String[] checkkategori = CheckKategori.split(';');

if(CheckKategori != "") {
	for (String kategori in checkkategori) {
		
		boolean accepted = false;
		while(!accepted) {
			try {
				WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//tr[td[span[text()='Kategori Plafond'] and contains(., '$kategori')]]//span[@class='p-button-icon pi pi-eye']"]));
				WebUI.acceptAlert();
				accepted = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		
		WebUI.delay(2);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Aplikasi Plafond' + '/' + '1. Menu Plafond' + '/' + "3. Detail Plafond " + kategori + " 1") + '.png', FailureHandling.STOP_ON_FAILURE);
		
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		WebUI.delay(2);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Aplikasi Plafond' + '/' + '1. Menu Plafond' + '/' + "3. Detail Plafond " + kategori + " 2") + '.png', FailureHandling.STOP_ON_FAILURE);
		WebUI.back();
		WebUI.delay(1);
	}

}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save']"]));
