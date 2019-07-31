package programtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class trumpChallenge {

	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner PlayerNumber = new Scanner(System.in);
		//マークのリスト
		ArrayList<String> mark = new ArrayList<String>();
		Collections.addAll(mark, "ハート", "ダイヤ", "スペード", "クローバー");
		//数字のリスト
		ArrayList<String> number = new ArrayList<>();
		Collections.addAll(number, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10","J", "Q", "K");
		
		int MarkTrump = rnd.nextInt(1);
		int NumberTrump = rnd.nextInt(2);
		
		//マーク当て問題文
		System.out.println("トランプを選んだよ");
		System.out.println("トランプの図柄を当ててね");
		System.out.println("0:ハート");
		System.out.println("1:ダイヤ");
		System.out.println("2:スペード");
		System.out.println("3:クローバー");
		
		//Player回答回数
		int QuestionCount = 2;
		int AnswerCount = 0;
		
		// マークを当てる処理
		while (true) {
			int MarkAnswer = 0; 
			System.out.println("残り回答権"+(QuestionCount-AnswerCount)+"回");
			System.out.print("どれだと思う:");
			MarkAnswer = PlayerNumber.nextInt();
			//用意していない回答が入力された場合の処理
			while (MarkAnswer < 0 || MarkAnswer > 3) { 
				System.out.println("0~3を入力してください");
				System.out.print("どれだと思う:");		
				MarkAnswer = PlayerNumber.nextInt();		
			}
			
			if(QuestionCount==AnswerCount){
				System.out.println("残念!" + mark.get(MarkAnswer) + "じゃないよ");
				System.out.println("正解の図柄は" + mark.get(MarkTrump) + "でした");
				System.out.println("また挑戦してね！");
				return;
			}
			AnswerCount++;
			if (MarkAnswer != MarkTrump) {
				//回答が間違っていた時
				System.out.println("残念!" + mark.get(MarkAnswer) + "じゃないよ");
			} else {
				//回答があっていた時
				System.out.println("正解!図柄は" + mark.get(MarkTrump) + "だよ");
				AnswerCount = 0;
				break;
			}
		}
		System.out.println("次は数字を当ててね");
		QuestionCount = 3;
		//数字を当てる処理
		while (true) {
			int NumberAnswer = 0;
			System.out.println("残り回答権"+(QuestionCount-AnswerCount)+"回");
			System.out.print("どれだと思う:");
			NumberAnswer = PlayerNumber.nextInt();
			//用意していない回答が入力された場合の処理
			while (NumberAnswer < 1 || NumberAnswer > 13) {
				System.out.println("1~13を入力してください"); 
				System.out.print("どれだと思う:");
				NumberAnswer = PlayerNumber.nextInt();
			}
			
			if(QuestionCount==AnswerCount){
				System.out.println("残念!" + number.get(NumberAnswer - 1) + "じゃないよ");
				System.out.print("正解は"+number.get(NumberTrump) + "でした");
				System.out.println("また挑戦してね！");
				return;
			}
			AnswerCount++;
			if (NumberAnswer - 1 != NumberTrump) {
				//回答が間違っていた時
				System.out.println("残念!" + number.get(NumberAnswer - 1) + "じゃないよ");
				if(NumberAnswer - 1 < NumberTrump){
					System.out.println("もっと大きい数だよ");
				}else{
					System.out.println("もっと小さい数だよ");
				}
			} else {
				//回答があっている時
				System.out.print("正解!" + mark.get(MarkTrump) + "の" +number.get(NumberTrump) + "だよ");
				break;
			} 
		}
		// 終了処理
		PlayerNumber.close();
	}
	
}
	



