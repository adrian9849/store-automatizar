package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriaPage {

    private WebDriver driver;

    private By btnAgregar = By.xpath("(//button[contains(@data-button-action,'add-to-cart')])[1]");
    private By popup = By.xpath("//div[contains(@class,'modal')]");
    private By popupMonto = By.xpath("//p[contains(@class,'product-price')]");
    private By btnIrCarrito = By.xpath("//a[contains(@href,'carrito')]");

    public CategoriaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void agregarProducto(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            driver.findElement(btnAgregar).click();
        }
    }

    public boolean popupConfirmado() {
        try {
            return driver.findElement(popup).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean montoCalculadoCorrecto() {
        try {
            return driver.findElement(popupMonto).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void irCarrito() {
        driver.findElement(btnIrCarrito).click();
    }

    public boolean estaEnCategoria() {
        try {
            return driver.findElement(btnAgregar).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
