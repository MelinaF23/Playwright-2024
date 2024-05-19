package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;
import static
        com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
        ;
public class App2 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://clockify.me/");
            page.navigate("https://app.clockify.me/en/login?abtesting=Mega%2520menu%2520changed%2520-%2520A");
            page.navigate("https://app.clockify.me/en/login");
            page.locator("[data-test-id=\"login-manual\"]").click();
            page.getByPlaceholder("Enter email").click();
            page.getByPlaceholder("Enter email").fill("pruebadepruebamelina@yopmail.com");
            page.getByPlaceholder("Enter email").press("Tab");
            page.getByPlaceholder("Enter password").fill("123123");
            page.locator("[data-test-id=\"login-button\"]").click();
            page.locator("a").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Project$"))).click();
            page.locator("a").filter(new Locator.FilterOptions().setHasText("Create new project")).click();
            page.getByPlaceholder("Enter project name").click();
            page.getByPlaceholder("Enter project name").press("CapsLock");
            page.getByPlaceholder("Enter project name").fill("A");
            page.getByPlaceholder("Enter project name").press("CapsLock");
            page.getByPlaceholder("Enter project name").fill("Academy1");
            assertThat(  page.locator("a").filter(new Locator.FilterOptions().setHasText("Academy1")));
        }
    }
}