package main;

import java.io.FileNotFoundException;

public class MainApp {

	/** ��������� ����� �� ������� ����� �������������� ������ ������ */
	private static String fileNameRead = "inputRules.xml";
	/**  � ������ ��������������� ������*/
	private static String fileNameWrite = "outputRules.xml";
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		/** ���������� ������ ������ �� ����� */
		String inputRules = Stream.read(fileNameRead);
		/** ���������� ������, ����� �������� ������� ���������� */
		FilterRules outputRules = new FilterRules(inputRules);
		System.out.println(outputRules.toString());
		/** ������ ��������������� ������ � ���� */
		Stream.write(fileNameWrite, outputRules.toString());
		
		
	}

}
