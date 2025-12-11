package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By btnIniciarSesion = By.xpath("//a[contains(@href,'iniciar-sesion')]");

    private By tituloHome = By.xpath("//h1 | //h2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIniciarSesion() {
        driver.findElement(btnIniciarSesion).click();
    }

    public boolean estaEnHome() {
        try {
            return driver.findElement(tituloHome).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navegarCategoria(String categoria, String subcategoria) {
        try {
            // Clic en la categoría principal usando href parcial
            By categoriaXPath = By.xpath("//a[contains(@href,'/" + categoria.toLowerCase() + "')]");
            driver.findElement(categoriaXPath).click();

            // Pequeña espera para que se despliegue el menú
            Thread.sleep(500);

            // Clic en la subcategoría
            By subcategoriaXPath = By.xpath("//a[contains(@href,'/" + subcategoria.toLowerCase() + "')]");
            driver.findElement(subcategoriaXPath).click();

        } catch (Exception e) {
            throw new AssertionError("No se pudo navegar a la categoría: "
                    + categoria + " → " + subcategoria);
        }
    }

    public boolean esCategoriaInexistente() {
        try {
            driver.findElement(By.xpath("//h1"));
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
