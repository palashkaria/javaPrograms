/**
 * 
 */
package package1;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A class to write all addresses of all bank accounts into a file called addressFile
 * @author Palash
 *
 */
public class WriteAddresses {
	public static void main(String[] args)
	{	
		//create the array from binary file
		BankAccount[] bAArray = new BankAccount[4];
		BAFileReader BAf = new BAFileReader();
		bAArray = BAf.readIntoObject("bankAccountFile.bin");
		int i=0;
		
		//write the addresses from FDArray to addressFile
		try{
			FileWriter fw = new FileWriter("addressFile.txt");
			for(i=0;i<4;i++)
				{
				fw.write(bAArray[i].getAddress() + "\n");
				
				}
			fw.close();
			System.out.println("done");
		}
		catch (IOException e) {
		      System.out.println("Exception: " + e);
		    }
		
	}

}
