package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoPage {

    private WebDriver driver;

    private By titulo = By.xpath("//h1[contains(text(),'Carrito') or contains(text(),'Shopping cart')]");
    private By precio = By.cssSelector(".product-price");
    private By cantidad = By.cssSelector("input.js-cart-line-product-quantity");
    private By subtotal = By.cssSelector(".product-subtotal");

    public CarritoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean tituloCorrecto() {
        try {
            return driver.findElement(titulo).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean calculoCorrecto() {
        double p = Double.parseDouble(driver.findElement(precio).getText().replace("S/","").trim());
        int c = Integer.parseInt(driver.findElement(cantidad).getAttribute("value"));
        double total = Double.parseDouble(driver.findElement(subtotal).getText().replace("S/","").trim());
        return (p*c) == total;
    }
}
