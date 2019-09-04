package じゃんけん勝負;

import java.util.Random;
import java.util.Scanner;

public class じゃんけん勝負チャレンジ {


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		
		while(true){
		System.out.println("じゃんけん勝負");
		System.out.println("グー チョキ パーのどれかを数字で入力してね");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー");
		
			System.out.print("最初はぐー、じゃんけん・・・");
		
		
		int randomhand=rand.nextInt(3);
		int yourhand=scan.nextInt();
		int randomあ=rand.nextInt(4);
		
		int results=1;
		
		String hand[]={"グー","チョキ","パー"};
		String ああ[]={"右","左","上","下"};
		
		while(true){
			if(yourhand<0||yourhand>2){
				 System.out.println("1~3を入力してね");
				yourhand=scan.nextInt();
				
			}else
			if(yourhand==randomhand){
				System.out.println(hand[yourhand]+"(Player)"+hand[randomhand]+"(COM)");
				System.out.println("あいこで・・・");
				yourhand=scan.nextInt();
				randomhand=rand.nextInt(2);
			}else{
				break;
			}
		}
		 if(yourhand==0&&randomhand==1){
			System.out.println(hand[yourhand]+"(Player)"+hand[randomhand]+"(COM)で");
			System.out.println("あなたの勝ち");
			 System.out.println("指す方向を決めてね");
			 System.out.println("0:右");
			 System.out.println("1:左");
			 System.out.println("2:上");
			 System.out.println("3:下");
		}else if(yourhand==1&&randomhand==2){
			System.out.println(hand[yourhand]+"(Player)"+hand[randomhand]+"(COM)で");
			System.out.println("あなたの勝ち");
			 System.out.println("指す方向を決めてね");
			 System.out.println("0:右");
			 System.out.println("1:左");
			 System.out.println("2:上");
			 System.out.println("3:下");
		}else if(yourhand==2&&randomhand==0){
			System.out.println(hand[yourhand]+"(Player)"+hand[randomhand]+"(COM)で");
			System.out.println("あなたの勝ち");
			 System.out.println("指す方向を決めてね");
			 System.out.println("0:右");
			 System.out.println("1:左");
			 System.out.println("2:上");
			 System.out.println("3:下");
		}else {
			System.out.println(hand[yourhand]+"(Player)"+hand[randomhand]+"(COM)で");
			System.out.println("負け");
			 System.out.println("向く方向を決めてね");
			 System.out.println("0:右");
			 System.out.println("1:左");
			 System.out.println("2:上");
			 System.out.println("3:下");
			 results=0;
		}
		 
		 
		 int yourあ=scan.nextInt();
		 
		 while(true){
			 if(yourあ<0||yourあ>3){
				 yourあ=scan.nextInt();
			 }else{
				 break;
			 }
		 }
		 if(results==1){
			 if(yourあ==randomあ){
				 System.out.println("あなたの勝ち");
				 break;
			 }else{
				 System.out.println("あなたは"+ああ[yourあ]+" COMは"+ああ[randomあ]+"でもういちど");
				 System.out.println("");
				 continue;
			 }
		 }
			 if(results==0){
				 if(yourあ==randomあ){
					 System.out.println("あなたの負け");
					 break;
				 }else{
					 System.out.println("あなたは"+ああ[yourあ]+" COMは"+ああ[randomあ]);
					 System.out.println("もういちど");
					 continue;
				 }
			 }
		 
	}
		
		
		
		
		 scan.close();
		

	}

}