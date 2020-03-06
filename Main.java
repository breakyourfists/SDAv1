import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

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


        System.out.print("### Teste CipherWriter ###\nRetorno: ");
    	
        String s = "abrir";
        
        OutputStream out = System.out;
        OutputStreamWriter outW = new OutputStreamWriter(out);
        CipherWriter inv = new CipherWriter(outW);
        
        try {
            inv.write(s);
            inv.flush();
        }catch (IOException e){
            System.err.println(e);
        }
        
        
        System.out.print("\n### Teste CipherReader ###\nRetorno: ");

        File file = new File("E://temp//text.txt");
        
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader inputR = new InputStreamReader(fis);        
        CipherReader inp = new CipherReader(inputR);
        

        int byteLido = inp.read();
        while(byteLido!=-1) {
        	
        	System.out.print(((char)byteLido));
        	byteLido = inp.read();
        	}          
    }
}
