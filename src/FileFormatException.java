/**
 * exception thrown when an error occurs in reading data from file
 */
public class FileFormatException extends Exception
{
    /**
     * thrown when reading data from file
     * @param errorMessage message contained in exception object
     */
    public FileFormatException(String errorMessage)
    {
        super(errorMessage);
    }
}
