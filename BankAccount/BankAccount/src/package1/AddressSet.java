package package1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class AddressSet {
	private static BufferedReader br;

	public static void main(String[] args){
    Set<String> accountSet = new HashSet<String>();	
		String x = null;
		try{
			FileReader fr = new FileReader("addressFile.txt");
			br = new BufferedReader(fr);	
			while((x=br.readLine())!=null)
			{
				System.out.println(x);
				accountSet.add(x);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	System.out.println(accountSet);
}
}

