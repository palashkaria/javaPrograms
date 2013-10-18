package package1;
import java.io.*;
import java.util.Scanner;


public class BankAccountSetTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      //BASetReader reader = new BASetReader();
      FDAccount[] temp = new FDAccount[4];
      int i=0;
      boolean done = false;
      while (!done) 
      {
         try 
         {
            System.out.println("Please enter the file name: ");
            String filename = in.next();
            
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oin = new ObjectInputStream(fin);
            for(i=0;i<temp.length;i++)
            {
              	temp[i]=(FDAccount) oin.readObject();
            }
            for(i=0;i<temp.length;i++)
            {
              	System.out.println(temp[i].toString());
            }
            done = true;     
         }
        
         catch (ClassNotFoundException exception)
         {
        	 System.out.println("Class not found.");
         }
         catch (FileNotFoundException exception)
         {
            System.out.println("File not found.");
         }
         catch (BadDataException exception)
         {
            System.out.println("Bad data: " + exception.getMessage());
         }
         catch (IOException exception)
         {
            exception.printStackTrace();
         }
      }
     
   }
}
