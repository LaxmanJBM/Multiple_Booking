package JobBookingTest;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BrowserCode;
import BookingScreen.FirstPage;
import BookingScreen.SecondPage;
import Utility.CommonFiles;



public class BookingTest extends BrowserCode{
	 private WebDriver driver;
	    private FirstPage pg1;
	    private SecondPage pg2;
	@BeforeMethod
	public void setup() throws Exception {
		driver = getRemoteDriver();
        Thread.sleep(1000);
        pg1 = new FirstPage(driver);
        pg2 = new SecondPage(driver);
        
        driver.get(readExcelFileFinal(3, 1));
        pg1.verifyLoginApp();
		Thread.sleep(2000);

		pg1.verifyIFFBtn();
		Thread.sleep(2000);
		pg1.verifySalesBtn();
		Thread.sleep(2000);
		pg1.verifyBookingBtn();
		Thread.sleep(2000);
		pg2.verifyNewBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}


	
	@Test( enabled =true)
	public void data() throws Exception {
		 FileInputStream file1=new FileInputStream("InputData/BookingData.xlsx");		
			XSSFWorkbook workbook=new XSSFWorkbook(file1);
			XSSFSheet sheet = workbook.getSheet("basicDetail");
			int rowcount = sheet.getLastRowNum();
			int row= rowcount - 6;
			int colcount = sheet.getRow(7).getLastCellNum();
			System.out.println("rowcount in test:"+row+" colcount in test:"+colcount);
	
	//	System.out.println("ROW COUNT IN FINAL TEST ="+row);	
		
		for(int exec=1;exec<=row;exec++) {
			Thread.sleep(2000);
		
			pg2.verifyBasicDetails(exec);
		
			pg2.verifyServiceDetails(exec);
		
			pg2.verifyAdditionalDetails(exec);
		
			pg2.allContanerDetails(exec);
		
			pg2.allVehiPackingList(exec);
		
			pg2.verifyCostRevenue(exec);
		
			pg2.saveBtn();
			System.out.println("*** JOB BOOKING DONE : "+exec+" ***");
	
	}
	
	}
	

	@AfterMethod
	
	public void exit() throws Exception
	{
	/*	if(ITestResult.FAILURE == b.getStatus())
		{	
			CommonFiles.captureScreenshotFaildTC(driver,b.getName());
		}*/
		Thread.sleep(2500);
		driver.quit();
	
	}
	

}
