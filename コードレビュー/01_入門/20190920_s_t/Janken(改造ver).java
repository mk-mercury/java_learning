package fs01_GettingStarted_ProgramCreation;

import java.util.Random;
import java.util.Scanner;

public class Janken {

	static Random random = new Random();
	static Scanner stdin = new Scanner(System.in);
	static int win = 0;		//勝利回数
	static int lose = 0;	//敗北回数
	static int count = 0;	//消化試合数

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String[] janken = {"グー","チョキ","パー"};
		System.out.println("あっちむいてホイ！3本勝負");
		System.out.println("グーチョキパーを数字で入力してね");

		for(int i = 0; i<janken.length; i++){
			System.out.println(i + ":" + janken[i]);
		}

		System.out.println("");
		System.out.print("最初はぐー、じゃんけん：");

		while(true){
			if(count==3){
				System.out.println();
				System.out.println("結果は...「" + win + "勝" + lose + "敗」");
				break;
			}

			int com = random.nextInt(3);	//コンピュータのランダム入力(じゃんけん)
			int player = stdin.nextInt();	//プレイヤーの入力(じゃんけん)

			//勝敗判定（コンピューターが「0：グー」もしくは「1：チョキ」の時）
			if((com==0 && com!=player)||(com==1 && com!=player)){
				System.out.println
				(janken[com] + "(COM)と" + janken[player] + "(player)で...");
				if(com+1==player){
					System.out.println("(負け)あっちむいて～\n");
					janken_lose();
				} else {
					System.out.println("(勝ち)あっちむいて～\n");
					janken_win();
				}
			}

			//勝敗判定（コンピューターが「2：パー」の時）
			if(com==2 && com!=player){
				System.out.println
				(janken[com] + "(COM)と" + janken[player] + "(player)で...");
				if(com-1==player){
					System.out.println("(勝ち)あっちむいて～\n");
					janken_win();
				} else {
					System.out.println("(負け)あっちむいて～\n");
					janken_lose();
				}
			}

			//あいこの時
			if(com==player){
				System.out.println
				(janken[com] + "(COM)と" + janken[player] + "(player)で...");
				System.out.println("あいこだよ！\n");
				System.out.print("あいこで：");
			}
		}

	}


	//じゃんけんに「負けた」場合。。
	public static void janken_lose(){
		int com = random.nextInt(4);	//コンピュータのランダム入力(あっちむいてホイ)

		String[] hoi = {"↑(上)","↓(下)","←(左)","→(右)"};
		for(int i = 0; i<hoi.length; i++){
			System.out.println(i + ":" + hoi[i]);
		}
		System.out.println("");
		System.out.print("ホイ！：");
		int player = stdin.nextInt();	//プレイヤーのランダム入力(あっちむいてホイ)

		System.out.println(hoi[com] + "(COM)と" + hoi[player] + "(player)で...");

		if(com==player){
			System.out.println("あなたの負け!\n");
			lose++;
			count++;
			nextJanken();
		} else {
			System.out.println("仕切り直し!\n");
			System.out.print("最初はぐー、じゃんけん：");
		}
	}

	//じゃんけんに「勝った」場合。。
	public static void janken_win(){
		int com = random.nextInt(4);	//コンピュータのランダム入力(あっちむいてホイ)

		String[] hoi = {"↑(上)","↓(下)","←(左)","→(右)"};
		for(int i = 0; i<hoi.length; i++){
			System.out.println(i + ":" + hoi[i]);
		}
		System.out.println("");
		System.out.print("ホイ！：");
		int player = stdin.nextInt();	//プレイヤーのランダム入力(あっちむいてホイ)

		System.out.println(hoi[com] + "(COM)と" + hoi[player] + "(player)で...");

		if(com==player){
			System.out.println("あなたの勝ち!\n");
			win++;
			count++;
			nextJanken();
		} else {
			System.out.println("仕切り直し!\n");
			System.out.print("最初はぐー、じゃんけん：");
		}
	}

	//次の勝負の掛け声
	public static void nextJanken(){
		switch(count){
		case 1:
		case 2:
			System.out.println((count+1) + "本目！最初はぐー、じゃんけん：");
		}
	}
}

//<仕様変更>
//(済み) １．３回勝負にして、結果を表示してみよう
//(済み) ２．じゃんけんのあとに、あっちむいてホイ！
