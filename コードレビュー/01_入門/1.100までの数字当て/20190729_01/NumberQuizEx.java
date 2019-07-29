package geam_1;

import java.util.Random;
import java.util.Scanner;

public class NumberQuizEx {

	//クラス変数
	static Scanner scan;

	//-------------------------------------------------

	public static void main(String[] args) {

		//スキャン
		scan = new Scanner(System.in);
		//結果判定フラグ
		int flg = 0;
		//カウンター
		int count = 0;

		//乱数取得
		Random random = new Random();
		int num = random.nextInt(1000);

		System.out.println("数字を当ててみてね。");
		System.out.println("答えられるのは１０回までだよ。");

		//for: キー入力受付
		for (int i = 0; i < 10; i++) {

			count++;
			int key = key(count);

			//if: 終了判定
			if (key == num) {
				flg = 1;
				break;
			}
			//照合
			collation(key, num);
		}
		//結果
		if (flg == 0) {
			System.out.println("残念！！正解は" + num + "でした！");
		} else {
			System.out.println("すごい！！" + count + "回で当てられちゃった！");
		}
		//終了処理
		scan.close();
	}

	//-------------------------------------------------

	private static int key(int count) {

		//入力キー
		int key = 0;
		//while:キー入力受付
		while (true) {
			try {
				System.out.println(count + "回目：");
				String str = scan.next();
				key = Integer.parseInt(str);

				if (key < 0 || key > 999) {
					System.out.println("0~999までの整数を入力してください");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("整数以外が入力されました");
				continue;
			}
			return key;
		}
	}

	private static void collation(int key, int num) {

		if (key < num) {
			if ((num - key) <= 5) {
				System.out.println("もう少し大きい数字だよ");
			} else {
				System.out.println("もっと大きい数字だよ");
			}
		} else {
			if ((key - num) <= 5) {
				System.out.println("もう少し小さい数字だよ");
			} else {
				System.out.println("もっと小さい数字だよ");
			}
		}
	}
}