package package1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteBankAccount {
	
	public static void main(String[] args)
	{	
		int i=0;
		BASetReader reader = new BASetReader();		
		BankAccount[] bAArray = new BankAccount[5];
		bAArray = reader.readFile("bankAccountDetailsFile.txt");
		
		
		try{
			
			FileOutputStream fout = new FileOutputStream("bankAccountFile.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			for(i=0;i<bAArray.length;i++)
			{

				oos.writeObject(bAArray[i]);
			}
			oos.close();
			System.out.println("Done");
		}
		catch(IOError e)
		
		{
		e.printStackTrace();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
