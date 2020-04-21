import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ThreadCompressor extends Thread {
	File filePath, fileToZip;
	List<String> srcFiles;
	ZipEntry zipEntry;
	FileOutputStream fos;
	ZipOutputStream zos;
	FileInputStream fis;
	byte[] bytes;
	long start, finish, result;
	

	public ThreadCompressor(File filePath) {
		this.filePath = filePath;

		try {
			srcFiles = Arrays.asList(filePath.list());			
		} catch (Exception e) {
		}
	}

	public String renameZip(File file) {
		String ret, ext;
		int index = file.getName().indexOf('.');
		ext = file.getName().substring(index);
		ret = file.getName().replace(ext, ".zip");

		return ret;
	}

	@Override
	public void run() {
		if (filePath.isDirectory()) {
			start = System.currentTimeMillis();			
			try {
				fos = new FileOutputStream(filePath + "\\" + "multiCompressed.zip");
				zos = new ZipOutputStream(fos);
				for (String srcFile : srcFiles) {
					fileToZip = new File(srcFile);
					fis = new FileInputStream(filePath + "\\" + fileToZip);
					zipEntry = new ZipEntry(fileToZip.getName());
					zos.putNextEntry(zipEntry);

					bytes = new byte[1024];
					int length;
					while ((length = fis.read(bytes)) >= 0) {
						zos.write(bytes, 0, length);
					}
					fis.close();
				}

				System.out.println("oooi");
				zos.close();
				fos.close();
				finish = System.currentTimeMillis();
				MainCompressor.result = MainCompressor.start - finish;
				System.out.println("Tempo "+(MainCompressor.result*-1)+" milisegundos");			
				File file = new File(filePath + "\\" + "multiCompressed.zip");
				file.delete();
			} catch (FileNotFoundException ex) {
				System.err.println("A file does not exist: " + ex);
				ex.printStackTrace();
			} catch (IOException ex) {
				System.err.println("I/O error: " + ex);
				ex.printStackTrace();
			}
		} else if (filePath.isFile()) {
			try {
				//start = System.currentTimeMillis();		
				fos = new FileOutputStream(filePath.getParent()+"\\"+renameZip(filePath));
				zos = new ZipOutputStream(fos);

				fileToZip = new File(filePath.getAbsolutePath());
				fis = new FileInputStream(fileToZip);
				zipEntry = new ZipEntry(fileToZip.getName());
				zos.putNextEntry(zipEntry);
				bytes = new byte[1024];
				int length;
				while ((length = fis.read(bytes)) >= 0) {
					zos.write(bytes, 0, length);
				}
				zos.close();
				fis.close();
				fos.close();
				finish = System.currentTimeMillis();
				MainCompressor.cont--;
				if(MainCompressor.cont==0) {
					MainCompressor.result = MainCompressor.start - finish;
					System.out.println("Tempo "+(MainCompressor.result*-1)+" milisegundos");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
