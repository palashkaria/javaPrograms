/**
 * 
 */
package package1;

import java.util.*;

/**
 * @author Palash
 *
 */
public class BankAccountArrayList {

	private static BAFileReader reader = new BAFileReader();
	public static void makeArray(){
		BankAccount bAArray[] = new BankAccount[5];
		List<BankAccount> bigAccountsList = new ArrayList<BankAccount>();
		bAArray = reader.readIntoObject("bankAccountFile.bin");
		for(int i=0;i<bAArray.length;i++){
		if(bAArray[i].getBalance()>100000);
		{
			bigAccountsList.add(bAArray[i]);
		}
		}
		for(BankAccount b : bigAccountsList){
			System.out.println(b.toString());			
		}
		
	}
	public static void main(String[] args){
		makeArray();
	}
}
