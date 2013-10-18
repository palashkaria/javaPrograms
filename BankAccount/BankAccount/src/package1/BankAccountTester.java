package package1;
/**
 * 
 */

/**
 * A class to test the BankAccount class
 * @author Palash
 */
public class BankAccountTester {

	/**
	 * Tests the methods of BankAccount class
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		FDAccount p = new FDAccount(13,6000,"p","g");
		
		p.withdraw(500);
		p.deposit(822); //this one is executed
		p.deposit(820);
		System.out.println(p.toString());
	}

}