package HalomeLite;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.List;

public class LoginAnonymously {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement loginAnonymouslyBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginAnonymouslyBtn.click();
            //Nhap so dien thoai
            MobileElement phoneNumberInput = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phoneNumber_add_phone_num_edittext"));
            phoneNumberInput.sendKeys("0834791712");
            //Tat keyboard
            MobileElement clickanything = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phonenumber_hello_textview"));
            clickanything.click();
            //Nhan Bat dau
            MobileElement startBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phoneNumber_get_start_button"));
            startBtn.click();
            //Nhan Gui ma xac thuc qua SmS
            MobileElement guiMaSMSLink = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/txt_sms_otp"));
            guiMaSMSLink.click();
            //Nhap ma xac thuc
            List<MobileElement> enterCodeInput = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            for (MobileElement code : enterCodeInput) {
                code.sendKeys("0");
            }

            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
