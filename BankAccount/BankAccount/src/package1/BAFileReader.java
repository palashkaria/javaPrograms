/**
 * 
 */
package package1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author palash
 *
 */
public class BAFileReader {
	private BankAccount[] bAArray = new BankAccount[4];
	private int i;
	public BankAccount[] readIntoObject(String filename)
	{
		try{
			 FileInputStream fin = new FileInputStream(filename);
	            ObjectInputStream oin = new ObjectInputStream(fin);
	            for(i=0;i<bAArray.length;i++)
	            {
	              	bAArray[i]=(BankAccount) oin.readObject();
	            }
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return bAArray;
	}

}
