package introduction;

import java.util.Random;
import java.util.Scanner;

public class Program_3 {
	public static void main(String[] args) throws Exception {

		Random random = new Random();

		System.out.println("じゃんけん勝負");
		System.out.println("グーチョキパーを数字で入力してね");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー");
		System.out.println();

		String[] names = { "グー", "チョキ", "パー" };

		var stdin = new Scanner(System.in);
		Boolean isFirst = true;
		while (true) {
			if (isFirst == true) {
				System.out.print("最初はぐー、じゃんっけんっ：");
			} else {
				System.out.print("あいこでっ：");
			}

			int player = stdin.nextInt();
			System.out.println(player);

			int com = random.nextInt(3);

			System.out.println(names[com] + "(COM)と" + names[player] + "(Player)で…");
			if (com == player) {
				System.out.println("あいこだよ！");
			} else if ((com == 0 && player == 1) || // COM:グー、Player：チョキ
					(com == 1 && player == 2) || // COM:チョキ、Player：パー
					(com == 2 && player == 0)) { // COM:パー、Player：グー
				System.out.println("あなたの負け");
				break;
			} else {
				System.out.println("あなたの勝ち");
				break;
			}
			System.out.println();

			isFirst = false;
		}

		// 終了処理を行う
		stdin.close();
	}
}
