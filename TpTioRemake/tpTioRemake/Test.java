package tpTioRemake;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Test {

	static Stack myStack = new Stack ();
	static Scanner in = new Scanner(System.in) ;
	String myStockName = null ;
	int numNeeded = 0 ;
	int menuSelection = 0 ;
	int myStockNum = 0 ;
	double myStockPrice = 0 ;
	Stock myStock = null ;

	public Test(){

		populateStack();

	}

	public void iniciarMenu(){

		while(menuSelection != 5){

			menuPrincipal();

			if(menuSelection ==1)
				agregarAccion();

			else if(menuSelection == 2)
				encontrarFifoLifo();

			else if(menuSelection ==3)
				imprimirAcciones();
			
			else if(menuSelection ==4)
				getPMP();

			else{
				System.out.println("Bye!");

			}
		}	

	}


	private void menuPrincipal(){

		System.out.println("Welcome to the Stock-Trading Menu!");
		System.out.println("Press 1 to enter a new stock");
		System.out.println("Press 2 to find the FIFO and LIFO price for a stock");
		System.out.println("Press 3 to display all stocks");
		System.out.println("Press 4 para obtener pmp");
		System.out.println("Press 5 to quit");

		menuSelection = inputGuard(1,4);

	}

	private void agregarAccion(){

		System.out.println("You have chosen to add new stock");
		myStockName = chooseStock();
		System.out.println("Stock selected was " + myStockName);
		System.out.println("Enter the number of stocks you want to add");
		myStockNum = inputInteger();
		System.out.println("Enter the individual price of the stocks you want to add");
		myStockPrice = inputDouble();
		myStack.push(new Stock(myStockName,myStockNum,myStockPrice) );
		System.out.println();

	}

	private void encontrarFifoLifo(){

		System.out.println("You have chosen to find the FIFO and LIFO price for a stock");
		myStockName = chooseStock();
		System.out.println("Stock selected was " + myStockName);
		System.out.println("Enter number of shares");
		numNeeded = inputInteger();
		doFIFOCost(numNeeded,myStockName);
		doLIFOCost(numNeeded,myStockName);
		System.out.println();

	}

	private void imprimirAcciones(){

		System.out.println("You have chosen to display all stocks");
		int size = myStack.size();
		System.out.println();
		System.out.printf("%-20s %-20s %-20s \n", "Stock Name" , "Number of Shares", "Purchase Price");
		System.out.println("--------------------------------------------------------");
		for (int i=0 ; i < size ; i++)
		{
			myStock = (Stock) myStack.get(i);
			System.out.printf("%-20s %-20d %-18.2f \n", myStock.getName(), myStock.getNumberShares(), myStock.getPrice());
		}
		System.out.println();


	}
	
	private void getPMP(){
		
		Stack<Stock> copiaStack = (Stack<Stock>) myStack.clone();
		Stock aux;
		int sumatoriaPrecioAccion = 0;
		int cantAcciones = 0;
		
		while(!copiaStack.isEmpty()){
			
			aux = copiaStack.pop();
			sumatoriaPrecioAccion += aux.getNumberShares() * aux.getPrice(); 
			cantAcciones += aux.getPrice();
				
		}
		
		System.out.println("Precio promedio ponderado de todas sus acciones " +
		 sumatoriaPrecioAccion/ cantAcciones + " $");
		
		
	}

	public static void main(String[] args) {


		Test test1 = new Test();
		
		test1.iniciarMenu();

	}

	public static void doFIFOCost(int numStocksNeeded, String StockName)
	{
		int i = 0 ;
		int numNeeded = numStocksNeeded ;
		String myStockName = StockName ;
		int numStocks = myStack.size();
		Stock myStock = null ;
		double myPrice ;
		int stocksAvail = 0 ;
		double stockValueSum = 0 ;
		int numStocksAdded = 0 ;
		double FIFOCost = 0 ;

		while (numNeeded !=0 & (i < numStocks))
		{
			myStock = (Stock) myStack.get(i) ;
			if (myStock.getName().equalsIgnoreCase(myStockName))//if1
			{
				stocksAvail = myStock.getNumberShares();
				myPrice = myStock.getPrice();
				if (stocksAvail >= numNeeded)//if2
				{
					stockValueSum += numNeeded*myPrice ;
					numStocksAdded += numNeeded ;
					numNeeded = 0 ;
				}//end if2
				else
				{
					stockValueSum += stocksAvail*myPrice ;
					numNeeded -= stocksAvail ;
					numStocksAdded += stocksAvail ;
				}
			}//end if1
			i++ ;		
		}//end of while
		FIFOCost = stockValueSum/(double) numStocksAdded ;

		if (numStocksAdded < numNeeded)
			System.out.printf("There were only %10d %12s stocks available. The FIFO cost is %10f",numStocksAdded,myStockName,FIFOCost);
		else
			System.out.printf("The FIFO cost of %10d %12s stocks is %10.2f ", numStocksAdded,myStockName,FIFOCost);
		System.out.println();
	}


	public static void doLIFOCost(int numStocksNeeded, String StockName)
	{

		int numStocks = myStack.size();
		int i = numStocks - 1 ;
		int numNeeded = numStocksNeeded ;
		String myStockName = StockName ;
		Stock myStock = null ;
		double myPrice ;
		int stocksAvail = 0 ;
		double stockValueSum = 0 ;
		int numStocksAdded = 0 ;
		double LIFOCost = 0 ;

		while (numNeeded !=0 & (i >= 0))
		{
			myStock = (Stock) myStack.get(i) ;
			if (myStock.getName().equalsIgnoreCase(myStockName))//if1
			{
				stocksAvail = myStock.getNumberShares();
				myPrice = myStock.getPrice();
				if (stocksAvail >= numNeeded)//if2
				{
					stockValueSum += numNeeded*myPrice ;
					numStocksAdded += numNeeded ;
					numNeeded = 0 ;
				}//end if2
				else
				{
					stockValueSum += stocksAvail*myPrice ;
					numNeeded -= stocksAvail ;
					numStocksAdded += stocksAvail ;
				}
			}//end if1
			i-- ;		
		}//end of while
		LIFOCost = stockValueSum/(double) numStocksAdded ;

		if (numStocksAdded < numNeeded)
			System.out.printf("There were only %10d %12s stocks available. The LIFO cost is %10f",numStocksAdded,myStockName,LIFOCost);
		else
			System.out.printf("The LIFO cost of %10d %12s stocks is %10.2f ", numStocksAdded,myStockName,LIFOCost);
		System.out.println();

	}

	public static void populateStack()
	{

		Stock Google1 = new Stock("Google", 20, 25);
		Stock Google2 = new Stock("Google", 10, 40);
		Stock Google3 = new Stock("Google", 15, 50);
		Stock Apple1 = new Stock("Apple", 40, 10);
		Stock Apple2 = new Stock("Apple", 30, 50);
		Stock IBM1 = new Stock("IBM", 36, 20);
		Stock IBM2 = new Stock("IBM", 30, 40);
		Stock Intel1 = new Stock("Intel", 26, 70);
		Stock Intel2 = new Stock("Intel", 38, 58);
		Stock Google4 = new Stock("Google", 30, 80);

		//Load myStack
		myStack.push(Google1);
		myStack.push(Google2);
		myStack.push(Google3);
		myStack.push(Apple1);
		myStack.push(Apple2);
		myStack.push(IBM1);
		myStack.push(IBM2);
		myStack.push(Intel1);
		myStack.push(Intel2);
		myStack.push(Google4);


	}

	public static String chooseStock()
	{
		int selection = 0 ;
		String stockName = null ;
		System.out.println("Press 1 to select Google stock");
		System.out.println("Press 2 to select Apple stock");
		System.out.println("Press 3 to select Facebook stock");
		System.out.println("Press 4 to select Intel stock");
		selection = inputGuard(1,4);

		switch (selection){
		case 1 : {
			stockName = "Google";
			break ;
		}
		case 2 : {
			stockName = "Apple";
			break;
		}
		case 3 : {
			stockName = "Facebook";
			break;
		}
		case 4 : {
			stockName = "Intel";
			break ;
		}
		}//end of switch
		return stockName ;
	}

	public static int inputGuard ( int lower, int upper)
	{
		int selection = 0 ;
		boolean notHappy = true ;
		int myLower = lower ;
		int myUpper = upper ;

		while (notHappy){
			if (!(in.hasNextInt())){
				JOptionPane.showMessageDialog(null, "You did not enter an integer");
				in.nextLine();
			}// end first if
			else {
				selection = in.nextInt();
				if (!(((selection<=myUpper)&(selection>=myLower)))) {
					JOptionPane.showMessageDialog(null, "The integer you entered is not from the menu");
					in.nextLine();
				}//end second if
				else {
					notHappy = false ;
					in.nextLine();
				}//end second else
			}//end first else
		}//end while
		notHappy = true ;

		return selection ;
	}

	public static int inputInteger()
	{
		int inputInt = 0 ;
		while (!(in.hasNextInt()))
		{
			JOptionPane.showMessageDialog(null, "You did not enter an integer");
			in.nextLine();
		}
		inputInt = in.nextInt();
		in.nextLine();
		return inputInt ;
	}

	public static double inputDouble()
	{
		double inputDouble = 0 ;
		while (!(in.hasNextDouble()))
		{
			JOptionPane.showMessageDialog(null, "You did not enter a double");
			in.nextLine();
		}
		inputDouble = in.nextInt();
		in.nextLine();
		return inputDouble ;
	}







}
