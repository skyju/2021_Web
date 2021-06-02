package ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import ch11.FootballPlayer;

public class Q2 {
public static void main(String[] args) {
	
		try {
			
			File newFolder = new File("D:"+File.separator+"player");
			if(!newFolder.exists()) {
				newFolder.mkdir();
				System.out.println("새 폴더를 생성했습니다.");
			}
			
			ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream("D:"+File.separator+"player"+File.separator+"player.ser"));
			List<FootballPlayer> players = new ArrayList<FootballPlayer>();
			players.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
			players.add(new FootballPlayer("디발라", 10, "유벤투스", 29));
			players.add(new FootballPlayer("케인", 10, "토트넘", 29));
			players.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
			out.writeObject(players);
			out.close();
			System.out.println("인스턴스 저장 완료!");
			
			
			ObjectInputStream in = new ObjectInputStream
					(new FileInputStream("D:"+File.separator+"player"+File.separator+"player.ser"));
			ArrayList<FootballPlayer> rePlayers = (ArrayList<FootballPlayer>)in.readObject();
			in.close();
			System.out.println("인스턴스 복원 완료");
			
			// 복원 출력
			System.out.println("복원된 인스턴스 출력");
			for(FootballPlayer fp : rePlayers) {
				fp.showInfo();
			}


			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
