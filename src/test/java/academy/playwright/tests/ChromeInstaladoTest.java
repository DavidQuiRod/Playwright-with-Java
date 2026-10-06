package academy.playwright.tests;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
public class ChromeInstaladoTest {
    @Test
    void shouldUseInstalledChrome() {
        try (Playwright playwright = Playwright.create()) {
// channel "chrome" usa el Chrome real del equipo
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setChannel("chrome"));
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com");
            assertThat(page).hasTitle("Swag Labs");
            browser.close();
        }
    }
}