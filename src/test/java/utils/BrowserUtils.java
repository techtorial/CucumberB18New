package utils;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void selectBy(WebElement location,String value,String methodName){
        Select select=new Select(location);

        switch (methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
//                Assert.fail("The value,location,method name are wrong");
                Assert.fail("The value,location,method name are wrong");
        }
    }
    public static String getTitleJS(WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();
    }
    public static void clickWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }
    public static void scrollIntoView(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void switchWindow(WebDriver driver,String title){
        Set<String> allPagesId=driver.getWindowHandles();//4 ids
        for(String pageId:allPagesId){
            driver.switchTo().window(pageId);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void getScreenShotWithCucumber(WebDriver driver, Scenario scenario){
        Date date=new Date();//java.util
        String screenShotFileName=date.toString().replace(" ","-")
                .replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    public static void getScreenShot(WebDriver driver,String packageName){
//        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String location=System.getProperty("src/test/java/"+packageName+"/");
//        try {
//            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
