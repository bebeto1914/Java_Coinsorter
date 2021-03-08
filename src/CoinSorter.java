//CoinSorter class - Assignment 1.

import java.util.*;

public class CoinSorter {

	// Attributes of CoinSorter class
	private String currency;
	private int minCoinIn;
	private int maxCoinIn;
	private int totalCoinValue;
	private int excludedCoin;
	private ArrayList<Integer> coinList;
	
	// Methods of CoinSorter class
	
	//Constructor method
	public CoinSorter(String currencyIn, int minIn, int maxIn, ArrayList<Integer> listIn)
	{
		currency=currencyIn;
		minCoinIn=minIn;
		maxCoinIn=maxIn;
		coinList=listIn;
		
	}
	
	//Set methods
	
	public void setCurrency(String currencyIn)
	{
		currency=currencyIn;
	}
	
	public void setMinCoinIn(int minIn)
	{
		minCoinIn=minIn;
	}
	
	public void setMaxCoinIn(int maxIn)
	{
		maxCoinIn=maxIn;
	}
	
	//Get methods
	
	public String getCurrency()
	{
		return currency;
	}
	
	public int getMinCoinIn()
	{
		return minCoinIn;
	}
	
	public int getMaxCoinIn()
	{
		return maxCoinIn;
	}
	
	// A method that prints out the list of coins
	public String printCoinList()
	{
		System.out.print("The current coin denominations are in circulation: ");
		
		// Could implement a for loop instead of adding the list in return
		
		//for (int i=0; i<coinList.size(); i++)
		//{
			//System.out.print(", "+coinList.get(i));
		//}
		
		return Integer.toString(coinList.get(0))+", "+Integer.toString(coinList.get(1))+
				", "+Integer.toString(coinList.get(2))+", "+Integer.toString(coinList.get(3))
				+", "+Integer.toString(coinList.get(4))+".";
	}
	
	// Method to validate the user input for total value
	// Differentiated from the UML specification
	public int validateTotalCoinValue()
	{
		int validatedValue;
		
		// Ensuring that the input is an integer within the range
		Scanner sc=new Scanner(System.in);
		do
			{
			System.out.print("Enter the desired amount in pennies within the set range: ");
			while (!sc.hasNextInt())
				{
				System.out.print("This is an invalid value. Please enter a valid value: ");
				sc.next();
				}
			validatedValue=sc.nextInt();
			}while (validatedValue<minCoinIn || validatedValue>maxCoinIn);
		
		return validatedValue;
	}
	
	// Method to validate the user input for coin type
	// Differentiated from the UML specification
	public int validateExcludedCoin()
			{		
			int validatedCoin;
			
			// Ensuring that the input is an integer within the range
			Scanner sc=new Scanner(System.in);
			do
				{
				System.out.print("Enter a valid coin type: ");
				while (!sc.hasNextInt())
					{
					System.out.print("This is not a coin type. Please enter a valid coin type: ");
					sc.next();
					}
				validatedCoin=sc.nextInt();
				}while ((validatedCoin!=200)&&(validatedCoin!=100)&&(validatedCoin!=50)
						&&(validatedCoin!=20)&&(validatedCoin!=10));
			
			return validatedCoin;
		}
	
	// A method that calculates the maximum number of coins of the input coin type according to user input value
	
	public String coinCalculator(int valueIn, int coinTypeIn)
	{
		//Passing the validated values as parameters
		
		totalCoinValue=valueIn;
		excludedCoin=coinTypeIn;
		
		int totalCoins=valueIn/coinTypeIn;
		int remainder= valueIn-(totalCoins*coinTypeIn);
		return "A total of "+totalCoins+" x "+coinTypeIn+"p coins can be exchanged, with a remainder of "+remainder+"p.";
	}
	
	// A method that excludes a coin and calculates the maximum number of the rest of the coins 
	//according to user input value
	
	public String multiCoinCalculator(int valueIn, int coinTypeIn)
	{
		//Passing the validated values as parameters
		
		totalCoinValue=valueIn;
		excludedCoin=coinTypeIn;
		
		//Declaring local variables
		int a;
		int b;
		int c;
		int d;
		int e;
		int remainder;
		
		//Implementing if and else if statements to perform the desired calculation
		
		if (excludedCoin==coinList.get(0))
		{
			a=0;
			b=valueIn/coinList.get(1);
			remainder=valueIn-(b*coinList.get(1));
			c=remainder/coinList.get(2);
			remainder=remainder-(c*coinList.get(2));
			d=remainder/coinList.get(3);
			remainder=remainder-(d*coinList.get(3));
			e=remainder/coinList.get(4);
			remainder=remainder-(e*coinList.get(4));
			
			
		}
		else if (excludedCoin==coinList.get(1))
		{
			a=valueIn/coinList.get(0);
			remainder=valueIn-(a*coinList.get(0));
			b=0;
			c=remainder/coinList.get(2);
			remainder=remainder-(c*coinList.get(2));
			d=remainder/coinList.get(3);
			remainder=remainder-(d*coinList.get(3));
			e=remainder/coinList.get(4);
			remainder=remainder-(e*coinList.get(4));
					
		}
		else if (excludedCoin==coinList.get(2))
		{
			a=valueIn/coinList.get(0);
			remainder=valueIn-(a*coinList.get(0));
			b=remainder/coinList.get(1);
			remainder=remainder-(b*coinList.get(1));
			c=0;
			d=remainder/coinList.get(3);
			remainder=remainder-(d*coinList.get(3));
			e=remainder/coinList.get(4);
			remainder=remainder-(e*coinList.get(4));
		}
		else if (excludedCoin==coinList.get(3))
		{
			a=valueIn/coinList.get(0);
			remainder=valueIn-(a*coinList.get(0));
			b=remainder/coinList.get(1);
			remainder=remainder-(b*coinList.get(1));
			c=remainder/coinList.get(2);
			remainder=remainder-(c*coinList.get(2));
			d=0;
			e=remainder/coinList.get(4);
			remainder=remainder-(e*coinList.get(4));
		}
		else
		{
			a=valueIn/coinList.get(0);
			remainder=valueIn-(a*coinList.get(0));
			b=remainder/coinList.get(1);
			remainder=remainder-(b*coinList.get(1));
			c=remainder/coinList.get(2);
			remainder=remainder-(c*coinList.get(2));
			d=remainder/coinList.get(3);
			remainder=remainder-(d*coinList.get(3));
			e=0;
	
		}
		return "The coins exchanged are: "+Integer.toString(a)+" x "+Integer.toString(coinList.get(0))+"p, "
		   +Integer.toString(b)+" x "+coinList.get(1)+"p, "+Integer.toString(c)+" x "+coinList.get(2)+"p, "
		   +Integer.toString(d)+" x "+coinList.get(3)+"p, "+Integer.toString(e)+" x "+coinList.get(4)+"p, "
		   		+ "with a remainder of "+ Integer.toString(remainder)+"p.";
	}
	
	//Method that displays Program Configurations
	public String displayProgramConfigs()
	{
		return "The current currency is "+currency+", the current minimum value accepted as input is "
				+Integer.toString(minCoinIn)+" and the current maximum value accepted as input is "
				+Integer.toString(maxCoinIn)+".";
	}
}
