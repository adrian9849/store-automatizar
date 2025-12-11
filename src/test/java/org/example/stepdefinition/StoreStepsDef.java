package org.example.stepdefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.es.*;
import org.example.steps.StoreSteps;

public class StoreStepsDef {

    private StoreSteps steps = new StoreSteps();

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaTienda() {
        steps.abrirTienda();
    }

    @When("me logueo con mi usuario {string} y clave {string}")
    public void loginStore(String usuario, String clave) {
        steps.login(usuario, clave);
    }

    @Entonces("valido que no ingreso a la página principal")
    public void validarLoginFallido() {
        steps.validarLoginFallido();
    }

    @Entonces("valido que login valido")
    public void validarLoginCorrecto() {
        steps.validarLoginExitoso();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegarCategoria(String categoria, String subcategoria) {
        steps.irCategoria(categoria, subcategoria);
    }

    @Entonces("valido que no existe la categoría")
    public void validarCategoriaInexistente() {
        steps.validarCategoriaInexistente();
    }

    @Entonces("valido que estoy en la categoría correcta")
    public void validarCategoriaCorrecta() {
        steps.validarCategoriaCorrecta();
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agregarProducto(int cantidad) {
        steps.agregarPrimerProducto(cantidad);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validarPopupStore() {
        steps.validarPopupCorrecto();
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void validarMontoPopup() {
        steps.validarMontoPopup();
    }

    @Cuando("finalizo la compra")
    public void finalizarCompra() {
        steps.finalizarCompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validarTituloCarritoStore() {
        steps.validarTituloCarrito();
    }

    @Entonces("vuelvo a validar el calculo de precios en el carrito")
    public void validarCalculoCarrito() {
        steps.validarCalculoCarrito();
    }
}
