package models.pages;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginEnterPhoneNumberScreen {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By phoneNumberSel = MobileBy.id("com.halome.android.lite:id/phoneNumber_add_phone_num_edittext");
    private final static By getStartedBtnSel = MobileBy.id("com.halome.android.lite:id/phoneNumber_get_start_button");

    public LoginEnterPhoneNumberScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public MobileElement phoneNumberElem(){
        return appiumDriver.findElement(phoneNumberSel);
    }
    public MobileElement getStartedBtnElem(){
        return appiumDriver.findElement(getStartedBtnSel);
    }
    //
    public void inputPhoneNumber(String phoneNumber){
        if (!phoneNumber.isEmpty()){
            phoneNumberElem().sendKeys(phoneNumber);
        }
    }
    public void clickGetStartedBtn(){
        getStartedBtnElem().click();
    }
}
