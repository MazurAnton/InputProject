package main;

import java.util.Comparator;

/** ��� ������, ������� ����� ���������� ����������� ����� ����������*/

/** ����� ��������� �� ���� */
class CompareRulesByType implements Comparator<Rule>{

	@Override
	/** ��������������� ������ ���������� Comparator*/
	public int compare(Rule r1, Rule r2){
		int a = count(r1);
		int b = count(r2);
		if(a> b)
			return 1;
		else if(a< b)
			return -1;
		else
			return 0;
	}
/** �����, ������� ����� ���������� ����� ��������������� ����
 * ��� �� ����� ������������ ��� ��������� ���������� type */
	public int count(Rule r){
		if (r.getType().equals("child")) return -1;
		else if (r.getType().equals("sub")) return 0;
		else  return 1;
	}
}

/** ����� ��������� �� ���� */
class CompareRulesByWeight implements Comparator<Rule>{

	@Override
	/** ��������������� ������ ���������� Comparator*/
	public int compare(Rule o1, Rule o2) {
		int a = o1.getWeight();
		int b = o2.getWeight();


		if(a> b)
			return -1;
		else if(a< b)
			return 1;
		else
			return 0;
	}
}

/**  ����� ��������� �� �����*/
	class CompareRulesByName implements Comparator<Rule>{

		@Override
		/** ��������������� ������ ���������� Comparator*/
		public int compare(Rule o1, Rule o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

