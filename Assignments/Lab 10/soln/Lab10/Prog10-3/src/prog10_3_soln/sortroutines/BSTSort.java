package prog10_3_soln.sortroutines;

import prog10_3_soln.runtime.Sorter;

public class BSTSort extends Sorter {
	int[] arr;
	public int[] sort(int[] arr){
		this.arr = arr;
		//selectionSort();
		return arr;
	}
}
