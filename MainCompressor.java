import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCompressor {
	static long resultTotal = 0;
	static long start;
	static long finish;
	static long result;
	static int cont=0;
	
	public static void main(String[] args) {
		File filePath = new File("E://temp");
	
		ThreadCompressor tc = new ThreadCompressor(filePath); 
		tc.start();
		 
		List<String> srcFiles;
		ArrayList<ThreadCompressor> ts = null;
		try {
			start = System.currentTimeMillis();
			srcFiles = Arrays.asList(filePath.list());
			ts = new ArrayList<ThreadCompressor>();

			for (String srcFile : srcFiles) {
				System.out.println(srcFile);
				ts.add(new ThreadCompressor(new File(filePath + "\\" +srcFile)));
				cont++;
			}
			for (ThreadCompressor threadCompressor : ts) {
				threadCompressor.start();
			}
			while (thEmExec(ts)) {
				Thread.sleep(100);
			}
			
			//finish = System.currentTimeMillis();
			//result = start - finish;
			//System.out.println("Resultado "+result * -1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean thEmExec(ArrayList<ThreadCompressor> ts) {
		for (ThreadCompressor threadCompressor : ts) {
			return threadCompressor.isAlive();
		}
		return false;
	}
}