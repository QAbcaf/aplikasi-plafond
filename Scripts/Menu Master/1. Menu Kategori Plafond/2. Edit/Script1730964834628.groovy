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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Kategori Plafond']"]));

WebUI.delay(1);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '2. Edit' + '/' + "1. Menu Kategori Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@placeholder='Search...']"]), KategoriPlafond);

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '2. Edit' + '/' + "2. Search Kategori Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.delay(1);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[@icon='pi pi-pencil']"]));

Robot robot = new Robot();

robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_MINUS);
robot.keyRelease(KeyEvent.VK_MINUS);
robot.keyRelease(KeyEvent.VK_CONTROL);


// NAMA KATEGORI
if (NewKategoriPlafond != "") {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaKategori']"]), NewKategoriPlafond);
}

// PRODUCT CODE

if (NewProductCode != "") {
	if(NewProductCode != "ALL") {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='productCode' and @value='SELECTED']"]));
		String[] productcodes = NewProductCode.split(';');
		for (String productcode in productcodes) {
			println("Product Code = " + productcode);
			WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[label[text()='Product Code']]//div[.='$productcode']"]), 0);
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[label[text()='Product Code']]//div[.='$productcode']"]));
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[@icon='pi pi-angle-right'])[1]"]));
		}
	}
	else {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='productCode' and @value='$NewProductCode']"]));
	}
}


// PRODUCT MARKETING
if (NewProductMarketing != "") {
	if(NewProductMarketing != "ALL") {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='productMarketing' and @value='SELECTED']"]));
		String[] productmarketings = NewProductMarketing.split(';');
		for (String productmarketing in productmarketings) {
			println("Product Marketing = " + productmarketing);
			WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[label[text()='Product Marketing']]//div[.='$productmarketing']"]), 0)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[label[text()='Product Marketing']]//div[.='$productmarketing']"]));
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[@icon='pi pi-angle-right'])[2]"]));
		}
	}
	else {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='productMarketing' and @value='$NewProductMarketing']"]));
	}
}


// PAKET
if(NewPaket != "") {
	if(NewPaket != "ALL") {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='paket' and @value='SELECTED']"]));
		String[] pakets = NewPaket.split(';');
		for (String paket in pakets) {
			println("Product Marketing = " + paket);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@placeholder='Search...'])[2]"]), paket);
			WebUI.delay(1);
			WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='$paket']"]), 0)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='$paket']"]));
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[@icon='pi pi-angle-right'])[3]"]));
		}
	}
	else {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='paket' and @value='$NewPaket']"]));
	}
}


// JENIS PLAFOND
if (NewJenisPlafond != "") {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='jenisPlafond' and @value='$NewJenisPlafond']"]));
}


for(int i=0; i<10; i++) {
	robot.keyPress(KeyEvent.VK_PAGE_UP);
	robot.keyRelease(KeyEvent.VK_PAGE_UP);
	WebUI.delay(1);
}

for(int i=1; i<=4; i++) {
	WebUI.delay(1);
	WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '2. Edit' + '/' + "3. Edit Kategori Plafond " + i) + '.png', FailureHandling.STOP_ON_FAILURE);
	WebUI.delay(1);
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save']"]));

WebUI.delay(2);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No + '/' + 'Kategori Plafond' + '/' + '2. Edit' + '/' + "4. Berhasil Edit Kategori") + '.png', FailureHandling.STOP_ON_FAILURE);
