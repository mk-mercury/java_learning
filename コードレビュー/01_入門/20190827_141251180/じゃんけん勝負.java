名前：大林 達矢
日付：19/08/04

import java.util.Random;
import java.util.Scanner;

public class  Main { 
    public static void main(String[] args) {

		Random random = new Random();

		System.out.println("じゃんけん勝負");

		System.out.println("グーチョキパーを数字で入力してね");

		System.out.println("0:グー");

		System.out.println("1:チョキ");

		System.out.println("2:パー");

		System.out.println();

		String[] names = { "グー", "チョキ", "パー" };

		// 掛け声の種類
		Scanner stdin = new Scanner(System.in);

		Boolean isFirst = true;
		while (true) {

			if (isFirst == true) {

				System.out.print("最初はぐー、じゃんっけんっ：");

			} else {

				System.out.print("あいこでっ：");

			}

			// ユーザー入力用

			int player = stdin.nextInt();

			System.out.println(player);

			// 対戦相手用

			int com = random.nextInt(3);

			System.out.println(names[com] + "(COM)と" + names[player]
					+ "(Player)で…");

			// 対戦結果

			if (com == player) {

				System.out.println("あいこだよ！");
				isFirst = false;

			} else if ((com == 0 && player == 1) || (com == 1 && player == 2)
					|| (com == 2 && player == 0)) {

				sub1();

				break;

			} else {

				sub2();

				break;

			}
			System.out.println();
		}

		// 終了処理
		stdin.close();
	}

	private static void sub1() {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("あっちむいてホイ勝負");

		System.out.println("上下左右を数字で入力してね");

		System.out.println("0:上");

		System.out.println("1:下");

		System.out.println("2:右");

		System.out.println("3:左");

		System.out.println();

		String[] hands1 = { "上", "下", "右", "左" };

		Random randomA = new Random();

		Scanner stdin = new Scanner(System.in);

		while (true) {
			System.out.println("あっちむいてホイ!");

			// ユーザー入力用

			int player = stdin.nextInt();

			System.out.println(player);

			// 対戦相手用

			int com = randomA.nextInt(4);

			System.out.println(hands1[com] + "(COM)と" + hands1[player]
					+ "(Player)で…");

			// 対戦結果

			if (com == player) {

				System.out.println("あなたの負け");

				return;

			} else {

				System.out.println("もう一度!");
				return;

			}
		}
	}

	private static void sub2() {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("あっちむいてホイ勝負");

		System.out.println("上下左右を数字で入力してね");

		System.out.println("0:上");

		System.out.println("1:下");

		System.out.println("2:右");

		System.out.println("3:左");

		System.out.println();

		String[] hands1 = { "上", "下", "右", "左" };

		Random randomA = new Random();

		Scanner stdin = new Scanner(System.in);

		while (true) {
			System.out.println("あっちむいてホイ!");

			// ユーザー入力用

			int player = stdin.nextInt();

			System.out.println(player);

			// 対戦相手用

			int com = randomA.nextInt(4);

			System.out.println(hands1[com] + "(COM)と" + hands1[player]
					+ "(Player)で…");

			// 対戦結果

			if (com == player) {

				System.out.println("あなたの勝ち");

				return ;

			} else {

				System.out.println("もう一度!");
				return;

			}
		}
	}
}
