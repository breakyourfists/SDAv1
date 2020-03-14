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

	public ThreadCompressor(File filePath) {
		this.filePath = filePath;
		System.out.println(filePath.getParent());

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
			System.out.println("Diretório");
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
				zos.close();
				fos.close();
			} catch (FileNotFoundException ex) {
				System.err.println("A file does not exist: " + ex);
				ex.printStackTrace();
			} catch (IOException ex) {
				System.err.println("I/O error: " + ex);
				ex.printStackTrace();
			}
		} else if (filePath.isFile()) {
			try {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
