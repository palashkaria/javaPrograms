package package1;
/**
 * 
 */

/**
 * An account that earns interest at a fixed rate.
 * @author Palash
 *
 */
public class SavingsAccount extends BankAccount {
	private static final long serialVersionUID=45L;
	private double interestRate, taxDeducted = 0;

	/**
	Constructs a bank account with a given interest rate.
	 @param rate the interest rate
	 */
	public SavingsAccount(double rate, double initialBalance, String name, String address)
	{
		super(initialBalance,name,address);
		interestRate = rate;
	}
	/**
	Adds the earned interest to the account balance, and deducted the tax based on that.
	*/
	public void addInterest()
	{
		double interest = getBalance() * interestRate / 100;
		double tax = calculateTax(interest);
		withdraw(tax);
		taxDeducted += tax;	
		deposit(interest);
	}

	public double getTaxDeducted()
	{
		return taxDeducted;
		
	}
	

}
