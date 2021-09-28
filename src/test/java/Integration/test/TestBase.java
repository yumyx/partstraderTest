package Integration.test;


import Integration.Params.ParamInput;
import Integration.util.ExtentManager;
import Integration.util.WDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.gson.Gson;

import java.io.*;

public class TestBase {
	public WDriver driver;
	private ExtentTest extent_test;

    public ParamInput getParameter() {
        return parameter;
    }

    protected ParamInput parameter;
	//private static final ExtentReports extentReports = new ExtentReports();
	
    public WDriver initDriver() {
      driver = new WDriver();
    	
	  return driver.init();
    }

    public void initReport(String testname) {
    	ExtentReports reports = ExtentManager.getReport();
        extent_test = reports.createTest(testname);
        
    }

    public ExtentTest getExtentTest(){
        return extent_test;
    }

    static String fileLocation = "./resources/";

    public static ParamInput readFile(String jsonfile) {
       // String dataFile = fileLocation +"testCase1.json";
        String dataFile = fileLocation +jsonfile;
        System.out.println("@@@@ data file:"+dataFile);


        Gson gson = new Gson();
        ParamInput params=null;
        BufferedReader br = null;
        try {

             br = new BufferedReader(
                    new FileReader(dataFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
            //convert the json string back to object
            //DataObject obj = gson.fromJson(br, DataObject.class);
             params = gson.fromJson(br,ParamInput.class);
        /*
            Type listType = new TypeToken<List<ParamInput>>() {}.getType();

            List<ParamInput> list = gson.fromJson(br, listType);
            for(ParamInput pi : list){
                System.out.println("json "+pi.getProduct().getColour());
            }
            return list.get(0);

         */


        return params;


    }
    public static void readArray(){
        String dataFile = fileLocation +"testYellow.json";
        Gson gson = new Gson();

    }
    public void takeScreenshot(String testname){
        driver.takeScreenShot(testname);
    }
    public void extentReportFlush() {
        ExtentManager.getReport().flush();
    }

    public static void main(String[] args){
        readFile("testYellow.json");
    }
}
