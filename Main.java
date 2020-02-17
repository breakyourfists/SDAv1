import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       /* String s = "Hello World!\r\n";
        byte [] b = s.getBytes();

        OutputStream out = System.out;
        InvertOutputStream inv = new InvertOutputStream(out);

        try {
            inv.write(b);
            inv.flush();
        }catch (IOException e){
            System.err.println(e);
        }*/

        // Tentativa 1
       /* InvertInputStream inv = new InvertInputStream(System.in);
       Scanner scanner = new Scanner(inv);


        System.out.println("digite ");
        String let = scanner.nextLine();
        inv.close();
        System.out.println("lido "+let);*/

        // Tentativa 2
        File file = new File("C://text.txt");
        FileInputStream fis = new FileInputStream(file);
        InvertInputStream inv = new InvertInputStream(fis);

        int filesize = (int)file.length();

        byte [] b = new byte[filesize];
        inv.read(b, 0, b.length);


        for (byte value : b) {
            System.out.println((char) value);
        }


        inv.close();


    }
}
