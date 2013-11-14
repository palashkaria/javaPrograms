/**
 * 
 */
package package1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author palash
 *
 */
public class BASetReader {
	
	private BufferedReader br;

	public BankAccount[] readFile(String filename)
	
		{
		BankAccount[] bAArray = new BankAccount[5];
		int i=0;
		String x = null;
		try{
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);	
		
			while((x=br.readLine())!=null)
			{
			
				String[] temp = x.split(",");
				bAArray[i] = new CheckingAccount(Double.parseDouble(temp[0]),temp[1],temp[2]);
				i++;
			}


		}
	
		catch(Exception e)
		{
			System.out.println(e);
		}
		return bAArray;
	}
}
