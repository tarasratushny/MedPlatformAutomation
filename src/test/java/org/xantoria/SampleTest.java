package org.xantoria;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {

    Playwright playwright;
    Browser browser;

    BrowserContext context;
    Page page;

    @BeforeClass
    void launchBrowser(){
       playwright = Playwright.create();
       browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterClass
    void closeBrowser(){
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    void closeContext(){
        context.close();
    }

    @Test
    void customerLogin() throws InterruptedException {

        page.navigate("https://dev-mp.dontburn.space/");
        page.locator("//a[@class='profile_image']").click();

        Thread.sleep(50000);

    }

    @Test
    void googleTest() throws InterruptedException {

        page.navigate("https://www.google.com/");
        page.locator("//textarea[@title='Пошук']").fill("hello");

        Thread.sleep(50000);
    }
}
