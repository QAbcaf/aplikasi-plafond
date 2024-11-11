import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Robot
import java.awt.event.KeyEvent

import com.beust.jcommander.Strings
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
import com.thoughtworks.selenium.webdriven.commands.SetTimeout

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String baseDir = System.getProperty('user.dir');

WebUI.callTestCase(findTestCase("Test Cases/Menu Master/1. Login"), null);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Register Plafond']"]));

WebUI.delay(1);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "1. Halaman Register Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Add New Konsumen']"]));

Robot robot = new Robot();

robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_MINUS);
robot.keyRelease(KeyEvent.VK_MINUS);
robot.keyRelease(KeyEvent.VK_CONTROL);

WebUI.delay(2);
WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "2. Register Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

// JENIS KONSUMEN
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@value='$JenisKonsumen']"]));

// NO KTP / NO NPWP
if(JenisKonsumen == "PERORANGAN") {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='noKtp']"]), NoKTP);
}
else if(JenisKonsumen == "CORPORATE") {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='noNpwp']"]), NoNPWP);
}

// NAMA
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='nama']"]), Nama);

// GROUP KONSUMEN
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-multiselect[@formcontrolname='namaGroup']"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//p-multiselect[@formcontrolname='namaGroup']//input[@role='textbox']"]), GroupKonsumen);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-multiselectitem//div[@class='p-checkbox-box' and following::div/span[text()='$GroupKonsumen']]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-multiselect[@formcontrolname='namaGroup']"]));

robot.keyPress(KeyEvent.VK_PAGE_UP);
robot.keyRelease(KeyEvent.VK_PAGE_UP);
WebUI.delay(1);

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "3. Input Register Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

// ADD NEW PLAFOND
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Add New Plafond']"]));

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "4. Kategori Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);

// KATEGORI PLAFOND
/// kategori plafond
WebUI.delay(2);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Select']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='$KategoriPlafond']"]));


/// nominal plafond
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//p-inputnumber[@id='nominalPlafond']//input"]), NominalPlafond);

// start date - end date
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//p-calendar//input)[1]"]), StartDate);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//p-calendar//input)[2]"]), EndDate);

robot.keyPress(KeyEvent.VK_PAGE_DOWN);
robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

// CABANG
if(Cabang != "ALL") {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='cabang' and @value='SELECTED']"]));
	String[] cabangs = Cabang.split(';');
	for (String cabang in cabangs) {
		println("Cabang = " + cabang);
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='$cabang']"]), 0);
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='$cabang']"]));
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[@icon='pi pi-angle-right']"]));
	}
}
else {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//p-radiobutton[@name='cabang' and @value='$Cabang']"]));
}

for(int i=0; i<3; i++) {
	robot.keyPress(KeyEvent.VK_PAGE_UP);
	robot.keyRelease(KeyEvent.VK_PAGE_UP);
	WebUI.delay(1);
}

for(int i=1; i<=2; i++) {
	WebUI.delay(1);
	WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "5. Input Kategori Plafond " + i) + '.png', FailureHandling.STOP_ON_FAILURE);
	WebUI.delay(1);
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[@icon='pi pi-check']//span[text()='Save']"]));

// SHARING PLAFOND

String[] jeniskonsumensharings = JenisKonsumenSharing.split(';');
String[] nosharings	= NoSharing.split(';');
String[] nominalplafondanaks = NominalPlafondAnak.split(';');

int x = jeniskonsumensharings.length;

if(SharingPlafond != 'NO') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Add / Edit Sharing Plafond']"]));
	WebUI.delay(1);
	WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "5.1. Sharing Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);
	
	
	
	// ADD NEW CHILD
	for(int i=0; i<x-1; i++) {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Add New Child']"]));
	}
	
	// ADD SHARING PLAFOND
	for(int i=0; i<x; i++) {
		String index = "${i+1}";
		
		// jenis konsumen
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//p-radiobutton[@value='${jeniskonsumensharings[i]}'])[$index]"]));
		println(index);
		
		//no ktp / no npwp	
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//span[@class='p-float-label mt-4']//input)[$index]"]), nosharings[i]);
		
		// add new sharing plafon
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//span[text()='Add New Sharing Plafond'])[$index]"]));
		
		WebUI.delay(2);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "5.2. New Sharing Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);
		
		// kategori plafond
		try {
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Select']"]));
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='$KategoriPlafond']"]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// nominal plafond anak
		if(nominalplafondanaks[i] != "Sesuai") {
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//p-inputnumber[@id='nominalPlafondAnak']//input"]), nominalplafondanaks[i]);
		}
		else {
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//p-inputnumber[@id='nominalPlafondAnak']//input"]), NominalPlafond);
		}
		
		
		WebUI.delay(1);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "5.3. Input Sharing Plafond " + i) + '.png', FailureHandling.STOP_ON_FAILURE);
		
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save']"]));
	}
	
	for(int i=0; i<5; i++) {
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		WebUI.delay(0.5);
	}
	
	for(int i=1; i<=x+1; i++) {
		WebUI.delay(1);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "5.4. Hasil Input Sharing Plafond " + i) + '.png', FailureHandling.STOP_ON_FAILURE);
		WebUI.delay(1);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save as Draft']"]));
		
}

WebUI.delay(2);
///////////
	
for(int i=0; i<5; i++) {
	robot.keyPress(KeyEvent.VK_PAGE_UP);
	robot.keyRelease(KeyEvent.VK_PAGE_UP);
	WebUI.delay(0.5);
}

for(int i=1; i<=x+1; i++) {
	WebUI.delay(1);
	WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "6. Hasil Input Plafond " + i) + '.png', FailureHandling.STOP_ON_FAILURE);
	WebUI.delay(1);
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Save']"]));

WebUI.takeScreenshot((((baseDir + GlobalVariable.sspath)) + '/' + No  + '/' + 'Register Plafond' + '/' + '1. Add' + '/' + "8. Setelah Save Register Plafond") + '.png', FailureHandling.STOP_ON_FAILURE);


