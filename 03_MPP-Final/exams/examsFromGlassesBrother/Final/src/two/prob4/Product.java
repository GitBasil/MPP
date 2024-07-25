package two.prob4;

import java.util.Arrays;

public class Product {

	static int[][] computeProduct(int[] first, int[] second){
		int size = first.length * second.length;
		int[][] pairs = new int[size][];
		int count=0;
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < second.length; j++) {
				pairs[count++] = new int[]{first[i], second[j]};
			}
		}
		return pairs;
	}
	public static void main(String[] args) {
		int[] arr1 = {2,4,6};
		int[] arr2 = {1,5};
		int[][] product = computeProduct(arr1, arr2);
		for (int i = 0; i < product.length; i++) {
			System.out.println(Arrays.toString(product[i]));
		}
	}
}
