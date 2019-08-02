package toranpuate;

import java.util.Random;
import java.util.Scanner;

public class Playing_cards_1 {

	public static void main(String[] args) {

		System.out.println("トランプ当て\n");

		System.out.println("トランプを選んだよ");
		System.out.println("トランプの図柄を当ててね\n");
		System.out.println("0: ハート\n1: ダイヤ\n2: スペード\n3: クローバー\n");

		// キーボード入力の準備
		Scanner stdIn = new Scanner(System.in);

		// コンピュータが数字を決める
		Random rand = new Random();

		// 図柄配列を設定
		String[] card = {"ハート", "ダイヤ", "スペード", "クローバー"};
		int randcard = rand.nextInt(4);

		// 数字配列を設定
		String[] number = {"A", "2", "3", "4","5","6", "7","8","9","10","J","Q","K"};
		int randnumber = rand.nextInt(13);

		// 図柄を表示
		int c1;
		do{
			System.out.print("どれだと思う? : ");
			c1 = stdIn.nextInt();
			if (c1 > randcard)
				System.out.println("\n残念!" + card[c1] + "じゃないよ ");
			else if (c1 < randcard)
				System.out.println("\n残念!" + card[c1] + "じゃないよ ");

		} while (c1 != randcard);
		System.out.println("\n正解! 図柄は" + card[c1] + "だよ\n");

		System.out.println("次は数字を当ててね");

		// 数字を表示
		int c2;
		do {
			System.out.print("どれだと思う? : ");
			c2 = stdIn.nextInt();
			if (c2 > randnumber)
				System.out.println("\n残念!" + number[c2 - 1] + "じゃないよ");
			else if (c2 < randnumber)
				System.out.println("\n残念!" + number[c2 - 1] + "じゃないよ");
		} while (c2 != randnumber);
		System.out.println("\n正解! " + card[c1] + "の" + number[c2 - 1] +  "だよ\n");

		// プログラム終了前の後片付け
		stdIn.close();

	}
}