package Day05;

import driver.AppPackage;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.time.Duration;
import java.util.List;
import java.io.File;

public class HandleMultipleApps {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            //2
            MobileElement loginAnonymouslyBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginAnonymouslyBtn.click();

            //3
            MobileElement phoneNumberInput = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phoneNumber_add_phone_num_edittext"));
            MobileElement startBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phoneNumber_get_start_button"));

            phoneNumberInput.sendKeys("0834791712");
            startBtn.click();

            //4
            MobileElement sendCodeSMSBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/txt_sms_otp"));

            sendCodeSMSBtn.click();
            //Thread.sleep(1000);
            List<MobileElement> enterCodeInput = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            for (MobileElement code : enterCodeInput) {
                code.sendKeys("0");
            }
            Thread.sleep(1000);
            //5 Put the Halome Lite app into background || similar with pressing home btn
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            //6 Switch to Settings app (create "AppPackage" interface file at "driver" package to use)

            appiumDriver.activateApp(AppPackage.settings);

            //7 Find the way to turn off Wifi and Mobile network - 4G
            //MobileElement networkinternet = appiumDriver.findElement(MobileBy.xpath("//android.widget.RelativeLayout"));

            ((AndroidDriver) appiumDriver).toggleWifi();
            ((AndroidDriver) appiumDriver).toggleData();

            //8 Comeback to Halome Lite app
            appiumDriver.activateApp(AppPackage.halomeLite);
            //9 Take screenshot (Lost internet connection - Loading)
            Thread.sleep(5000);
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("loading.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
