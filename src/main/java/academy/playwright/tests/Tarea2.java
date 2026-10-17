package academy.playwright.tests;


import com.microsoft.playwright.*;

import java.nio.file.Paths;

// vamos a automatizar la pagina de liverpool con playwright y java, se simulara que se compra un smartphone
public class Tarea2 {
    public static void main (String [] args){
    try(Playwright pwg = Playwright.create() ){
        Browser navegadorD= pwg.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page pagina= navegadorD.newPage();
        pagina.navigate("https://www.liverpool.com.mx/tienda/home"); //Ingresamos a liverpool
        pagina.getByPlaceholder("Buscar por producto, categoría y más...").first().fill("Telefono");
        pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/IngresarValor.png")));
        System.out.println("Se ingreso el valor de telefono en la pagina de liverpool");
        //pagina.getByTestId("blt26617d4f2e17657d-header-search-search-custom-icon").first().click();
        pagina.keyboard().press("Enter");
        pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/SegundaPagina.png")));
        pagina.getByText("Galaxy A17 Super AMOLED 6.7 pulgadas").first().click();
        System.out.println("Se da click en el galaxy a17 para ver los detalles");
        Locator etiquetaDeDescripcion= pagina.locator("h1");
        String descripcionDeArticulo=etiquetaDeDescripcion.textContent();
        if(descripcionDeArticulo.equals("Galaxy A17 Super AMOLED 6.7 pulgadas")){
            System.out.println("Los valores coinciden");
            pagina.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("evidencias/EtiquetaDescripcion.png")));
        } else {
            System.out.println("Error no son los mismos valores");
        }
    }
    }

}
