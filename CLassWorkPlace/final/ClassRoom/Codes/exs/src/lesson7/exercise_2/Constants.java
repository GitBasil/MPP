package lesson7.exercise_2;

enum  Constants {

	COMPANY("Microsoft"),
	SALES_TARGET(20000000);

	private String strval;
	private int intval;
	Constants(int x){
		this.intval = x;
	}
	Constants(String x){
		this.strval = x;
	}
}