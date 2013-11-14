package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ATMManagerCollections implements Serializable {

	private static final long serialVersionUID=99L;
	//public static void main(String[] args)
	//{
	private static BufferedReader br;
	
	public static BankAccount accountLogin(long accountNo, String password )
	{
		
		int i=0,j=0;
		//BAFileReader reader = new BAFileReader();
		//BankAccount[] bAArray = new BankAccount[4];
	
	    Map<Long,BankAccount> accountMap = new TreeMap<Long, BankAccount>();
	   
		String x = null;
		try{
			FileReader fr = new FileReader("bankAccountDetailsFile.txt");
			br = new BufferedReader(fr);	
		
			while((x=br.readLine())!=null)
			{
			
				String[] temp = x.split(",");
				BankAccount b = new  CheckingAccount(Double.parseDouble(temp[0]),temp[1],temp[2]);
				accountMap.put(b.getAccountNumber(),b);
				i++;
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	    
	    
	    for (Entry<Long, BankAccount> entry : accountMap.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
	   }
	    
	    
		 
		   for(Entry<Long, BankAccount> entry : accountMap.entrySet())
		{
			long accNo = entry.getKey();
			BankAccount account = entry.getValue();
			if(accNo==accountNo)
			{
	
				if(password.equals(account.myVerifier.getPassword()))
				{
					System.out.println("Verification Successful");
					account.myVerifier.setWrongTries(0);
					return account;
				//	System.exit(0);
				}
				else
					{
					j++;
					account.myVerifier.setWrongTries(j);
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
	public class BalanceCompare implements Comparator<Long> {
		Map<Long , BankAccount> map2;
		public void ValueComparator(Map<Long , BankAccount> map1){
			map2 = map1;
		}
		@Override
		public int compare(Long l1, Long l2){
			//map2.get(BankAccount)
			return 0;
			
		}
	}
	public static void main(String[] args){
		accountLogin(180020131111L, "abc123");
	}
}
