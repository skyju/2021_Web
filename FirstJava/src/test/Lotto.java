package test;

public class Lotto {

	public static void main(String[] args) {
		
		int[] ball = new int[45];
		for (int i = 0 ; i < ball.length ; i ++) {
			ball[i] = i+1;
		}
		
		int temp;
		int j;
		
		for(int i = 0 ; i < 1000 ; i ++) {
			j = (int)(Math.random()*45);
			
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}
		
		for(int i = 0 ; i < 6 ; i ++) {
			System.out.println(ball[i]+",");
		}
	}

}
