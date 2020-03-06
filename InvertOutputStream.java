import java.io.IOException;
import java.io.OutputStream;

public class InvertOutputStream extends OutputStream {
    OutputStream out;

    public InvertOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int i) throws IOException {
        out.write(i);
    }

    @Override
	public void write(byte[] data) throws IOException {
        for (int i = data.length - 1; i >= 0; i--) {
            write(data[i]);
        }
    }

    @Override
	public void write(byte[] data, int offset, int length) throws IOException {
        for (int i = data.length - 1; i >= offset; i--) {
            write(data[i]);
        }
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }
}
