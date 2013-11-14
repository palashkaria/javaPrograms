package package1;

import java.io.Serializable;

public class ATMManager implements Serializable {

	private static final long serialVersionUID=99L;
	//public static void main(String[] args)
	//{

	public static BankAccount accountLogin(long accountNo, String password )
	{
		
		int i=0,j=0;
		//BAFileReader reader = new BAFileReader();
		BankAccount[] bAArray = new BankAccount[5];
	    
	
	    
	    
		 
	    
	     // bAArray = reader.readIntoObject("bankAccountFile.bin");
		 bAArray[0] = new CheckingAccount(5000.00,"Palash","Goa"); 
		   bAArray[1] = new CheckingAccount(1000.00,"Dilip","Banglore");
		   bAArray[2] = new CheckingAccount(1000.00,"Srimukh","Africa");
		   bAArray[3] = new CheckingAccount(50000.00,"Dad","Indore");
				
		//String password, accNo;
		//accNo=args[0];
		//password=args[1];
		//long accountNo=Long.parseLong(accNo);
		   for(i=0;i<3;i++)
		{
			
			if(bAArray[i].getAccountNumber()==accountNo)
			{
	
				if(password.equals(bAArray[i].myVerifier.getPassword()))
				{
					System.out.println("Verification Successful");
					bAArray[i].myVerifier.setWrongTries(0);
					return bAArray[i];
				//	System.exit(0);
				}
				else
					{
					j++;
					bAArray[i].myVerifier.setWrongTries(j);
					System.out.println("Wrong");
					return null;
				//	System.exit(0);
					}
			}
			else
				{
				
				continue;
				}
				
		}
		System.out.println("Account not found");
		return null;
	}
}
