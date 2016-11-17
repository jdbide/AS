package com.fr.africa.saveurs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;


public class FilesUtils {
	
	public static void mkDir(String dir) throws IOException {
		File directory = new File(dir);
		if (directory.isDirectory() == false)
			directory.mkdir();
	}

	public static Boolean mkDirs(String dir) throws IOException {
		File directory = new File(dir);
		if (directory.isDirectory() == false)
			return directory.mkdirs();
		else
			return false;
	}

	public static Boolean mkDirBooleanEnRetour(String dir) throws IOException {
		File directory = new File(dir);
		if (directory.isDirectory() == false) {
			directory.mkdir();
			return true;
		} else {
			return false;
		}
	}

	public static String extractFileName(String nomDuFichierSource) throws Exception {
		File file = new File(nomDuFichierSource);
		return file.getName();
	}

	public static String extractFilePath(String nomDuFichierSource) throws Exception {
		File file = new File(nomDuFichierSource);
		return file.getParent();
	}

	public static void renameFile(String nomDuFichierSource, String nomDuFichierDestination) throws Exception {
		File file = new File(nomDuFichierSource);
		file.renameTo(new File(nomDuFichierDestination));
	}

	public static boolean existFile(String nomDuFichierSource) throws Exception {
		return new File(nomDuFichierSource).exists();
	}

	public static boolean canWriteFile(String nomDuFichierSource) throws Exception {
		return new File(nomDuFichierSource).canWrite();
	}

	public static boolean canReadFile(String nomDuFichierSource) throws Exception {
		return new File(nomDuFichierSource).canRead();
	}

	public static String lectureFileMd5(String fichier, String encodageFichier) throws Exception {
		return lectureFileMd5(new File(fichier), encodageFichier);
	}

	public static String lectureFileMd5(File fichier, String encodageFichier) throws Exception {
		String output = null;

		InputStream inBytes = new FileInputStream(fichier);
		Reader inChars = new InputStreamReader(inBytes, encodageFichier);
		BufferedReader in = new BufferedReader(inChars);

		output = in.readLine();
		in.close();

		return output;
	}


	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.delete()) {
			file.deleteOnExit();
		}
	}


	public static boolean writeToFile(InputStream inputStream, String fileLocation) {
		OutputStream outputStream = null;
		boolean isOk = true;

		try {
			outputStream = new FileOutputStream(new File(fileLocation));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (IOException e) {
			isOk = false;
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		
		return isOk;
	}
}
