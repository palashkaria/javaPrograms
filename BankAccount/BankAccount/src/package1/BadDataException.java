/**
 * 
 */
package package1;
import java.io.IOException;

/**
 * @author Palash
 *
 */
public class BadDataException extends IOException {
	private static final long serialVersionUID=2L;
	public BadDataException(){}
	public BadDataException(String message)
	{
		super(message);
	}
}