package Day04;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LanguageSelection {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement languageBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_go_to_select_language"));
            languageBtnElem.click();

//            MobileElement checkLanguageBtn = appiumDriver.findElement(MobileBy.xpath("//*[@text=\"English\"]"));
//            checkLanguageBtn.click();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
