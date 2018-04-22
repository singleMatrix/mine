package javanet;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by single on 17/3/4.
 */
public class OutPutPra {
    public static void main(String[] args) {
        if(args.length > 0){
            InputStream in = null;

            try {
                URL u = new URL(args[0]);
                in = u.openStream();
                in = new BufferedInputStream(in);
                InputStreamReader r = new InputStreamReader(in, "ISO8859-1");
                System.out.println(r.getEncoding());
                int c;
                while((c= r.read()) != -1)
                    System.out.write(c);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
