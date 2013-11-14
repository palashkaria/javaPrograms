package package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class DuplicateMap {


	public static void findDuplicates(){
		Set<String> accountSet = new HashSet<String>();	
		BankAccount[] bAArray = new BankAccount[5];
		BAFileReader reader = new BAFileReader();
		bAArray = reader.readIntoObject("bankAccountFile.bin");
		
		Map<String,List<Long>> duplicateMap = new HashMap<String, List<Long>>();

		for(int i=0;i<bAArray.length;i++){
			
			if(accountSet.add(bAArray[i].getAddress()))
					{
						List <Long> accNoList = new ArrayList<Long>();
						accNoList.add(bAArray[i].getAccountNumber());
						duplicateMap.put(bAArray[i].getAddress(), accNoList);
					}
			else{
				  for (Entry<String, List<Long>> entry : duplicateMap.entrySet()) {
					 
				     if(entry.getKey().equals(bAArray[i].getAddress())){
				    	
					  entry.getValue().add(bAArray[i].getAccountNumber());
				     }
				   }
					
					
				}
				//duplicateMap.put(bAArray[i].getAddress(), accNoList);
			}
			
		
		  for (Entry<String, List<Long>> entry : duplicateMap.entrySet()) {
		        System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		   }
		  System.out.println("_____________________________");
		  
		  
		/*(for(int i=0;i<5;i++){
			
			if(duplicateMap.containsKey(bAArray[i].getAddress())){
				if(duplicateMap.containsValue(bAArray[i].getAccountNumber()))
				{
					System.out.println("same");
					continue;
				}
				else{
					System.out.println("adding");
					
					duplicateMap.put(bAArray[i].getAddress(),bAArray[i].getAccountNumber());
				}
				
			}*/
		//}
		  /*for (Entry<String, List<Long>> entry : duplicateMap.entrySet()) {
		        System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		   }
		  System.out.println(accountSet);*/   
	}
		
		
	
	public static void main(String[] args){
    findDuplicates();
}
}


