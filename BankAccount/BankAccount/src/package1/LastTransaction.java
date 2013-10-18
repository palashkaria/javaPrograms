package package1;

import java.io.Serializable;
/**
 * 
 */

/**
 * A class to display details of the last transaction.
 * @author Palash
 */
public class LastTransaction implements Serializable {
	private String lastTrans;
	private static final long serialVersionUID=98L;
	/**
	 * to set details of the last transaction and store them in LastTrans(string)
	 * @param transType the type(withdrawal, deposit, or transfer)
	 * @param amount the amount
	 */
	public void setLastTransaction(String transType, double amount)
	{
		lastTrans = transType +" : " + amount;
	}
	/**
	 * to return details of the last transaction
	 * @return lastTrans
	 */
	public String getLastTransaction()
	{
		return lastTrans;
	}
	
}

