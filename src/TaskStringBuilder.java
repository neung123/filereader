import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskStringBuilder implements Runnable{
    public final String ALICE_PATH = "src/Alice-in-Wonderland.txt";

    public String readFileToStringBuilder(){

        StringBuilder data = new StringBuilder();
        InputStream in = null;
        try{
            in = new FileInputStream(ALICE_PATH);
            InputStreamReader reader = new InputStreamReader(in);

            int c;
            while (true){
                c = reader.read();
                if(c < 0) break;
                data = data.append((char) c);
            }

        }catch ( IOException ex ){
            System.out.println(ex.getMessage());
        }

        if(in != null)try {
            in.close();
        } catch (IOException e) {
        }

        return data.toString();
    }

    @Override
    public void run() {
        String data = readFileToStringBuilder();
        System.out.printf("Using FileReader, append to StringBuilder. read %d char\n", data.length());
    }
}
