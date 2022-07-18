package Day03;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.List;

public class XPathLearning {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {

            // Find and click login button
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            // Cach 1: Find all matching element
            List<MobileElement> creadInputFileElems = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final  int PASSWORD_INDEX = 1;

            creadInputFileElems.get(USERNAME_INDEX).sendKeys("maithi@gmail.com");
            creadInputFileElems.get(PASSWORD_INDEX).sendKeys("123456789");

            Thread.sleep(5000);
            //Cach 2: Find by text
            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.xpath("//*[@text=\"Email\"]"));
            emailInputElem.sendKeys("maithine@gmail.com");
            Thread.sleep(5000);
            //Cach 3:
//            MobileElement loginInstructionElem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
//            System.out.println(loginInstructionElem.getText());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
