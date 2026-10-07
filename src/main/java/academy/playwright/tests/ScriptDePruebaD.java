package academy.playwright.tests;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class ScriptDePruebaD {
    public static void main (String [] args ){
        try(Playwright playwright = Playwright.create()){
            Browser navegador= playwright.chromium().launch( // se manerja el playwright chromium para invocar chrome para navegar
                    new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            Page pagina= navegador.newPage();
            pagina.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // navigate es para mandar la url a la que se quiere ingresar.
            pagina.getByPlaceholder("Username").fill("Admin"); //Se manda a identificar una etiqueta que tenga el placeholder de
            pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/IngresarUsuario.png")));
            pagina.getByPlaceholder("password").fill("admin123");
            pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/Ingresarpassword.png")));
            System.out.println("Se ingresaron 2 valores en la pagina"+ pagina.url());
            navegador.close();

        }
    }
}
