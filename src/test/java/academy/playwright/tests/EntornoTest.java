package academy.playwright.tests;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class EntornoTest {
    @Test
    @DisplayName("Playwright y Chromium funcionan en este equipo")
    void shouldRunChromiumLocally() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
// HTML propio: no depende de Internet
            page.setContent("<h1 id='saludo'>Entorno listo</h1>");
            assertThat(page.locator("#saludo")).hasText("Entorno listo");
            browser.close();
        }
    }
}