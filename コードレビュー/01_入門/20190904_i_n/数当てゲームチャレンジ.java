package 数当てゲーム;

import java.util.Random;
import java.util.Scanner;

public class 数当てゲームチャレンジ {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int count=10;
		System.out.println("数字を当てて");
		System.out.println("答えるのは"+count+"回まで");
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int data1;
		int random=rand.nextInt(1000);
		for(int i=1 ;i<=count;i++){
			data1=scan.nextInt();
			System.out.println(""+data1);
			if(data1==random){
				System.out.println("すごい！！");break;
			}else if(data1-random>=-50&&data1-random<0){
				System.out.println("もうちょっと大きい");
			}else if(data1-random<-50){
				System.out.println("もっと大きい");
			}else if(data1-random<=50&&data1-random>0){
				System.out.println("もうちょっと小さい");
			}else{
				System.out.println("もっと小さい");
			}
			if(i==count && data1!=random){
				System.out.println("残念"+"答えは"+random);
			}	
		}
		
		scan.close();
		}
		

	}


