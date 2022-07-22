package Day03;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeAction {
    private AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;
    public SwipeAction(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver=appiumDriver;
        touchAction = new TouchAction(this.appiumDriver);
        //Get mobile screen sizes
        Dimension windowsSize = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowsSize.getHeight();
        int screenWidth = windowsSize.getWidth();

        //
        int xStartPoint = 70*screenWidth/100;
        int xEndPoint = 10*screenWidth/100;
        int yStartPoint = 70*screenHeight/100;
        int yEndPoint = 70*screenHeight/100;

        //Perform the touch actions
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
    }
    public void swipeFromRightToLeft(int times) {
        for(int initTime=0; initTime<times; initTime++){
            this.swipeFromRightToLeft();
        }
    }
    public void swipeFromRightToLeft() {


        //TouchAction touchAction = new TouchAction(this.appiumDriver);

        //Swipe from left to right direction
        touchAction
                .longPress(startPoint)
                        .moveTo(endPoint)
                        .release()
                        .perform();

    }

}
