package academy.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
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
            page.getByPlaceholder("Password").fill("secret_sauce");
            page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Login")).click();
            System.out.println("URL tras el login: " + page.url());
            browser.close();
        }
    }
}