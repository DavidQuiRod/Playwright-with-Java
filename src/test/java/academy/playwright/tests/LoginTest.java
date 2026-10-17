package academy.playwright.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import academy.playwright.base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    private static final String BASE_URL= "https://www.saucedemo.com";

    //Metodo auxiliar: llena el formulario y pulsa Login
    private void login(String user, String password){
        page.navigate(BASE_URL);
        page.getByPlaceholder("Username").fill("standard_user");
        page.getByPlaceholder("Password").fill("secret_sauce");
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login")).click();
    }

    @Test
    @DisplayName("Un usuario válido entra al catálogo de productos")
    void shouldLoginWithValidCredentials(){
        login("standard_user","secret_sauce");
  /*  primera parte del script de como se puede ingresar valores directos, se cambiara para usar una funcion donde se se mande a llamar una funcion
    //Arrange: Abrir la pagina login
        page.navigate(BASE_URL);

        //Act: completar el formulario y pulsar login
        page.getByPlaceholder("Username").fill("standard_user");
        page.getByPlaceholder("Password").fill("secret_sauce");
        page.getByRole(AriaRole.BUTTON,
          new Page.GetByRoleOptions().setName("Login")).click();
*/
        //Assert: estamos en el inventario y se ve el titulo
        assertThat(page).hasURL(BASE_URL+"/inventory.html");
        assertThat(page.getByTestId("title")).hasText("Products");
    }

    @Test
    @DisplayName("Un usuario bloqueado ve un mensaje de error")
    void shouldShowErrorForLockedOutUser() {
        login("locked_out_user", "secret_sauce");
        //assertThat(page.getByTestId("error")).containsText("locked out");
        // Texto exacto
        assertThat(page.locator("[data-test='error']"))
                .hasText("Epic sadface: Sorry, this user has been locked out.");
        // Seguimos en la página de login: no hubo redirección
        assertThat(page).hasURL(BASE_URL);
    }


    @Test
    @DisplayName("Una contraseña incorrecta muestra un mensaje de error")
    void shouldShowErrorForWrongPassword() {
        login("standard_user", "clave_incorrecta");
        assertThat(page.getByTestId("error"))
                .containsText("Epic sadface: Username and password do not match any user in this service");
                //.containsText("do not match any user");
    }

}
