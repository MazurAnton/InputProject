package main;

import java.util.ArrayList;
import java.util.Comparator;

/** �����, � ������� ������������ ���������� ��������*/
public class FilterRules {

	/** ������ ������*/
	private ArrayList<Rule> rules = new ArrayList<Rule>(40) ;

	/** �����������, �� ����� �������� ��� �������� �������������� �������*/
	public FilterRules(String rules){
		/** ����� �� �������� ����� ��� ��������� ������ */
		createRules(rules);
		/** � ���������� �� ����������*/
		filtr();
	}

	/** ������� � ��������� ������� � ������*/
	public void createRules(String rules){
		setParams("name",rules);
		setParams("type",rules);
		setParams("weight",rules);
		
	}

	@Override
	/** ����� ���� ������ �� ������ */
	public String toString() {
		/** ��� ��� ������������ ����� ����� ������� ������ StringBuilder */
		StringBuilder output = new StringBuilder() ;
		output.append("<rules>"+ "\n");
		/** ������� �������, ���������� �� �������� ���� ��������� */
		for (int i=0; i<rules.size();i++){
			output.append("     <rule name=\""+rules.get(i).getName()+"\" ");
			output.append("type=\""+rules.get(i).getType()+"\" ");
			output.append("weight=\""+rules.get(i).getWeight()+"\"/> \n");
		}
		output.append("<rules>");
		return output.toString();

	}


	/** ��������� ������� � ��� ������*/
	public void setParams(String param, String ruls){
		/** ������� ��������� ������ � ��� ����:
		 * ������� ��������� ���� ������� ������ �� ������� ��� ���������*/
		String[] secondPhase, firstPhase = ruls.split(param + "=");
		String endResult;

		for  (int i = 1; i< firstPhase.length; i++){
			/** ����� �������� ��� �������� */
			secondPhase = firstPhase[i].split(" "); 
			/** ����������� �� ������� */
			if (param.equals("weight")) endResult = secondPhase[0].substring(1, secondPhase[0].length()-3);
			else endResult = secondPhase[0].substring(1, secondPhase[0].length()-1);
			/** ���� ������ ���, �� ������� �� */
			if (rules.size()<i ) rules.add(new Rule());
			/** �������� ������� � ������������ � ����������� ���� ����������� */
			if (param.equals("weight")) rules.get(i-1).setWeight(Integer.parseInt(endResult));
			else if (param.equals("name")) rules.get(i-1).setName(endResult);
			else rules.get(i-1).setType(endResult);
			

		}
	}

	/** �����, ����������� ������� �� �� ����������*/
	public void filtr(){
		/** ��������� ������� ������� �� �����, ����� �� ����, ����� �� ���� � ������� �����������*/
		Comparator<Rule> comp = new CompareRulesByName().thenComparing(
				new CompareRulesByType().thenComparing(new CompareRulesByWeight()));
		rules.sort(comp);
		
		/** ��� �������, ������� ���������� ����� � ����������� 
		 * ���� 1��� ���� ������������ �������������� ����� �� ����� �������*/
		for(int i = 0; i+1< rules.size(); ){
			if ( rules.get(i).getName().equals(rules.get(i+1).getName())) rules.remove(i+1);
			else  i ++;
		}
	}

}
