package academy.playwright.tests;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class ScriptDePruebaD {
    public static void main (String [] args ){
        try(Playwright playwright = Playwright.create()){
            Browser navegador= playwright.chromium().launch( // se manerja el playwright chromium para invocar chrome para navegar
                    new BrowserType.LaunchOptions().setHeadless(true).setSlowMo(500));
            Page pagina= navegador.newPage();
            pagina.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // navigate es para mandar la url a la que se quiere ingresar.
            pagina.getByPlaceholder("Username").fill("Admin"); //Se manda a identificar una etiqueta que tenga el placeholder de
            //pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/IngresarUsuario.png")));
            pagina.getByPlaceholder("password").fill("admin123");
            //pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/Ingresarpassword.png")));
            //Buena practica
            //pagina.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login")).click();
            //Funcional
            //pagina.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
            //Mas rapido y directo
            /*Antes de usar la siguiente linea hay que revisar que se esta apuntando bien al elemento
            * o botón porque puede haber muchos con esa descripcion
            * existe .first() para el primer elemento
            * para identificar el segundo se utiliza el nth(#numero del elemento si es el segundo agregar 1
            * Esto porque es como un vector el 1 es 0, el 2 es el 1 y asi sucecivamente)*/
            pagina.getByText("Login").nth(1).click();
            //pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/DarClickEnBotonLogin.png")));
            System.out.println("Se ingresaron 2 valores en la pagina "+ pagina.url());
            navegador.close();
        }
    }
}
