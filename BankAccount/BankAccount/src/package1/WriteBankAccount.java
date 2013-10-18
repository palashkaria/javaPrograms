package package1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteBankAccount {
	
	public static void main(String[] args)
	{	
		int i=0;
		BASetReader reader = new BASetReader();		
		BankAccount[] bAArray = new BankAccount[4];
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
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
