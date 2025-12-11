package org.example.stepsdefinitions;


import io.cucumber.java.es.*;
import org.example.core.DriverManager;
import org.openqa.selenium.WebDriver;

public class StoreStepsDef {

    WebDriver driver = DriverManager.driver;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver.get("https://qalab.bensg.com/store");
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueo(String user, String pass) {

    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoCategoria(String cat, String sub) {

    }

    @Y("agrego 2 unidades del primer producto al carrito")
    public void agregoProducto() {

    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoPopupConfirm() {

    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoMontoPopup() {

    }

    @Cuando("finalizo la compra")
    public void finalizoCompra() {

    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoTituloCarrito() {

    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void validoCalculoCarrito() {

    }
}
