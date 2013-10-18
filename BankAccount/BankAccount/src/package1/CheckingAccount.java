package package1;
/**
 * 
 */

/**
 * An account that charges transaction fees
 * @author Palash
 *
 */
public class CheckingAccount extends BankAccount {
	private static final long serialVersionUID=43L;
	private static final int FREE_TRANS = 5;
	private static final double TRANS_FEE = 2.0;
	private int transCount;
	
	/**
	 * Create a checking account
	 * @param initialBalance
	 * @param name
	 * @param address
	 */
	CheckingAccount(double initialBalance, String name, String address )
	{
		super(initialBalance, name, address);
		transCount = 0;
	}
	
	//methods
	/**
	 * overriding deposit to increase transCount
	 */
	public boolean deposit(double amount)
	{
		transCount++;
		super.deposit(amount);
		return true;
	}
	/**
	 * overriding withdraw to increase transCount
	 */
	public boolean withdraw(double amount)
	{
		transCount++;
		if(super.withdraw(amount))
			return true;
		else
			return false;
	}
	/**
	 * overriding transfer to increase transCount
	 */
	public void transfer(BankAccount b1, double amount)
	{
		transCount++;
		super.transfer(b1,amount);
	}
	/**
	 * to deduct transaction fees.
	 */
	public void deductFees()
	{
		if (transCount > FREE_TRANS)
		{
			double fees = TRANS_FEE * (transCount-FREE_TRANS);
			super.withdraw(fees);
		}
		transCount = 0;
	}

}
