import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class readFile {

    public static void main(String[] args) throws IOException {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        String aliceOffline1 = reader1("src/Alice-in-Wonderland.txt");
        stopwatch.stop();
        System.out.printf("reader1:String: read %d characters in %.6f sec\n",aliceOffline1.length(),stopwatch.getElapsed());

        stopwatch.start();
        String aliceOffline2 = reader2("src/Alice-in-Wonderland.txt");
        stopwatch.stop();
        System.out.printf("reader2:StringBuilder: read %d characters in %.6f sec\n",aliceOffline2.length(),stopwatch.getElapsed());

        stopwatch.start();
        String aliceOnline = reader3("http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt");
        stopwatch.stop();
        System.out.printf("reader3:StringBuilder & url: read %d characters in %.6f sec\n",aliceOnline.length(),stopwatch.getElapsed());
    }

    public static String reader1(String name){

        String data = "";
        String filename = name;
        InputStream in = null;
        try{
            in = new FileInputStream(filename);
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

    public static String reader2(String name){

        StringBuilder data = new StringBuilder();
        String filename = name;
        InputStream in = null;
        try{
            in = new FileInputStream(filename);
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

    public static InputStream openUrl(String urlstr) throws IOException {
        URL url = null;
        try {
            url = new URL(urlstr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            return url.openStream( );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url.openStream();
    }


    public static String reader3(String name) throws IOException {

        StringBuilder data = new StringBuilder();
        String filename = name;
        InputStream in = null;
        try{
            in = openUrl(filename);
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

}
