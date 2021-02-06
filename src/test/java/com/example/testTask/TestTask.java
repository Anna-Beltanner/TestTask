package com.example.testTask;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTask {

    private static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, "http://severotek-automation.ru/upload/12933-App-Android.apk");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void skipHelloScreens() {
        MobileElement declineButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.Button[2]");
        declineButton.click();
        MobileElement declineButton2 = driver.findElement(By.id("com.mobium8918.app:id/decline_button"));
        declineButton2.click();
        MobileElement cityButton = driver.findElement(By.id("com.mobium8918.app:id/region_title_text_view"));
        cityButton.click();
        MobileElement categoryItem = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]");
        categoryItem.click();
        MobileElement subCategoryItem = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[1]");
        subCategoryItem.click();
        MobileElement productItem = driver.findElementByXPath(" /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        productItem.click();
        MobileElement addToCart = driver.findElement(By.id("com.mobium8918.app:id/stepper_main_button"));
        addToCart.click();
        MobileElement plusIcon = driver.findElement(By.id("com.mobium8918.app:id/stepper_plus_button"));
        plusIcon.click();
        plusIcon = driver.findElement(By.id("com.mobium8918.app:id/stepper_plus_button"));
        plusIcon.click();
        MobileElement cart = driver.findElement(By.id("com.mobium8918.app:id/action_cart"));
        cart.click();

        MobileElement cartItemText = driver.findElement(By.id("com.mobium8918.app:id/titleTextView"));
        String text = cartItemText.getText();

        MobileElement cartItemCount = driver.findElement(By.id("com.mobium8918.app:id/stepper_number_button"));
        String count = cartItemCount.getText();

        assertThat(text).isEqualTo("Миска для животных ХОРОШКА двойная пластиковая голубая 150\\250мл");
        assertThat(count).isEqualTo("3");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
