package academy.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class ScriptConVentana {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false) // muestra la ventana
                            .setSlowMo(600)); // 600 ms entre acciones
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com");
            page.getByPlaceholder("Username").fill("standard_user");
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/foto1.png"))); // co
            page.getByPlaceholder("Password").fill("secret_sauce");
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/foto2.png")));
            page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Login")).click();
            System.out.println("URL tras el login: " + page.url());
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/foto3.png")));
            browser.close();
        }
    }
}