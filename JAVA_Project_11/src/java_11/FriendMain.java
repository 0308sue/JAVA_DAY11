package java_11;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendMain {
	private ArrayList<Friend> arr = new ArrayList<Friend>();
	File dir, file;
	public FriendMain() throws IOException, ClassNotFoundException { // 파일 ==> arr
		dir =new File("src\\com\\day11");
		file = new File(dir, "myfriend.txt");
		if(!file.exists()) { //파일이 없을때
			file.createNewFile();// 파일 새로 만듬
			return;
		}
		//파일 있음
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		arr =(ArrayList<Friend>)ois.readObject();
		ois.close();
	}
	
	private void fileUse() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.친구추가  2.친구리스트  3.저장/종료");
			int choice = sc.nextInt();
			sc.nextLine(); // 번호 입력 후 생긴 엔터 처리
			if(choice==1) { // 친구추가
				System.out.println("이름 >>");
				String name = sc.nextLine();
				System.out.println("생일 >>");
				String birth = sc.nextLine();
				System.out.println("주소>>");
				String addr = sc.nextLine();
				System.out.println("전화번호>>");
				String tel = sc.nextLine();
				Friend f = new Friend();
				f.setName(name);
				f.setBirth(birth);
				f.setAddr(addr);
				f.setTel(tel);
				arr.add(f);
			}else if(choice==2) {
				for(Friend f : arr) {
//					System.out.println("이름 : " + f.getName());
//					System.out.println("생일 : " + f.getBirth());
//					System.out.println("주소 : " + f.getAddr() );
//					System.out.println("전화번호 : " + f.getTel());
					System.out.println(f);
				}
			}else if(choice ==3) {
				//저장  arr ==>file(myfrient.txt)
				ObjectOutputStream oos 
				  = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(arr);
				
				
				//종료
				System.out.println("종료");
				System.exit(0);
			}else {
				System.out.println("입력오류");
				
			}
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FriendMain fm = new FriendMain();
		fm.fileUse();

	}

}
