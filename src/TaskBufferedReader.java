import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read file by using BufferedReader, read 1-line at a time.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class TaskBufferedReader implements Runnable{
    public final String ALICE_PATH = "src/Alice-in-Wonderland.txt";

    /**
     * Reading line at a time using BufferedReader.
     * @return all char in the file in String.
     */
    public String readFileBufferedReader() {
        String result = "";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(ALICE_PATH)));

            for (String x = in.readLine(); x != null; x = in.readLine()) {
                result = result + x + '\n';
            }

        } catch (IOException e) {
        }

        if(in != null)try {
            in.close();
        } catch (IOException e) {
        }

        return result;
    }

    /**
     * A method for making TaskBufferedReader runnable.
     * run readFileBufferedReader and print the result.
     */
    @Override
    public void run() {
        String data = readFileBufferedReader();
        System.out.printf("Using BufferedReader, append lines to String. read %d char\n", data.length());
    }
}
