package kazuate;

import java.util.Random;
import java.util.Scanner;

public class Kazuate_main {
	public static void main(String[] args){

		//コンピュータの数字を決める
		//検索キーワード：「java ランダム 範囲」
		//ランダムクラスの準備をする
		Random random = new Random();
		//変数 number を用意し、値を0～99の中からランダムで決める
		int number = random.nextInt(100);

		//下記の内容を表示する
		System.out.println("数字を当ててみてね。");
		System.out.println("答えられるのは５回までだよ。");
		System.out.println();

		//キーボード入力の準備をする
		//キーボード入力の処理はeラーニング【入門編】の一番下の【補足】を見てね
		var stdin = new Scanner(System.in);
		//5回解答させるのでforを使う
		for(int count = 1;count <= 5;count++) {
			//「〇〇回目」を表示する
			System.out.print(count + "回目：");

			//変数 inputNumber を用意し、入力した数字を inputNumber に代入する
			int inputNumber = stdin.nextInt();
			// inputNumber を表示する
			System.out.println(inputNumber);

			// number と inputNumber が等しいとき
			//正解表示を行う
			if(number == inputNumber) {
				//「すごい！！〇〇回で当てられちゃった！」を表示する
				System.out.println("すごい！！" + count + "回で当てられちゃった！");
				// return の後はプログラムが終了するので終了処理を行う
				stdin.close();
				// return でプログラムを終了する
				return;
			}

			// number を inputNumber が異なるとき
			// number と inputNumber を比べて、その大小で処理を変える
			if(number < inputNumber) {
				// number より inputNumber が大きいとき、「もっと小さい数字だよ」を表示する
				System.out.println("もっと小さい数字だよ");
			}else {
				// number より inputNumber が小さいとき、「もっと大きい数字だよ」を表示する
				System.out.println("もっと大きい数字だよ");
			}
		}

		//5回解答しても正解できなかったとき、「残念！！正解は〇〇でした！」を表示する
		System.out.println("残念！！正解は" + number + "でした！");

		//終了処理を行う
		stdin.close();
	}
}
