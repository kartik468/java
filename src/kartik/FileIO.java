package kartik;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
	public static void main(String[] args) throws IOException{
		
		InputStream input = null;
		OutputStream output = null;
		
		File outputDirectory = new File("D:\\temp\\op");
		outputDirectory.mkdir();
		File inputDirectory = new File("D:\\temp\\ip");
		String[] s1Array = inputDirectory.list();
		for(String s1:s1Array) {
			File f1 = new File(inputDirectory,s1);			
			if(f1.isDirectory()) {
				File f1Output = new File(outputDirectory,s1);
				f1Output.mkdir();
				File src = new File(f1Output,"src");
				src.mkdir();
				File ds = new File(src,"dataset.json");
				ds.createNewFile();
				String[] s2Array = f1.list();
				for(String s2:s2Array) {
					File f2 = new File(f1,s2);
					if(f2.isFile()) {
						System.out.println(f2.getPath());	
//						Files.copy(f1.toPath(), ds.toPath());
						
						
						
						
						
						try {

							/* FileInputStream to read streams */
							input = new FileInputStream(f2);

							/* FileOutputStream to write streams */
							output = new FileOutputStream(ds);

							byte[] buf = new byte[1024];
							int bytesRead;

							while ((bytesRead = input.read(buf)) > 0) {
								output.write(buf, 0, bytesRead);
							}

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}

						finally {
							try {

								if (null != input) {
									input.close();
								}
								
								if (null != output) {
									output.close();
								}

							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					
						
						
						
					}
				}
			}	
		}
	}
}
	