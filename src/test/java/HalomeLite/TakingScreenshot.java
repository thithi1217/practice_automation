package HalomeLite;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TakingScreenshot {
    public static void main(String[] args) {
        //Add one more dependency: commons-io
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement loginAnonymouslyBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginAnonymouslyBtn.click();

            Thread.sleep(3000);
            //Full screen
//            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
//            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("dangnhapandanh.png");
//            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));
            //An area
//            MobileElement loginAnonymouslyForm = appiumDriver.findElement(MobileBy.id("android:id/content"));
//            File base64ScreenshotData = loginAnonymouslyForm.getScreenshotAs(OutputType.FILE);
//            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("dangnhapandanh-area.png");
//            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));
            // An element
            MobileElement backBtnElm = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/back_login_phone_number"));
            File base64ScreenshotData = backBtnElm.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("buttonBack.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
