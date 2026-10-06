package academy.playwright.tests;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class MotoresTest {
    @ParameterizedTest(name = "Motor: {0}")
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void shouldOpenSauceDemoInEveryEngine(String nombre) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType tipo = switch (nombre) {
                case "firefox" -> playwright.firefox();
                case "webkit" -> playwright.webkit();
                default -> playwright.chromium();
            };
            Browser browser = tipo.launch();
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com");
            assertThat(page).hasTitle("Swag Labs");
            browser.close();
        }
    }
}
