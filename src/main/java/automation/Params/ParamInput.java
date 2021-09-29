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
public class ParamInput {


    private String _TestName_;

    private String _TestDescription_;
    public String  printDescriptio(){
        return " Desc:"+_TestDescription_;
    }
    //1.	Navigate to http://automationpractice.com/
    private String navigateTo= "http://automationpractice.com/";

   //2.	Search for ‘Printed Summer Dress’
   private String searchFor;// ="Printed Summer Dress";

    private String URLToSearch;  //"search_query=Printed+Summer+Dress"
    private String URLToSearchAfterSort; //"orderby=price&orderway=asc"
    //3.	Select the cheapest dress
    private  String selectProduct="Price: Lowest first";

    public Product product;

    // 8.	Select “Proceed to Checkout”
    private String action="Proceed to Checkout"; //"Continue shopping"
    private ShoppingCartSummary shoppingCartSummary;

}
