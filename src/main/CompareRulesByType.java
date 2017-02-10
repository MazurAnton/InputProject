package main;

import java.util.Comparator;

/** три класса, которые будут заниматься сортировкой наших параметров*/

/** здесь сортируем по типу */
class CompareRulesByType implements Comparator<Rule>{

	@Override
	/** переопределение метода интерфейса Comparator*/
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
/** метод, который будет возвращать число соответсвующему типу
 * его мы будем использовать для сравнения параметров type */
	public int count(Rule r){
		if (r.getType().equals("child")) return -1;
		else if (r.getType().equals("sub")) return 0;
		else  return 1;
	}
}

/** здесб сортируем по весу */
class CompareRulesByWeight implements Comparator<Rule>{

	@Override
	/** переопределение метода интерфейса Comparator*/
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

/**  здесь сортируем по имени*/
	class CompareRulesByName implements Comparator<Rule>{

		@Override
		/** переопределение метода интерфейса Comparator*/
		public int compare(Rule o1, Rule o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

