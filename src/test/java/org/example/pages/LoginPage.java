package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By inputEmail = By.id("field-email");
    private By inputPassword = By.id("field-password");
    private By btnLogin = By.id("submit-login");

    // Mensaje de error cuando login falla
    private By alertaError = By.xpath("//li[contains(text(),'Authentication failed')]");

    // Cuando login es correcto, aparece la sección "Categorías"
    private By homeTitle = By.xpath("//h2[contains(text(),'Categorías') or contains(text(),'Categories')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarEmail(String email) {
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void ingresarPassword(String pass) {
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    public boolean esLoginCorrecto() {
        try {
            return driver.findElement(homeTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean esLoginIncorrecto() {
        try {
            return driver.findElement(alertaError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
