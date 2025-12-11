package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By inputEmail = By.id("field-email");
    private By inputPassword = By.id("field-password");
    private By btnLogin = By.xpath("//button[@data-link-action='sign-in']");
    private By alertaError = By.xpath("//li[contains(text(),'Authentication failed')]");

    private By homeTitle = By.xpath("//h2[contains(text(),'Categorías') or contains(text(),'Categories')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void ingresarPassword(String pass) {
        driver.findElement(inputPassword).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    // Login correcto
    public boolean esLoginCorrecto() {
        try {
            return driver.findElement(homeTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Login incorrecto
    public boolean esLoginIncorrecto() {
        try {
            return driver.findElement(alertaError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
