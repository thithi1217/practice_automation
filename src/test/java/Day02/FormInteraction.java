package Day02;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class FormInteraction {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            //Click Form button
            MobileElement formBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            formBtnElem.click();
            Thread.sleep(3000);
            //Input fields
            MobileElement fieldInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            fieldInputElem.sendKeys("Mai Thi nè");
            Thread.sleep(3000);
            //Switch
            MobileElement switchBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            switchBtnElem.click();
            Thread.sleep(3000);
            //Click dropdown
            MobileElement dropdownSelectElem = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText"));
            dropdownSelectElem.click();
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
