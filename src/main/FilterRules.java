package main;

import java.util.ArrayList;
import java.util.Comparator;

/** класс, в котором производится фильтрация объектов*/
public class FilterRules {

	/** список правил*/
	private ArrayList<Rule> rules = new ArrayList<Rule>(40) ;

	/** конструктор, на входе которого все исходные необработанные правила*/
	public FilterRules(String rules){
		/** здесь мы вызываем метод для получения данных */
		createRules(rules);
		/** и дальнейшей из фильтрации*/
		filtr();
	}

	/** создаем и добавляем правила в список*/
	public void createRules(String rules){
		setParams("name",rules);
		setParams("type",rules);
		setParams("weight",rules);
		
	}

	@Override
	/** вывод всех правил на печать */
	public String toString() {
		/** так как конкатенаций будет много создаем объект StringBuilder */
		StringBuilder output = new StringBuilder() ;
		output.append("<rules>"+ "\n");
		/** создаем правила, прикрепляя по кусочкам наши параметры */
		for (int i=0; i<rules.size();i++){
			output.append("     <rule name=\""+rules.get(i).getName()+"\" ");
			output.append("type=\""+rules.get(i).getType()+"\" ");
			output.append("weight=\""+rules.get(i).getWeight()+"\"/> \n");
		}
		output.append("<rules>");
		return output.toString();

	}


	/** добавляем правила в наш список*/
	public void setParams(String param, String ruls){
		/** достаем параметры правил в две фазы:
		 * сначала разбиваем наши входные данные по нужному нам параметру*/
		String[] secondPhase, firstPhase = ruls.split(param + "=");
		String endResult;

		for  (int i = 1; i< firstPhase.length; i++){
			/** здесь выделяем наш параметр */
			secondPhase = firstPhase[i].split(" "); 
			/** избавляемся от кавычек */
			if (param.equals("weight")) endResult = secondPhase[0].substring(1, secondPhase[0].length()-3);
			else endResult = secondPhase[0].substring(1, secondPhase[0].length()-1);
			/** если правил нет, то создаем их */
			if (rules.size()<i ) rules.add(new Rule());
			/** изменяем правила в соответствии с полученными нами параметрами */
			if (param.equals("weight")) rules.get(i-1).setWeight(Integer.parseInt(endResult));
			else if (param.equals("name")) rules.get(i-1).setName(endResult);
			else rules.get(i-1).setType(endResult);
			

		}
	}

	/** метод, фильтрующий правила по их параметрам*/
	public void filtr(){
		/** фильтруем правила сначала по имени, после по типу, после по весу в порядке возрастания*/
		Comparator<Rule> comp = new CompareRulesByName().thenComparing(
				new CompareRulesByType().thenComparing(new CompareRulesByWeight()));
		rules.sort(comp);
		
		/** все правила, имеющие одинаковые имена и находящиеся 
		 * ниже 1ого нами встречаемого потворяющегося имени мы будем удалять*/
		for(int i = 0; i+1< rules.size(); ){
			if ( rules.get(i).getName().equals(rules.get(i+1).getName())) rules.remove(i+1);
			else  i ++;
		}
	}

}
