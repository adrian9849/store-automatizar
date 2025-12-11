package org.example.steps;

import org.example.core.DriverManager;
import org.example.pages.*;
import org.junit.Assert;

public class StoreSteps {

    private LoginPage loginPage;
    private HomePage homePage;
    private CategoriaPage categoriaPage;
    private CarritoPage carritoPage;

    public StoreSteps() {
        // vacío
    }

    // Abrir tienda
    public void abrirTienda() {
        DriverManager.driver.get("https://qalab.bensg.com/store/pe/");

        // Inicializamos las Pages aquí
        homePage = new HomePage(DriverManager.driver);
        loginPage = new LoginPage(DriverManager.driver);
        categoriaPage = new CategoriaPage(DriverManager.driver);
        carritoPage = new CarritoPage(DriverManager.driver);
    }

    // LOGIN
    public void login(String usuario, String clave) {
        homePage.clickIniciarSesion();
        loginPage.ingresarEmail(usuario);
        loginPage.ingresarPassword(clave);
        loginPage.clickLogin();
    }

    public void validarLoginFallido() {
        Assert.assertTrue("El login debió fallar", loginPage.esLoginIncorrecto());
    }

    public void validarLoginExitoso() {
        Assert.assertTrue("El login debió ser correcto", homePage.estaEnHome());
    }

    // CATEGORÍAS
    public void irCategoria(String categoria, String subcategoria) {
        homePage.navegarCategoria(categoria, subcategoria);
    }

    public void validarCategoriaCorrecta() {
        Assert.assertTrue("La categoría debió existir", categoriaPage.estaEnCategoria());
    }

    public void validarCategoriaInexistente() {
        Assert.assertTrue("La categoría NO debió existir", homePage.esCategoriaInexistente());
    }

    // PRODUCTO
    public void agregarPrimerProducto(int cantidad) {
        categoriaPage.agregarProducto(cantidad);
    }

    public void validarPopupCorrecto() {
        Assert.assertTrue("No se mostró el popup correcto", categoriaPage.popupConfirmado());
    }

    public void validarMontoPopup() {
        Assert.assertTrue("Monto incorrecto", categoriaPage.montoCalculadoCorrecto());
    }

    public void finalizarCompra() {
        categoriaPage.irCarrito();
    }

    public void validarTituloCarrito() {
        Assert.assertTrue("Título incorrecto", carritoPage.tituloCorrecto());
    }

    public void validarCalculoCarrito() {
        Assert.assertTrue("Cálculo incorrecto", carritoPage.calculoCorrecto());
    }
}
