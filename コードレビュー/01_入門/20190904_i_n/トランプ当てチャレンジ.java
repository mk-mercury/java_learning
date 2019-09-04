package トランプ当て;

import java.util.Random;
import java.util.Scanner;

public class トランプ当てチャレンジ {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		
		String[] mark={"ハート","ダイヤ","スペード","クローバー"};
		String[] number={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		
		
		int markrandom=rand.nextInt(4);
		int numberrandom=rand.nextInt(13);
		
		
		System.out.println("トランプが選ばれました");
		System.out.println("トランプの図柄を当ててください");
		System.out.println("");
		System.out.println("0:ハート");
		System.out.println("1:ダイヤ");
		System.out.println("2:スペード");
		System.out.println("3:クローバー");
		System.out.print("どれでしょう");
		
		int markkey=scan.nextInt();
		
		int count=1;
		while(true){
			
			if(markkey==markrandom){
				System.out.println("正解！");
				System.out.println("次は数字を当ててください");
				
				break;
			}else if(markkey!=markrandom){
				System.out.println("残念"+mark[markkey]+"ではないです");
				if(markkey<markrandom){
					System.out.println("もっと大きい数字だよ");
				}else{
					System.out.println("もっと小さい数字だよ");
				}
				System.out.println("図柄はどれでしょう");
				markkey=scan.nextInt();
				count++;
			}else if(markkey>0&&markkey<3){
				System.out.println("0～3を入力してください");
				markkey=scan.nextInt();
			}
			if(count==2){
				System.out.println("残念 答えは"+mark[markkey]);
				System.out.println("次は数字を当ててね");
				break;
			}
	  }
		System.out.println("A,2,3,4,5,6,7,8,9,10,J, Q, K");
		System.out.println("1 2 3 4 5 6 7 8 9 10 11 12 13");
		int numberkey=scan.nextInt();
		
		count=1;
		while(true){
			if(numberkey<1&&numberkey>12){
				System.out.println("1～13を入力してください");
				System.out.println("数字は何でしょう");
				markkey=scan.nextInt();
			}else if(numberkey==numberrandom){
				System.out.println("正解です。答えは       "+number[numberkey]+"   お疲れさまでした");
				break;
			}else{
				System.out.println("残念"+number[numberkey]+"じゃないです");
				if(numberkey<numberrandom){
					System.out.println("もっと大きい数字だよ");
				}else{
					System.out.println("もっと小さい数字だよ");
				}
				System.out.println("数字はどれでしょう");
				numberkey=scan.nextInt();
				count++;
			}
			if(count==4){
				System.out.println("残念...答えは     "+number[numberrandom]);
				break;
			}
		}
scan.close();
		
	}

}