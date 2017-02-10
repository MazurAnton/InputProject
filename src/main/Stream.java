package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/** В это классе производится запись в файл и чтение из файла*/
public class Stream {
	
/** метод для записи в файл*/
	public static void write(String fileName, String text) {
		/** создаем файл для щаписи*/
		File file = new File(fileName);

		try {
			/** проверка на существование файла*/
			if(!file.exists()){
				file.createNewFile();
			}
			/** обеспечивает возможность записать в файл*/
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				/** записываем текст в файл */
				out.print(text);
			} finally {
				/** закрываем файл*/
				out.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	/**метод для чтения из файла */
	public static String read(String fileName) throws FileNotFoundException {

		StringBuilder sb = new StringBuilder();
		
		/** проверка на сцуществование файла */
		File file = new File(fileName);
		if (!file.exists())
			throw new FileNotFoundException(file.getName());

		try {
			/** используем буфер для чтения данных из потока */
			BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
			try {
				/** построчно считываем файл */
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				/** закрываем файл */
				in.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}

		/** возвращаем полученный текст */
		return sb.toString();
	}
	

}
