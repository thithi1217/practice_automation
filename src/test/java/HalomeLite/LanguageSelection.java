package HalomeLite;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.List;

public class LanguageSelection {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        //Nhan mo modal lua chon ngon ngu
        MobileElement languageSelectionBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_go_to_select_language"));
        languageSelectionBtn.click();

        //Chon ngon ngu
        List<MobileElement> languageList = appiumDriver.findElements(MobileBy.xpath("//*[@class=\"android.widget.FrameLayout\"]"));

    }
}
