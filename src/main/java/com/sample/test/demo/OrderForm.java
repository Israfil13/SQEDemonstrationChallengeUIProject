package com.sample.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderForm extends TestBase {



    @FindBy(id = "pizza1Pizza")
    private WebElement pizza1;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
    private WebElement pizza1Toppings1;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings']")
    private WebElement pizza1Toppings2;

    @FindBy(id = "pizza1Qty")
    private WebElement pizza1Quantity;

    @FindBy(id = "pizza1Cost")
    private WebElement pizza1Cost;

    @FindBy(id = "ccpayment")
    private WebElement radioCreditCard;

    @FindBy(id = "cashpayment")
    private WebElement radioCash;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "placeOrder")
    private WebElement placeOrderButton;

    @FindBy(id = "reset")
    private WebElement resetButton;

    @FindBy(id = "dialog")
    private WebElement dialog;

    @FindBy(xpath = "//div[@id='dialog']/p")
    private WebElement dialogText;



    public OrderForm (){
        PageFactory.initElements(driver, this);
    }





    public void seelctPizza(String pizzaSize) {


        Select select = new Select(pizza1);
        select.selectByValue(pizzaSize);
    }

    public void seelectToppings1 (String topping1) {
        Select select = new Select(pizza1Toppings1);
        select.selectByValue(topping1);
    }

    public void seelectToppings2 (String topping2) {
        Select select = new Select(pizza1Toppings2);
        select.selectByValue(topping2);
    }

    public void enterQuantity (int quantity){

        pizza1Quantity.clear();
        pizza1Quantity.sendKeys(Integer.toString(quantity));
    }

    public void enterName (String name){

        pizza1Quantity.clear();
        pizza1Quantity.sendKeys(name);
    }

    public void enterEmail (String email){

        pizza1Quantity.clear();
        pizza1Quantity.sendKeys(email);
    }

    public void enterPhone (int phone){

        pizza1Quantity.clear();
        pizza1Quantity.sendKeys(Integer.toString(phone));
    }


    public void checkCreditCardButton (){
        radioCreditCard.click();
    }

    public void checkCashButton (){
        radioCash.click();
    }

    public void clickPlaceHolderButton (){
        placeOrderButton.click();
    }

    public String getConfirmationText(){
            String confirmationText = dialogText.getText();

            return confirmationText;
    }

}