package main;

/**  класс для создания правил
 * особого функционала класс не несет, и был создан для исользования компаратором*/
public class Rule {

	private String name;
	private String type;
	private int weight;
	
	Rule(){
		name = null;
		type = null;
		weight = 0;
	}
	
	Rule(String name,String type, int weight){
		this.name = name;
		this.type = type;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
