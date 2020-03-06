import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        /*String s = "Hello World!\r\n";
        byte [] b = s.getBytes();

        OutputStream out = System.out;
        InvertOutputStream inv = new InvertOutputStream(out);
        System.out.print("### Teste Output ###");
        try {
            inv.write(b, 2, 2);
            inv.write(b);
            inv.flush();
        }catch (IOException e){
            System.err.println(e);
        }

*/
//        System.out.println("\n### Teste Input ###");
//
//        File file = new File("C://temp//text.txt");
//        FileInputStream fis = new FileInputStream(file);
//        InvertInputStream inp = new InvertInputStream(fis);
//
//        int filesize = (int)file.length();
//
//        byte [] b2 = new byte[filesize];
//        //inp.read(b2, 0, b2.length);
//        inp.read(b2);
//
//        for (byte value : b2) {
//            System.out.print((char) value);
//        }
//        inp.close();

        String s = "abrir";


        OutputStream out = System.out;
        OutputStreamWriter outW = new OutputStreamWriter(out);
        CipherWriter inv = new CipherWriter(outW);
        System.out.print("### Teste CipherWriter ###\nRetorno: ");
        try {
            inv.write(s);
            inv.flush();
        }catch (IOException e){
            System.err.println(e);
        }
        
        
//        System.out.print("### Teste CipherReader ###\nRetorno: ");
//
//        File file = new File("C://temp//text.txt");
//        FileInputStream fis = new FileInputStream(file);
//        CriptAlphabetInputStream inp = new CriptAlphabetInputStream(fis);
//
//        int filesize = (int)file.length();
//
//        byte [] b2 = new byte[filesize];
//        //inp.read(b2, 0, b2.length);
//        System.out.println("Novo: "+((char)inp.read()));
//
//
//        inp.close();
        
    }
}
