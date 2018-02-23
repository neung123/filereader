import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Read file by using FileReader, read 1-char at a time to String.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class TaskString implements Runnable {
    public final String ALICE_PATH = "src/Alice-in-Wonderland.txt";

    /**
     * Reading 1-char at a time using FileReader.
     * @return all char in the file in String.
     */
    public String readFileToString(){

        String data = "";
        InputStream in = null;
        try{
            in = new FileInputStream(ALICE_PATH);
            InputStreamReader reader = new InputStreamReader(in);

            int c;
            while (true){
                c = reader.read();
                if(c < 0) break;
                data = data + ((char) c);
            }

        }catch ( IOException ex ){
            System.out.println(ex.getMessage());
        }

        if(in != null)try {
            in.close();
        } catch (IOException e) {
        }

        return data;
    }

    /**
     * A method for making TaskString runnable.
     * run readFileBufferedReader and print the result.
     */
    @Override
    public void run() {
        String data = readFileToString();
        System.out.printf("Using FileReader, append to String. read %d char\n", data.length());
    }
}
