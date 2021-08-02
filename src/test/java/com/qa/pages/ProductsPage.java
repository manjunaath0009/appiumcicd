package com.qa.pages;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

public class ProductsPage extends MenuPage {
    TestUtils utils = new TestUtils();

    // @AndroidFindBy (xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding-sibling::android.view.ViewGroup/android.widget.TextView")
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement titleTxt;

    public String getTitle() {
        return getText(titleTxt, "product page title is - ");
    }

    public String getProductTitle(String title) throws Exception {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);
            default:
                throw new Exception("Invalid platform name");
        }
    }

    public By defProductPrice(String title) throws Exception {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
            default:
                throw new Exception("Invalid platform name");
        }
    }

    public String getProductPrice(String title, String price) throws Exception {
        return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
    }

    public ProductDetailsPage pressProductTitle(String title) throws Exception {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
                click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
                return new ProductDetailsPage();
            default:
                throw new Exception("Invalid platform name");
        }
    }
}

