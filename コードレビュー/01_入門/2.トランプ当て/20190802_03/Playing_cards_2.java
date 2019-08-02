package toranpuate;

import java.util.Random;
import java.util.Scanner;

public class Playing_cards_2 {

	public static void main(String[] args) {

		System.out.println("トランプ当て\n");

		System.out.println("トランプを選んだよ");
		System.out.println("トランプの図柄を当ててね\n");
		System.out.println("0: ハート\n1: ダイヤ\n2: スペード\n3: クローバー\n");

		// キーボード入力の準備
		Scanner stdIn = new Scanner(System.in);

		// コンピュータに乱数を設定
		Random rand = new Random();

		final int MAX_NO1 = 2;  // 図柄の最大入力回数を設定
		int leftNo1 = MAX_NO1;  // 残り回数

		// 配列を準備
		String[] card = {"ハート", "ダイヤ", "スペード", "クローバー"};
		int randcard = rand.nextInt(4);

		final int MAX_NO2 = 4;  // 数字の最大入力回数を設定
		int leftNo2 = MAX_NO2;  // 残り回数

		// 配列を準備
		String[] number = {"A", "2", "3", "4","5","6", "7","8","9","10","J","Q","K"};
		int randnumber = rand.nextInt(13);

		// 図柄を表示
		int c1;
		do{
			System.out.print("残り" + (leftNo1--) + "回。どれだと思う? : ");
			c1 = stdIn.nextInt();

			if (c1 > randcard)
				System.out.println("\n残念! 図柄は" + card[c1] + "じゃないよ ");
			else if (c1 < randcard)
				System.out.println("\n残念! 図柄は" + card[c1] + "じゃないよ ");
		} while (c1 != randcard && leftNo1 > 0);

		if (c1 == randcard)
			System.out.println("\n正解! 図柄は" + card[c1] + "だよ\n" + (MAX_NO1 - leftNo1) + "回で当たりました\n" );
		else
			System.out.println("\n残念! 正解の図柄は" + card[c1] + "でした\n ");

		System.out.println("次は数字を当ててね");

		// 数字を表示
		int c2 = 0;
		do {
			System.out.print("残り" + (leftNo2--) + "回。どれだと思う? : ");
			c2 = stdIn.nextInt();

			if (c2 > randnumber)
				System.out.println("\n残念!" + number[c2 - 1] + "じゃないよ\nもっと小さい数だよ");
			else if (c2 < randnumber)
				System.out.println("\n残念!" + number[c2 - 1] + "じゃないよ\nもっと大きな数だよ");
		} while (c2 != randnumber && leftNo2 > 0);

		if (c2 == randnumber)
			System.out.println("\n正解! " + card[c1] + "の" +  number[c2 - 1] + "だよ\n" + (MAX_NO2 - leftNo2) + "回で当たりました\n");
		else
			System.out.println("\n残念! 正解は " + card[c1] + "の" +  number[c2 - 1] + "でした");

		// プログラム終了前の後片付け
		stdIn.close();

	}
}