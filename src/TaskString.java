import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskString implements Runnable {
    public final String ALICE_PATH = "src/Alice-in-Wonderland.txt";

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


    @Override
    public void run() {
        String data = readFileToString();
        System.out.printf("Using FileReader, append to String. read %d char\n", data.length());
    }
}
