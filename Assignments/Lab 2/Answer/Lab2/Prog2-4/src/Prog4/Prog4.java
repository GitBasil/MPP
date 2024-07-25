package Prog4;

public class Prog4 {

	public static void main(String[] args) {
		String myString = Data.records;
		String[] records = myString.split(":");
		for(int i=0;i < records.length;i++) {
			String[] record_values = records[i].split(",");
			System.out.println(record_values[0]);
		}
	}

}
