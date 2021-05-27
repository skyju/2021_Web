package homwork1_array;

public class ArrayQ3 {
	
	public static int[][] rotate(int[][] arr) {
		int[] tmp = arr[arr.length-1];
		for(int j = arr.length-1 ; j > 0 ; j --) {
			arr[j] = arr[j-1];
		}
		arr[0] = tmp;	
		return arr;
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		rotate(arr);
		
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+",");
			}
			System.out.println();
		}
		
	}

}
