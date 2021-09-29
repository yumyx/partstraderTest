package automation.Params;

/*
1.	Navigate to http://automationpractice.com/
2.	Search for ‘Printed Summer Dress’
3.	Select the cheapest dress
4.	Change the Quantity from 1 to 2
5.	Change the Size from S to M
6.	Change the colour from Yellow to Green
7.	Select “Add to cart”
8.	Select “Proceed to Checkout”
9.	Assert that the price equals $34.80
10.	Take a screenshot of the cart and attach it along with your code

 */
import lombok.Data;

@Data

public class Product {
    //4.	Change the Quantity from 1 to 2
    private int quantity=2;
    //Change the Size from S to M
    private  String size="M";
    //6.	Change the colour from Yellow to Green
    public String colour="Green";

    private String action="Add to cart";
}