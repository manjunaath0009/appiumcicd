package com.qa.pages;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDetailsPage extends MenuPage {
    TestUtils utils = new TestUtils();

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    // @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement title;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    // @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    private MobileElement desc;

    @AndroidFindBy (accessibility = "test-BACK TO PRODUCTS")
    private MobileElement backToProductsBtn;

    public String getTitle() {
        return getText(title, "title is: ");
    }

    public String getDesc() {
        return getText(desc, "description is: ");
    }

    public String getPrice() throws Exception {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                return getText(andScrollToElementUsingUiScrollable("description", "test-Price"), "price is: ");
            default:
                throw new Exception("Invalid platform name");
        }
    }

    public ProductsPage pressBackToProductsBtn() {
        click(backToProductsBtn, "navigate back to products page");
        return new ProductsPage();
    }

    public ProductDetailsPage pressProductTitle(String title) throws Exception {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
                return new ProductDetailsPage();
            default:
                throw new Exception("Invalid platform name");
        }
    }

}

