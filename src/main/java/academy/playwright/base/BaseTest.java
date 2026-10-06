/*package academy.playwright.base;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
public abstract class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;
    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        playwright.selectors().setTestIdAttribute("data-test");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(headless));
    }
    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }
    @BeforeEach
    void createContext() {
        context = browser.newContext();
        page = context.newPage();
    }
    @AfterEach
    void closeContext() {
        context.close();
    }
}*/