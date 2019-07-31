package ploguram;

import java.util.Random;
import java.util.Scanner;


public class Kazuate {
		public static void main(String[] args) {
			
			Scanner stdin = new Scanner(System.in);
			int count = 1;
			Random random = new Random();
			int rand = random.nextInt(1000);
			

			System.out.println("数字を当ててみてね");
			System.out.println("答えられるのは5回までだよ");		
			
			System.out.println(rand);
			
			while(count <= 10) {

				
				int number =stdin.nextInt();
				int sabun = rand - number;
				
				if(sabun >= 500 && sabun < 1000) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("もっと大きい数字だよ");
					System.out.println("500～1000以上離れているよ");
					count++;
				}else if(sabun >= 100 && sabun <= 499) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("もう少しだけ大きい数字だよ");
					System.out.println("100～500以上離れているよ");
					count++;
				}else if(sabun >= 10 && sabun <= 99) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("もう少し大きい数字だよ");
					System.out.println("100以内だよ");
					count++;
				}
				else if(sabun >= 1 && sabun <= 9) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("惜しい！");
					System.out.println("10以内だよ");
					count++;
				}
				else if(sabun <= -500 && sabun > -1000) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("もっと小さい数字だよ");
					System.out.println("500～1000以上離れているよ");
					count++;
				}
				else if(sabun <= -100 && sabun >= -499) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("もう少しだけ小さい数字だよ");
					System.out.println("100～500以上離れているよ");
					count++;
				}
				else if(sabun <= -10 && sabun >= -99) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("もう少しだけ小さい数字だよ");
					System.out.println("100以内だよ");
					count++;
				}
				else if(sabun <= -1 && sabun >= -9) {
					System.out.println(count + "回目" + ":" + number);
					System.out.println("惜しい！");
					System.out.println("10以内だよ");
					count++;
				}
				else {
					System.out.println("すごい！" + count + "回で当てられちゃった");
					return;
				}
			}

			System.out.println("残念！　正解は" + rand + "だよ");
			
			
			stdin.close();
		}
		

	}


