package academy.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;
public class PrimerScript {
    public static void main(String[] args) {
// try-with-resources: Playwright se cierra solo al terminar
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com");
            System.out.println("Título: " + page.title());
            System.out.println("URL: " + page.url());
// Guardar una captura (la carpeta se crea si no existe)
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/portada.png")));
            System.out.println("Captura guardada en target/screenshots/portada.png");
            context.close();
            browser.close();
        }
    }
}