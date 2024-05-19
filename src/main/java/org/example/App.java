package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;
import static
        com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
        ;
//public class App {
    //public static void main(String[] args) {
        //try (Playwright pw = Playwright.create()) {
           // Browser browser = pw.chromium().launch(new
                    //BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            //Page page = browser.newPage();
            //page.navigate("https://clockify.me/");
            //System.out.println(page.title());
            //assertThat( page ).hasTitle( Pattern.compile("Playwright") );
       // }
   // }
//}

    public class App {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://clockify.me/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in").setExact(true)).click();
            page.getByPlaceholder("Enter email").click();
            page.getByPlaceholder("Enter email").fill("pruebadeprueba@yopmail.com");
            page.locator("[data-test-id=\"login-button\"]").click();
            page.locator(".cl-verification-code-input").first().fill("1");
            page.locator("div:nth-child(2) > .cl-form-group > .cl-verification-code-input").fill("2");
            page.locator("div:nth-child(3) > .cl-form-group > .cl-verification-code-input").fill("3");
            page.locator("div:nth-child(5) > .cl-form-group > .cl-verification-code-input").fill("1");
            page.locator("div:nth-child(6) > .cl-form-group > .cl-verification-code-input").fill("2");
            page.locator("div:nth-child(7) > .cl-form-group > .cl-verification-code-input").fill("3");
            page.getByText("That code isn't valid. Please try again.").click();
            assertThat( page.getByText("That code isn't valid. Please try again.") );
        }
    }
}
