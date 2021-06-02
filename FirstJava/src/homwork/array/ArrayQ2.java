package homwork.array;

public class ArrayQ2 {
	
	public static void addTwoDArr(int[][] arr, int add) {
		for(int i = 0 ; i < arr.length ; i ++) {
			for(int j = 0 ; j < arr[i].length ; j ++) {
				arr[i][j] += add;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {
				{1,2,3,4,5},
				{2,3,4,5,6},
				{3,4,5,6,7},
				{4,5,6,7,8},
				{5,6,7,8,9}
		};
		
		addTwoDArr(arr, 2);
		
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+",");
			}
		System.out.println();
		}
		
		
	}

}
