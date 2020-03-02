import java.io.IOException;
import java.io.InputStream;

public class InvertInputStream extends InputStream {
    InputStream input;
    int pos = 1;

    public InvertInputStream(InputStream input) {
        this.input = input;
    }

    @Override
    public int read() throws IOException {
        return input.read();
    }



    @Override
    public int read(byte[] b) throws IOException {
        int ret = input.read(b);
        byte [] aux = new byte [b.length];
        int cont = 0;
        for (int i = b.length - 1; i >= 0; i--) {
            aux[cont++] = b[i];
        }
        System.arraycopy(aux, 0,b,0,b.length);
        return  ret;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        try {
            int val = input.read(b, off, len);
            int cont =0;
            byte [] aux = new byte[b.length];
            for (int i = b.length - 1; i >= 0; i--) {
                aux[cont++] = b[i];
            }
            System.arraycopy(aux, 0, b, 0, b.length);

            return val;
        } catch (IOException e) {
            input.close();
            throw e;
        }
    }
}
