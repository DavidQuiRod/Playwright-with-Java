package academy.playwright.tests;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
public class VersionTest {
    @Test
    void shouldPrintChromiumVersion() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            String version = browser.version();
            System.out.println("Chromium versión: " + version);
            assertFalse(version.isBlank());
            browser.close();
        }
    }
}