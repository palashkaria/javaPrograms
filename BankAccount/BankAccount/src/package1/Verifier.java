package package1;

import java.io.Serializable;

public class Verifier implements Serializable {
	private static final long serialVersionUID=8L;
	private	static String password="abc123";
	private static int wrongTries;
	
	public Verifier(String pass)
	{
		password = pass;
		wrongTries=0;
	}
	public String getPassword()
	{
		return password;
	}
	public void accountLock()
	{
		System.out.println("Account is locked");
	}
	public void setWrongTries(int wrong)
	{
		wrongTries = wrong;
	}
	public int getWrongTries()
	{
		return wrongTries;
	}
}
