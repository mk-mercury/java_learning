package introduction;

import java.util.Random;
import java.util.Scanner;

public class Program_3 {
	public static void main(String[] args) {
		//ランダムクラスの準備をする
		Random random = new Random();

		//下記の内容を表示する
		System.out.println("じゃんけん勝負");
		System.out.println("グーチョキパーを数字で入力してね");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー");
		System.out.println();

		//文字列型の配列 names を用意してグーチョキバーを設定する
		String[] names = {"グー","チョキ","パー"};

		//入力をさせる準備をする
		var stdin = new Scanner(System.in);
		//boolean型の変数 isFirst を用意し、trueで初期化する
		// isFirst はwhileの最後でfalseになり、２回目以降はずっとfalseのまま
		//これにより、 isFirst で１回目とそれ以外の判定をすることができる
		Boolean isFirst = true;
		//while(true)で無限ループを生成し、勝敗がついたらbreakで無限ループを抜ける
		while(true) {
			// isFirst がtrue(1回目のループ)のとき
			if(isFirst == true) {
				//「最初はぐー、じゃんっけんっ：」を表示する
				System.out.print("最初はぐー、じゃんっけんっ：");
			// isFirst がfalse(２回目以降のループ)のとき
			}else {
				//「あいこでっ」を表示する
				System.out.print("あいこでっ：");
			}

			//自分の手を保持する変数 player を用意して入力した値を代入する
			int player = stdin.nextInt();
			// player を表示する
			System.out.println(player);

			//相手の手を保持する変数 com を用意して、値を乱数(0～2)に決める
			int com = random.nextInt(3);

			//「〇〇(COM)と〇〇(Player)で...」を表示する
			System.out.println(names[com] + "(COM)と" + names[player] + "(Player)で...");
			// player と com を比べて、その値で勝敗判定を行う
			if(com == player) {
				// player と com が同じとき、「あいこだよ！」を表示する
				System.out.println("あいこだよ！");
			}else if((com == 0 && player == 1)|| // COM:グー、Player:チョキ
					(com == 1 && player == 2) || // COM:チョキ、Player:パー
					(com == 2 && player == 0)){ // COM:パー、Player:グー
				// Playerが負けたとき、「あなたの負け」を表示する
				System.out.println("あなたの負け");
				//breakで無限ループを抜ける
				break;
			}else {
				// COM:グー、Player:パー
				// COM:チョキ、Player:グー
				// COM:パー、Player:チョキ
				//Playerが勝ったとき、「あなたの勝ち」を表示する
				System.out.println("あなたの勝ち");
				//breakで無限ループを抜ける
				break;
			}
			//改行する
			System.out.println();

			// isFirst をfalseにする(２回目以降になる)
			isFirst = false;
		}

		//終了処理を行う
		stdin.close();
	}

}
