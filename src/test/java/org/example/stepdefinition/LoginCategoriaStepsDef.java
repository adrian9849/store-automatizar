package org.example.stepdefinition;

import io.cucumber.java.es.*;
import org.example.steps.StoreSteps;

public class LoginCategoriaStepsDef {

    private StoreSteps steps = new StoreSteps();

    // LOGIN
    @Dado("estoy en la página de la tienda")
    public void estoyEnLaTienda() {
        steps.abrirTienda();
    }

    @Dado("me logueo con mi usuario: {string} y clave: {string}")
    public void loginCategorias(String correo, String clave) {
        steps.login(correo, clave);
    }

    @Entonces("valido que login {string}")
    public void validarResultadoLogin(String resultado) {
        if(resultado.equalsIgnoreCase("valido")) {
            steps.validarLoginExitoso();
        } else {
            steps.validarLoginFallido();
        }
    }

    // CATEGORIAS
    @Cuando("navego a la categoria: {string} y subcategoria: {string}")
    public void navegarCategoria(String categoria, String subcategoria) {
        steps.irCategoria(categoria, subcategoria);
    }

    @Entonces("valido resultado categoria: {string}")
    public void validarResultadoCategoria(String resultado) {
        if(resultado.equalsIgnoreCase("valida")) {
            steps.validarCategoriaCorrecta();
        } else {
            steps.validarCategoriaInexistente();
        }
    }

    // FLUJO COMPLETO
    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegarCategoriaFlujo(String categoria, String subcategoria) {
        steps.irCategoria(categoria, subcategoria);
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agregarProducto(int cantidad) {
        steps.agregarPrimerProducto(cantidad);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validarPopupCategoria() {
        steps.validarPopupCorrecto();
    }

    @Entonces("valido en el popup que el monto total sea calculado correctamente")
    public void validarMonto() {
        steps.validarMontoPopup();
    }

    //@Cuando("finalizo la compra")
    //public void finalizarCompra() {
      //  steps.finalizarCompra();
    //}

    @Entonces("valido el titulo de la pagina del carrito")
    public void validarTituloCarritoCategoria() {
        steps.validarTituloCarrito();
    }

    @Entonces("vuelvo a validar el calculo de precios en el carrito")
    public void validarCalculosCarrito() {
        steps.validarCalculoCarrito();
    }

    @Entonces("valido que no existe la categoría")
    public void validarCategoriaInexistente() {
        steps.validarCategoriaInexistente();
    }
}
