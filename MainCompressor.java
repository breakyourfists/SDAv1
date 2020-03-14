import java.io.File;
public class MainCompressor {
	public static void main(String[] args) {
		File filePath = new File("E://temp//foto.png");
		
		ThreadCompressor tc = new ThreadCompressor(filePath);
		tc.start();
	}
}
