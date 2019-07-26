package introduction;

import java.util.Random;
import java.util.Scanner;

public class Program_1 {
	public static void main(String[] args) throws Exception {

		// コンピュータの数字を決める
		Random random = new Random();
		int number = random.nextInt(100);

		System.out.println("数字を当ててみてね。");
		System.out.println("答えられるのは５回までだよ。");
		System.out.println();

		var stdin = new Scanner(System.in);
		for (int count = 1; count <= 5; count++) {
			System.out.print(count + "回目：");

			int inputNumber = stdin.nextInt();
			System.out.println(inputNumber);

			if (number == inputNumber) {
				System.out.print("すごい！！" + count + "回で当てられちゃった！");

				// 終了処理
				stdin.close();
				return;
			}
			if (number < inputNumber) {
				System.out.println("もっと小さい数字だよ");
			} else {
				System.out.println("もっと大きい数字だよ");
			}
		}

		System.out.println("残念！！正解は " + number + " でした！");

		// 終了処理
		stdin.close();
	}
}
