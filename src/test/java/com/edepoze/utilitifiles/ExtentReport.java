package com.edepoze.utilitifiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReport extends TestListenerAdapter {
	ReadConfigPropertiesFile obj = new ReadConfigPropertiesFile();
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	 OutputData report=new OutputData();
	public void onStart(ITestContext testContext) {
		
//		/ Create folder with current date
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
		Date currentDate = new Date();
		String folderName = dateFormat.format(currentDate);
		String folderPath = System.getProperty("user.dir") + "/Automation Testing Report/" + folderName;
		File folder = new File(folderPath);
		if (!folder.exists()) {
		    folder.mkdirs();
		}
		
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = obj.Environment()+"_automation_test_report " + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(folderPath +"//"+ repName);
		String report1= System.getProperty(folderPath +"//"+ repName);
		
		try {
			report.WriteExcel("Sheet1", report1, 12, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extentreportconfiguration.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "MuraliKrishna & IndiraSai");
		extent.setSystemInfo("Environment", "eDepoze " +obj.Environment()+ " Environment");
		extent.setSystemInfo("User", "MuraliKrishna & IndiraSai");
		htmlReporter.config().setDocumentTitle("eDepoze Automation");
		htmlReporter.config().setReportName("Functional Automation Testing Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
        Date currentDate = new Date();
        String folderName = dateFormat.format(currentDate);
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" +folderName+"\\"+ tr.getName() + ".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
			try {
				logger.pass(tr.getName() + "Is Passed ", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotbase64(tr)).build());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}
	public void onTestFailure(ITestResult tr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
        Date currentDate = new Date();
        String folderName = dateFormat.format(currentDate);
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); 																				
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" +folderName+"\\"+ tr.getName() + ".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
			try {
				logger.fail(tr.getName() + "Is Failed ", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotbase64(tr)).build());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}																				
	}
	
public  String screenshotbase64(ITestResult tr) throws FileNotFoundException, IOException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
    Date currentDate = new Date();
    String folderName = dateFormat.format(currentDate);
		String path=System.getProperty("user.dir")+"\\Screenshots\\"+folderName+"\\"+tr.getName()+".png";
		byte[] Image=IOUtils.toByteArray(new FileInputStream(path));
		return Base64.encodeBase64String(Image).toString();
	}
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}