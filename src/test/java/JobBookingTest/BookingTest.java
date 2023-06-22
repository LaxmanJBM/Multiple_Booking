package JobBookingTest;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Browser;
import BookingScreen.JobBooking1;
import BookingScreen.JobBooking2;

public class BookingTest extends Browser{
	JobBooking1 jb1;
	JobBooking2 jb2;

	@BeforeMethod
	public void setup() throws Exception {

		initilization();
		jb1 = new JobBooking1();
		jb2 = new JobBooking2();
		jb1.verifyLoginApp();
		Thread.sleep(2000);

		jb1.verifyIFFBtn();
		Thread.sleep(2000);
		jb1.verifySalesBtn();
		Thread.sleep(2000);
		jb1.verifyBookingBtn();
		Thread.sleep(2000);
		jb2.verifyNewBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}


	
	@Test( enabled =true)
	public void data() throws Exception {
		 FileInputStream file1=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\MainBooking\\InputData\\BookingData.xlsx");	
			
			
			XSSFWorkbook workbook=new XSSFWorkbook(file1);
			XSSFSheet sheet = workbook.getSheet("basicDetail");
			int rowcount = sheet.getLastRowNum();
			int row= rowcount - 6;
			int colcount = sheet.getRow(7).getLastCellNum();
			System.out.println("rowcount in test:"+row+" colcount in test:"+colcount);
	
	//	System.out.println("ROW COUNT IN FINAL TEST ="+row);	
		
		for(int exec=1;exec<=row;exec++) {
			Thread.sleep(2000);
		
			jb2.verifyBasicDetails(exec);
		
			jb2.verifyServiceDetails(exec);
		
			jb2.verifyAdditionalDetails(exec);
		
			jb2.allContanerDetails(exec);
		
			jb2.allVehiPackingList(exec);
		
			jb2.verifyCostRevenue(exec);
		
			jb2.saveBtn();
	
	}
	
	}
	

	@AfterMethod
	
	public void exit()
	{
	//	driver.quit();
	}
	

}
