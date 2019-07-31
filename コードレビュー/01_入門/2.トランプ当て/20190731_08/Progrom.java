package prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Progrom {
	public static void main(String[] args) {
		String br = System.getProperty("line.separator");

		ArrayList<String> mark = new ArrayList<String>();
		Collections.addAll(mark, "ハート", "ダイヤ", "スペード", "クローバー");

		ArrayList<String> number = new ArrayList<>();
		Collections.addAll(number, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

		Random random = new Random();
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		int markRam = random.nextInt(4);
		int numberRam = random.nextInt(13);
		System.out.println("トランプを選んだよトランプの図柄を当ててね");
		System.out.println("0:ハート" + br + "1:ダイヤ" + br + "2:スペード" + br + "3:クローバー");

		while (true) {
			int count = 0;
			int markAns = 0;
			while (count < 3) {
				System.out.printf("%d回目 ", count + 1);
				System.out.println("どれだと思う:");
				markAns = stdin.nextInt();
				if (markRam == markAns) {
					System.out.println("正解！");
					break;
				} else {
					System.out.println("違います");
					count++;
				}
			}
			if (markRam != markAns) {
				System.out.println("正解は " + mark.get(markRam) + " でした。");
				break;

			}
			System.out.println("次は数字を当ててね");

			while (true) {
				int numberAns = 0;
				int count2 = 0;
				while (count2 < 4) {
					System.out.printf("%d回目 ", count2 + 1);
					System.out.println("どれだと思う:");
					numberAns = stdin.nextInt();

					if (numberAns - 1 == numberRam) {
						System.out.print("正解!" + mark.get(markRam) + "の" + number.get(numberRam) + "だよ");
						return;
					}
					if (numberAns - 1 > numberRam) {
						System.out.println("もっと小さい数字だよ");
						count2++;
					} else if (numberAns - 1 < numberRam) {
						System.out.println("もっと大きい数字だよ");
						count2++;
					}
				}
				if (numberAns != numberRam) {
					System.out.println("正解は " + number.get(numberAns) + " でした。");
					System.exit(0);
				}
			}
		}
	}
}