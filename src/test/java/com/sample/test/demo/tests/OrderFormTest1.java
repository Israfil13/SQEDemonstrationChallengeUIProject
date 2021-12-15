package com.sample.test.demo.tests;

import com.sample.test.demo.OrderForm;
import com.sample.test.demo.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderFormTest1 extends TestBase {




    @Test
    public void verifyOrderWithCreditCardTest(){

        OrderForm orderForm = new OrderForm();

        orderForm.seelctPizza("Medium 8 Slices - 2 toppings");
        orderForm.seelectToppings1("Mushrooms");
        orderForm.seelectToppings2("Olives");
        orderForm.enterQuantity(1);
        orderForm.enterName("Paolo Maldini");
        orderForm.enterEmail("maldini@acmilan.com");
        orderForm.enterPhone(33333333);

        orderForm.checkCashButton();
        orderForm.clickPlaceHolderButton();

        String expected = "Thank you for your order! TOTAL: 9.75 Medium 8 Slices - 2 toppings";
        String actual = orderForm.getConfirmationText();

        Assert.assertEquals(actual,expected);

    }


    @Test
    public void verifyCannotOrderWithoutPickupInformationTest(){
        OrderForm orderForm = new OrderForm();

        orderForm.seelctPizza("Medium 8 Slices - 2 toppings");
        orderForm.seelectToppings1("Mushrooms");
        orderForm.seelectToppings2("Olives");
        orderForm.enterQuantity(1);

        orderForm.checkCashButton();
        orderForm.clickPlaceHolderButton();

        String expected = "Missing name\n" +
                          "Missing phone number";
        String actual = orderForm.getConfirmationText();

        Assert.assertEquals(actual,expected);
    }
}
