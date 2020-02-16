import java.io.IOException;
import java.io.InputStream;

public class InvertInputStream extends InputStream {
    InputStream input;

    public InvertInputStream(InputStream input) {
        this.input = input;
    }

    @Override
    public int read() throws IOException {
        return input.read();
        /*while(data != -1) {
            data = input.read();
        }
        return data;*/
    }

   @Override
    public int read(byte[] data) throws IOException {
        byte [] aux = new byte[data.length];
        int cont =0;
        for (int i = data.length - 1; i >= 0; i--) {
            aux[cont++] = data[i];
        }
        data = aux;
        return input.read(data);
    }


}
