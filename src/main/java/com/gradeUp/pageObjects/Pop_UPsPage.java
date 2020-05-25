package com.gradeUp.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Pop_UPsPage {

    public Pop_UPsPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "[@reference_id='co.gradeup.android:id/inapp_half_interstitial_image_frame_layout']/following-sibling::android.widget.ImageView")
    public AndroidElement doneButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TURN ON']")
    public AndroidElement confirmPopOnChangingExam;


}
