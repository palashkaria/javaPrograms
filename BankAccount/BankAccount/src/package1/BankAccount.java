package package1;

import java.io.Serializable;

/**
 * 
 */

/**
 * A bank account has a balance that can
 * be changed by deposits and withdrawals and transfers.
 * It also has personal details like name, address.
 * @author Palash
 */
public abstract class BankAccount implements ITRules, Comparable<Object>, Serializable {
	//fields
	private static final long serialVersionUID=42L;
	private static double MIN_BALANCE=500;
	private double balance;
	public static long numOfAccounts = 180020131111L;
	private long accountNumber;
	private LastTransaction last = new LastTransaction();
	private PersonalDetails details;
	public Verifier myVerifier=new Verifier("abc123");
	
	
	//constructors
	/**
	 * Constructs a bank account with a given balance.
	 * @param initialBalance the initial balance
	 * @param name the name of the account holder
	 * @param address the address of the account holder
	 */
	public BankAccount(double initialBalance, String name, String address)
	{
		
		
		if(initialBalance >= MIN_BALANCE)
		{
			balance = initialBalance;
			details = new PersonalDetails(name, address);
			accountNumber=numOfAccounts++;
		}
		else
			System.out.println("Minimum balance is " + MIN_BALANCE);

	}
	
	//methods
	/**
	 * Deposits money from the bank account.
	 * @param amount the amount to deposit
	*/
	public boolean deposit(double amount)
	{
		if(amount > 0)
		{
			double newBalance = balance + amount;
			balance = newBalance;
			last.setLastTransaction("Deposit", amount);
			return true;
		}
		else
		{
			System.out.println("Negative, not allowed");
			return false;
		}
		
		
	}
	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	*/
	public boolean withdraw(double amount)
	{
		if(amount>balance)
			{
			System.out.println("You cannot withdraw more than your balance!");
			return false;
			}
		else
		{
			if(amount>0)
			{
				double newBalance = balance - amount;
				balance = newBalance;
				last.setLastTransaction("Withdrawal", amount);
				return true;
			}
		else
			System.out.println("Negative, not allowed");
			return false;
		}
	}
	/**
	 * transfers amount from current account to b1
	 * @param b1 the account where you want to transfer the money to
	 * @param amount the amount to be transferred
	 */
	public void transfer(BankAccount b1, double amount)
	{
		if(amount > 0)
		{
			if(amount<b1.balance){
				if(withdraw(amount));
					b1.deposit(amount);
				/*b1.last.setLastTransaction("Transfer(deposit)", amount);	
				last.setLastTransaction("Transfer(withdrawal)", amount);*/
			}
			else	
			{
				System.out.println("Not enough money");
			}
		}
		else
			System.out.println("Negative, not allowed");
		
	}
	/**
	 * Gets the current balance of the bank account
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * Gets the account number
	 * @return accountNumber
	 */
	public long getAccountNumber()
	{
		return accountNumber;
	}
	/**
	 * To calculate the tax rate.
	 * @return rate
	 */
	public double getTaxRate()
	{
		
		if(getBalance()>10000 && getBalance()<30000)
			return 3;
		else if(getBalance()>30000 && getBalance()<75000)
			return 4;
		else if(getBalance()>75000 && getBalance()<100000)
			return 8;
		else if(getBalance()>100000)
			return 10;
		
		return 0;
	}
	/**
	 * implements ITRules.calculateTax
	 * @param income - the balance
	 * @return tax the amount of tax.
	 */
	public double calculateTax(double interest)
	{
		double rate=getTaxRate();
		return interest*rate/100;
	}
	
	/**
	 * Implements Comparable.compareTo to compare two accounts on the basis of balance(a, b)
	 * @param otherObject to compare.
	 * @return int if a<b, -1. if a>b, 1. if a=b, 0.
	 */
	
	public int compareTo(Object otherObject)
	{
		BankAccount otherAccount = (BankAccount) otherObject;
		 if (getBalance() < otherAccount.getBalance())
			 return -1;
		 if (getBalance() > otherAccount.getBalance())
			 return 1;
		 return 0; 
	}
	public String getAddress()
	{
		return details.getAddress();
	}
	/**
	 * Returns all the data in form of a string
	 * @return s
	 */
	public String toString()
	{
		String s;
		s="Account number : " + accountNumber +", Balance : " + getBalance() +  ",  Name : " + details.getName() + ",  Address: " + details.getAddress() + ",  Last transaction - " + last.getLastTransaction();
		return s;
	}
}