package main;

import java.io.FileNotFoundException;

public class MainApp {

	/** указываем файлы из который будет произдводиться чтение правил */
	private static String fileNameRead = "inputRules.xml";
	/**  и запись отфильтрованных правил*/
	private static String fileNameWrite = "outputRules.xml";
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		/** собственно чтение правил из файла */
		String inputRules = Stream.read(fileNameRead);
		/** фильтрация правил, путем создания объекта фильтрации */
		FilterRules outputRules = new FilterRules(inputRules);
		System.out.println(outputRules.toString());
		/** запись отфильтрованных данных в файл */
		Stream.write(fileNameWrite, outputRules.toString());
		
		
	}

}
