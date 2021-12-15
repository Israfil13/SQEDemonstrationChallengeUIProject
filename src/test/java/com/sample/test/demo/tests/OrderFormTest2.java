package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderFormTest2 extends TestBase {


    private By pizza1 = By.id("pizza1Pizza");

    private By pizza1Toppings1 = By.xpath("//div[@id='pizza1']//select[@class='toppings1']");

    private By pizza1Toppings2 = By.xpath("//div[@id='pizza1']//select[@class='toppings2']");

    private By pizza1Quantity =  By.id("pizza1Qty");

    private By pizza1Cost =      By.id("pizza1Cost");

    private By radioCreditCard = By.id("ccpayment");

    private By radioCash = By.id("cashpayment");

    private By email = By.id("email");

    private By name = By.id("name");

    private By phone = By.id("phone");

    private By placeOrderButton = By.id("placeOrder");

    private By resetButton = By.id("reset");

    private By dialog = By.id("dialog");

    private By dialogText = By.xpath("//div[@id='dialog']/p");




    @Test
    public void verifyOrderWithCreditCardTest() throws InterruptedException {

            Select selectPizzaSize = new Select(driver.findElement(pizza1));
            selectPizzaSize.selectByValue("Medium 8 Slices - 2 toppings");

            Select selectTopping1 = new Select(driver.findElement(pizza1Toppings1));
            selectTopping1.selectByValue("Mushrooms");

            Select selectToppings2 = new Select(driver.findElement(pizza1Toppings2));
            selectToppings2.selectByValue("Olives");

            //Enter the pizza quantity
            driver.findElement(pizza1Quantity).clear();
            driver.findElement(pizza1Quantity).sendKeys(Integer.toString(1));

            //Enter name
            driver.findElement(name).clear();
            driver.findElement(name).sendKeys("Paolo Maldini");

            //Enter email
            driver.findElement(email).clear();
            driver.findElement(email).sendKeys("maldini@acmilan.com");

            //Enter phone number
            driver.findElement(phone).clear();
            driver.findElement(phone).sendKeys(Integer.toString(3333333));

            //Select payment option
            driver.findElement(radioCash).click();

            //Click to Place Holder button
            driver.findElement(placeOrderButton).click();


            // Get confirmation message
         String confirmationText = driver.findElement(dialogText).getText();

         Thread.sleep(5000);

        String expected = "Thank you for your order! TOTAL: 9.75 Medium 8 Slices - 2 toppings";
        String actual = confirmationText;

        Assert.assertEquals(actual,expected);

    }



    @Test
    public void verifyCannotOrderWithoutPickupInformationTest(){
        Select selectPizzaSize = new Select(driver.findElement(pizza1));
        selectPizzaSize.selectByValue("Medium 8 Slices - 2 toppings");

        Select selectTopping1 = new Select(driver.findElement(pizza1Toppings1));
        selectTopping1.selectByValue("Mushrooms");

        Select selectToppings2 = new Select(driver.findElement(pizza1Toppings2));
        selectToppings2.selectByValue("Olives");

        //Enter the pizza quantity
        driver.findElement(pizza1Quantity).clear();
        driver.findElement(pizza1Quantity).sendKeys(Integer.toString(1));


        //Select payment option
        driver.findElement(radioCash).click();

        //Click to Place Holder button
        driver.findElement(placeOrderButton).click();


        // Get confirmation message
        String confirmationText = driver.findElement(dialogText).getText();

        String expected = "Missing name\n" +
                          "Missing phone number";
        String actual = confirmationText;

        Assert.assertEquals(actual,expected);
    }

}
