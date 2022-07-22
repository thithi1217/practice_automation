package Day04;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

public class HalomeLite {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
           // MobileElement anyElem = appiumDriver.findElement(MobileBy);
//            MobileElement loginHHLLBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
//            loginHHLLBtn.click();
            //Thread.sleep(5000);

            MobileElement loginAnonymouslyBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginAnonymouslyBtn.click();
//            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.xpath("//*[@text=\"Email hoặc số điện thoại\"]"));
//            emailInputElem.click();
//            emailInputElem.sendKeys("bumbum7st@gmail.com");
//            MobileElement pwdInputElem = appiumDriver.findElement(MobileBy.id("passwork"));
//            pwdInputElem.sendKeys("maithi123");
//            Thread.sleep(5000);
//            List<MobileElement> editText = appiumDriver.findElements(MobileBy.className("android.widget.EditText"));
//            editText.get(0).sendKeys("bumbum7st@gmail.com");
//            editText.get(1).sendKeys("maithi123");
//
//            MobileElement dangnhapBtnElem = appiumDriver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button"));
            //dangnhapBtnElem.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
