//TestCoinSorter class - Assignment 1.
import java.util.*;

public class TestCoinSorter
{
	
	
	public static void main(String[] args)
	{
		//Creating a list of Integers to pass as a parameter in CoinSorter construction
		ArrayList<Integer> clist=new ArrayList<>();
		clist.add(200);
		clist.add(100);
		clist.add(50);
		clist.add(20);
		clist.add(10);
		
		//Initialising a CoinSorter object
		CoinSorter cs=new CoinSorter("Pound Sterling", 0, 10000, clist);
		
		//Creating a scanner object
		Scanner sc=new Scanner(System.in);
		
		//Declaring variables to be passed as arguments in the relevant methods
		int choiceMainMenu;
		int choiceSubMenu;
		String newCurrency;
		int newMinValue;
		int newMaxValue;
		int validatedValue;
		int validatedCoin;
		
		//Utilising the do..while loop to present the main menu
		do
		{
			System.out.println("***Coin Sorter - Main Menu***");
			System.out.println("");
			System.out.println("1 - Coin Calculator");
			System.out.println("");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("");
			System.out.println("3 - Print coin list");
			System.out.println("");
			System.out.println("4 - Set details");
			System.out.println("");
			System.out.println("5 - Display program configurations");
			System.out.println("");
			System.out.println("6 - Quit the program");
			
			choiceMainMenu=sc.nextInt();
			
			//Utilising the switch statement to navigate through the options
			switch(choiceMainMenu)
				{
					case (1): validatedValue=cs.validateTotalCoinValue();
							  validatedCoin=cs.validateExcludedCoin();
							  System.out.println(cs.coinCalculator(validatedValue,validatedCoin));
							  System.out.println("");
							  break;
					
					case (2): validatedValue=cs.validateTotalCoinValue();
					  		  validatedCoin=cs.validateExcludedCoin();
					  		  System.out.println(cs.multiCoinCalculator(validatedValue,validatedCoin));
					  		  System.out.println("");
					  		  break;
					  		  
					case (3): System.out.println(cs.printCoinList());
			  		  		  System.out.println("");
			  		  		  break;
			  		  		  
					case (4): //Utilising the do..while loop to present the sub-menu
							do {
							System.out.println("***Set Details Sub-Menu***");
							System.out.println("");
							System.out.println("1 - Set currency");
							System.out.println("");
							System.out.println("2 - Set minimum coin input value");
							System.out.println("");
							System.out.println("3 - Set maximum coin input value");
							System.out.println("");
							System.out.println("4 - Return to main menu");
							choiceSubMenu=sc.nextInt();
									
							//Utilising the switch statement to navigate through the options
							switch (choiceSubMenu)
									{
									case (1):System.out.print("Set a new currency: ");
											 sc.nextLine();
											 newCurrency=sc.nextLine();
											 cs.setCurrency(newCurrency);
											 break;
												
											 // Validating user input for new minimum value
									case (2):do
												{
												 System.out.print("Set a new minimum value for exchange: ");
												 while (!sc.hasNextInt())
												 {
													 System.out.print("This is an invalid value. "
													 		+ "Please enter a valid value: ");
													 sc.next();
												 }
												 newMinValue = sc.nextInt();
												}while (newMinValue <0);
												 cs.setMinCoinIn(newMinValue);
												
											 break;
											  
											// Validating user input for new maximum value
									case (3):do
												{
												 System.out.print("Set a new maximum value for exhange: ");
												 while (!sc.hasNextInt())
												 {
													 System.out.print("This is an invalid value. "
															 + "Please enter a valid value: ");
													 sc.next();
												 }
												 newMaxValue = sc.nextInt();
												}while (newMaxValue <0);
										 		 cs.setMaxCoinIn(newMaxValue);
										 
											 break;
											
									case (4):System.out.println("You will now be redirected to the main menu. ");
											 System.out.println("");
									 		 break;
									}
								  }	while (choiceSubMenu!=4);
										
									break;
			  		  		  
					case (5): System.out.println(cs.displayProgramConfigs());
	  		  		  		  System.out.println("");
	  		  		  		  break;
	  		  		  		  
					case (6): System.out.println("Thank you for using the Coin Sorter.");
	  		  		  		  System.out.println("");
	  		  		  		  break;
	  		  		  
	  		  		default: System.out.println("Choose an option: ");
	  		  				 choiceMainMenu=sc.nextInt();
				}
		} while(choiceMainMenu!=6);
		
		//Closing the scanner
		sc.close();
		}
	}

