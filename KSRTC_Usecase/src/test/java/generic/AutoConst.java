package generic;

/*Interface with 'AutoConst' is created within the generic package to contain the constants 
(common values that will remain the same)*/

public interface AutoConst {

//Passing the Key and Value for Browser executables, BaseURL and the Test Date sheet//
static String CHROME_KEY="webdriver.chrome.driver";
static String CHROME_VALUE="./drivers/chromedriver.exe";
static String INPUT_PATH="./TestData/data.xlsx";
}

