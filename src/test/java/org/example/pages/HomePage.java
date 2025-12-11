package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By btnIniciarSesion = By.xpath("//a[contains(@href,'iniciar-sesion')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIniciarSesion() {
        driver.findElement(btnIniciarSesion).click();
    }

    public boolean estaEnHome() {
        try {
            return driver.findElement(By.xpath("//h2[contains(text(),'Categorías')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navegarCategoria(String categoria, String subcategoria) {
        try {
            driver.findElement(By.linkText(categoria)).click();
            driver.findElement(By.linkText(subcategoria)).click();
        } catch (Exception e) {
            throw new AssertionError("Categoría o subcategoría inexistente");
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
