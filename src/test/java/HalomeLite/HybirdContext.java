package HalomeLite;

import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.Set;

public class HybirdContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement loginAnonymouslyBtn = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_halome_button"));
            loginAnonymouslyBtn.click();

            Thread.sleep(5000);

            //Wait until we have more than one context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            Set<String> contextNames = appiumDriver.getContextHandles();
            for (String contextName : contextNames) {
                if (contextName.contains("WEBVIEW")){
                    appiumDriver.context(contextName);
                }
            }

//            String context = appiumDriver.getContext();
//            System.out.println(context);
            WebElement emailInputElem = appiumDriver.findElement(By.cssSelector("#accountId"));
            WebElement pwdInputElem = appiumDriver.findElement(By.cssSelector("#password"));
            WebElement loginBtnElem = appiumDriver.findElement(By.cssSelector("[type='submit']"));

            emailInputElem.sendKeys("bumbum7st@gmail.com");
            pwdInputElem.sendKeys("maithi123");
            loginBtnElem.click();

            Thread.sleep(5000);

            appiumDriver.context("NATIVE_APP");

            MobileElement continueBtnElm = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/btn_continue"));
            continueBtnElm.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
