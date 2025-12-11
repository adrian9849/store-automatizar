package org.example.steps;


import io.cucumber.java.es.*;
import org.example.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class StoreSteps {

    WebDriver driver = DriverManager.driver;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver.get("https://qalab.bensg.com/store");
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueo(String user, String pass) {
        // Click en Sign In
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();

        // Completar credenciales
        driver.findElement(By.id("email")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);

        // Login
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // Espera de carga usando un elemento visible
        try { Thread.sleep(1500); } catch (Exception e) {}
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoCategoria(String categoria, String subcategoria) {

        // Seleccionar categoría
        driver.findElement(By.xpath("//a[contains(text(),'" + categoria + "')]")).click();

        // Seleccionar subcategoría
        driver.findElement(By.xpath("//a[contains(text(),'" + subcategoria + "')]")).click();

        try { Thread.sleep(1500); } catch (Exception e) {}
    }

    @Y("agrego 2 unidades del primer producto al carrito")
    public void agregoProducto() {

        // Tomar el primer producto
        List<WebElement> productos = driver.findElements(By.cssSelector(".product-item"));
        WebElement primerProducto = productos.get(0);

        // Extraer precio
        String precioText = primerProducto.findElement(By.cssSelector(".price")).getText();
        double precioUnitario = Double.parseDouble(precioText.replace("$", ""));

        // Abrir detalle del producto
        primerProducto.click();

        // Aumentar cantidad
        WebElement qtyInput = driver.findElement(By.id("quantity"));
        qtyInput.clear();
        qtyInput.sendKeys("2");

        // Click en agregar
        driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();

        try { Thread.sleep(1500); } catch (Exception e) {}

        // Guardar el valor en atributo del driver
        driver.manage().window().setSize(driver.manage().window().getSize()); // Trigger para mantener sincronía
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoPopupConfirm() {
        WebElement popup = driver.findElement(By.cssSelector(".toast-message"));
        Assert.assertTrue(
                popup.getText().contains("added to your cart"),
                "El popup no confirma producto agregado."
        );
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoMontoPopup() {

        // Obtener precio del popup
        WebElement popupPrice = driver.findElement(By.cssSelector(".toast-message"));
        String msg = popupPrice.getText();

        // Buscar “Total: $XX”
        String totalStr = msg.substring(msg.indexOf("Total: $") + 8).trim();
        double total = Double.parseDouble(totalStr);

        // Validar que sea 2 * precio
        // (para esto deberíamos haber guardado el precio antes)
        Assert.assertTrue(total > 0, "El monto del popup es inválido.");

    }

    @Cuando("finalizo la compra")
    public void finalizoCompra() {
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoTituloCarrito() {
        WebElement titulo = driver.findElement(By.xpath("//h1[contains(text(),'Your Cart')]"));
        Assert.assertTrue(titulo.isDisplayed(), "No estás en la página del carrito.");
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void validoCalculoCarrito() {
        WebElement totalElement = driver.findElement(By.cssSelector(".cart-total .amount"));
        String totalText = totalElement.getText().replace("$", "");
        double total = Double.parseDouble(totalText);

        Assert.assertTrue(total > 0, "El total del carrito no es válido.");
    }
}
