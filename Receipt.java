import java.util.Scanner;

/**
 * Receipt.java  
 *
 * @author - Your Name
 *
 */ 
public class Receipt
{


    public static void main(String [] args) {
        int dogsOut = 0;
        int hamburger = 0;
        int drink = 0;
        int dandy = 0;

        double drinkPrice = 1.50;
        double dandyPrice = 1.25;
        double dogPrice = 2.75;
        double hamburgerPrice = 3.50;

        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("*   Kentucky Country Day Snack Bar   *");
        System.out.println("*                                    *");
        System.out.println("*     Drink ..........$1.50          *");                      
        System.out.println("*     Candy ..........$1.25          *");     
        System.out.println("*     Hot Dog ........$2.75          *");     
        System.out.println("*     Hamburger ......$3.50          *");     
        System.out.println("*                                    *");    
        System.out.println("**************************************");
        
        
        Scanner scan = new Scanner(System.in);
    
    // gathering order
        System.out.println("how many hotdog?");
        dogsOut = scan.nextInt();
        System.out.println("how many hamburg?");
        hamburger = scan.nextInt();
        System.out.println("a drink?");
        drink = scan.nextInt();
        System.out.println("any candy?");
        dandy = scan.nextInt();

        scan.close();


        dogPrice *= dogsOut;
        hamburgerPrice *= hamburger;
        drinkPrice *= drink;
        dandyPrice *= dandy;
        double Total = (hamburgerPrice + dogPrice + drinkPrice + dandyPrice);
        
        int OrderNum = (int) (Math.random()*101);

    // 
        System.out.println("                  #" + OrderNum);
        
        System.out.println(" QNT  ITEM                        AMT ");
        System.out.println("**************************************");
        if (hamburger >= 1) {
            System.out.println(hamburger + "   Hamburger                    $" + String.format("%.2f",hamburgerPrice));
        }
        if (dogsOut >= 1) {
            System.out.println(dogsOut + "   Hot Dog                      $" + String.format("%.2f",dogPrice));
        }
        if (drink >= 1) {
            System.out.println(drink + "   Drink                        $" + String.format("%.2f",drinkPrice));
        }
        if (dandy >= 1) {
            System.out.println(dandy + "   Candy                        $" + String.format("%.2f",dandyPrice));
        }
        
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("         Sub-Total:    $" + String.format("%.2f",Total));
        System.out.println("         Tax:           $" + String.format("%.2f", Total*0.06));
        System.out.printf("         Total:        $%.2f\n", (Total*0.06)+Total);

    //
        


    }

    
}


