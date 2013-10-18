package package1;
/**
 * 
 */

/**
 * A fixed deposit account with no withdrawal and variable interest rates
 * @author Palash
 *
 */
public class FDAccount extends BankAccount {
	private static final long serialVersionUID=44L;
	private double interestRate, taxDeducted;
	private int investmentTime;
	private int depositCount=0;
	//Constructor
	/**
	 * Constructs a fixed deposit account
	 * @param termOfInvestment the time(in months) for which the amount is to be kept in
	 * @param initialBalance
	 * @param name
	 * @param address
	 */
	public FDAccount(int termOfInvestment, double initialBalance, String name, String address)
	{
		super(initialBalance,name,address);
		investmentTime = termOfInvestment;
		setInterestRate();
	}
	/**
	 * private method to initialize the interest rate based on investment time
	 */
	private void setInterestRate()
	{
		if(investmentTime<12)
		{
			interestRate=6;
		}
		if(investmentTime>12 && investmentTime<36)
		{
			interestRate=7;
		}
		if(investmentTime>36)
		{
			interestRate=8;
		}
		
	}
	/**
	 * returns the interest rate
	 * @return interestRate
	 */
	public double getInterestRate()
	{
		return interestRate;
	}
	/**
	 * a method to calculate interest
	 * @return interest
	 */
	public double calculateInterest()
	{
		double interest = getBalance()*interestRate/100;
		return interest;
	}
	/**
	 * overriding the withdraw method to not allow any withdrawal
	 */
	public boolean withdraw(double amount)
	{
		System.out.println("Withdrawal Not Allowed");
		return false;
	}
	/**
	 * overriding the deposit method to allow only one transaction
	 * @param amount the amount to be deposited
	 */
	public boolean deposit(double amount)
	{
		if(depositCount<1)
		{
			super.deposit(amount);
			depositCount++;
			return true;
		}
		else
		{
			System.out.println("Only one transaction allowed");
			return false;
		}
	
	}
	/**
	 * overriding the transfer method to allow only one transaction
	 * @param amount the amount to be deposited
	 */
	public void transfer(BankAccount b1, double amount)
	{
		System.out.println("Transfer(withdrawal) not allowed");
	}
	/**
	 * Adds the earned interest to the account balance, and deducted the tax based on that.
	 */
	public void addInterest()
	{
		double tax = calculateTax(calculateInterest());
		withdraw(tax);
		taxDeducted += tax;
		deposit(calculateInterest());
	}
	public double getTaxDeducted()
	{
		return taxDeducted;
		
	}
	
}
