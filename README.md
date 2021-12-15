## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases


1.	Verify ability not to order pizza with invalid topping data 
1.1	 User opens the link and navigates to “Pizza order from” page
1.2	 Selects pizza size as: "small 6-piece Slices - no toppings $6.75. "
1.3	 Selects Toppings 1 as: "Diced Mango" 
1.4	 Selects Toppings 2 as: "Olives"
1.5	Enters valid data in “Quantity Box”
1.6	Fills out “Pickup information” with valid data
1.7	Selects payment method in “Payment information” section
1.8	Clicks “Place Order” button
1.9	Verify that pop-up message regarding “invalid topping data” appears on the screen

Test case failed -----
---> Bug - User is able to order pizza with topping when he selects slice with NO TOPPING.
Steps to reproduce:
1.	User navigates to link “Pizza Order Form’ page 
2.	User selects pizza size as "small 6-piece Slices - no toppings $6.75. "
3.	User selects Toppings 1 as: Diced Mango" 
4.	User Selects Toppings 2 as: "Olives"
5.	User Enters valid data in “Quantity Box”
6.	User fills out “Pickup information” with valid data
7.	User selects payment method in “Payment information” section
8.	User clicks “Place Order” button
Expected result: pop-up message regarding “invalid topping data” should appear on the screen because pizza size was selected with no toppings. 
Actual result: User is able to order pizza with topping. 


2.	Verify ability to order pizza with valid amount
2.1	User opens the link and navigates to “Pizza order from” page
2.2	User selects valid pizza size
2.3	User selects valid Topping 1 and Topping 2
2.4	And enters “1” in Quantity Box
2.5	Verify that pop-up message regarding successful order confirmation with entered amount appears on the screen
Test case passed 


3.	Verify ability not to order pizza with invalid amount
3.1	User opens the link and navigates to “Pizza order from” page
3.2	User selects valid pizza size
3.3	And selects valid Topping 1 and Topping 
3.4	And enters “-1” in Quantity Box
3.5	Verify that  “Invalid quantity” pop-up message appears on the screen
--Test case failed-- 
--> Bug – User is able to order pizza with invalid amount ( -1 )

4.	Verify ability not to order pizza with empty “Pickup Information”
4.1	User opens the link and navigates to “Pizza order from” page
4.2	User selects valid pizza size
4.3	Selects valid Topping 1 and Topping 2
4.4	Enters valid data in “Quantity Box”
4.5	User selects “Payment Information” 
4.6	User does not fill out “Pickup Information” box and clicks “Place order” button
4.7	Verify that pop-up message regarding “Missing pickup information” appears on the screen 
Test case passed 

5.	Verify ability not to order with invalid phone number
5.1	 User opens the link and navigates to “Pizza order from” page
5.2	 User selects valid pizza size
5.3	AND selects Topping 1 and Topping 2
5.4	AND enters valid data in “Quantity Box”
5.5	AND fills out “Pickup information” with invalid phone number
5.6	AND selects payment method in “Payment information” section
5.7	AND clicks “Place order” button
5.8	Verify pop-up message regarding “Invalid phone number” appears on the screen
--Test case failed-- 
-->BUG – User is able to order pizza with “Invalid” phone number

6.	Verify ability not to order with 2 payment methods
6.1	User opens the link and navigates to “Pizza order from” page
6.2	User selects valid pizza size
6.3	AND selects valid Topping 1 and Topping 2
6.4	AND enters valid data in “Quantity Box”
6.5	AND fills out “Pickup information”
6.6	Verify that user is not able to select both payment methods in “Payment information” section
--Test case failed-- 
--> Bug – User is able to select both payment methods in “Payment information” section

7.	Verify Ability not to order without selecting any “Payment method” in Payment information section
7.1.	User opens the link and navigates to “Pizza order from” page
7.2.	User selects valid pizza size
7.3.	AND selects valid Topping 1 and Topping 2
7.4.	AND enters valid data in “Quantity Box”
7.5.	AND user does not select “Payment Information” 
7.6.	AND user fills out “Pickup Information” box and clicks “Place order” button
7.7.	Verify that pop-up message regarding “Missing Payment Method” appears on the screen 
--Test case failed--
-->Bug-User is able to order pizza without selecting Payment method.

8.	Verify ability to clear information with “Reset” button
8.1.	User opens the link and navigates to “Pizza order from” page
8.2.	User selects valid pizza size
8.3.	AND selects valid Topping 1 and Topping 2
8.4.	AND enters valid data in “Quantity Box”
8.5.	AND fills out “Pickup information”
8.6.	AND selects “Payment information” 
8.7.	AND clicks “RESET” button
8.8.	Verify that all form elements should be cleared and reset to their default amount. 
--Test case failed-- 
--> Bug – Topping 1 and Topping 2 section data is not cleared 

9.	Verify ability to order pizza by “cash on pickup”
9.1	User opens the link and Navigates to "Pizza order form" page 
9.2	user Selects valid pizza size
9.3	AND selects valid Toppings 1 and Topping 2
9.4	AND enters valid amount in Quantity box 
9.5	AND fills out "Pickup Information" section 
9.6	AND Selects payment information as Cash on Pickup
9.7	AND clicks "Place Order" button 
9.8	Verify that confirmation as pop-up message appears on the screen
Test case passed 

10.	Verify ability to fill out Credit Card information when user selects “Credit Card” payment method 
10.1.	User opens the link and Navigates to "Pizza order form" page 
10.2.	 user Selects pizza size
10.3.	AND selects valid Toppings 1 and Topping 2
10.4.	AND enters valid amount in Quantity box 
10.5.	AND fills out "Pickup Information" section 
10.6.	AND Selects payment information as Credit Card
10.7.	Then verify that form for filling out “Credit Card” data opens on the screen
--Test case failed --
--> Bug – Form for filling out credit card data is not appeared on the screen and User is able place order without filling out any Credit Card data when he selects “Credit Card” as payment method 





