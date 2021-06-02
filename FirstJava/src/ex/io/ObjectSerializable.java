package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerializable {

	public static void main(String[] args) {
		try {
			// 인스턴스 저장 : 직렬화
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Circle.ser"));
			
			out.writeObject(new Circle(1,2,3.4));
			out.writeObject(new Circle(3,5,7.9));
			out.writeObject("Hello"); //String instance
			out.close();
			System.out.println("인스턴스 저장 완료");
			
			// 인스턴스 복원 : 역직렬화
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Circle.ser"));
			
			// FIFO 방식이므로, 복원 순서는 저장 순서에 맞게 진행해야 함
			Circle c1 = (Circle)in.readObject();
			Circle c2 = (Circle)in.readObject();
			String str = (String)in.readObject();
			in.close();
			System.out.println("인스턴스 복원 완료");
			
			// 복원 출력
			System.out.println("복원된 인스턴스 출력");
			c1.showData();
			c2.showData();
			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //ex.io.Circle을 찾음
			e.printStackTrace();
		}
		
	}

}

class Circle implements Serializable { //ex.io.Circle
	
	//implements Serializable : 직렬화 대상임을 의미
	
	int x;
	int y;
	double r;
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점 ["+x+","+y+"]");
		System.out.println("반지름: "+r);
	}
}