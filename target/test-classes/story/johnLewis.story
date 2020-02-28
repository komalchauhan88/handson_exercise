Scenario: QE Framework Excercise

Given we navigate to following https://www.johnlewis.com/

When we search for following wallet

When we add the product to basket

When we continue to checkout

When we use following abc@abc.com to checkout as guest

When we select delivery as checkoutOption

When we add following delivery address:
| title  | firstName |  lastName | phoneNumber |  address  |    town   |   postCode    |
|  Mr    |   abc     |    abc    | 7440688987  |  289, HM  |    London |    EC4R1BR    |

When we choose nextOrNamedDayDelivery with days plus 2

When we click on continue to payment

Then we take a screenshot of the reviewPage

