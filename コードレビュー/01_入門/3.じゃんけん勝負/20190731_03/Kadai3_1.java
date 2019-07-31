package kadai3_1;

import java.util.Scanner;
import java.util.Random;

public class Kadai3_1 {

	public static void main(String[] args) {
		// 入力の準備
		var scanner = new Scanner(System.in);
		int number;
		int cpuNumber;

		String[] jankenArray = {"グー", "チョキ", "パー"};

		Random random = new Random();

		System.out.println("じゃんけん勝負");
		System.out.println("グーチョキパーを数字で入力してね");
		
		for (int i = 0; i < jankenArray.length; i++) {
			System.out.println(i + ":" + jankenArray[i]);
		}

		System.out.println("最初はぐー、じゃんけん:");

		while (true) {
			number = scanner.nextInt();	
			cpuNumber = random.nextInt(jankenArray.length);
			switch (number) {
				// 自分がグーの時
				case 0:
					switch (cpuNumber) {
						// 相手がグーの時
						case 0:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あいこだよ！");
							System.out.println("あいこで:");
							break;
						// 相手がチョキの時
						case 1:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あなたの勝ち");
							return;
						// 相手がパーの時
						case 2:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あなたの負け");
							return;
						default:
							break;
					}
					break;
				// 自分がチョキの時
				case 1:
					switch (cpuNumber) {
						// 相手がグーの時
						case 0:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あなたの負け");
							return;
						// 相手がチョキの時
						case 1:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あいこだよ！");
							System.out.println("あいこで:");
							break;
						// 相手がパーの時
						case 2:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あなたの勝ち");
							return;
						default:
							break;	
					}
					break;
				// 自分がパーの時
				case 2:
					switch (cpuNumber) {
						// 相手がグーの時
						case 0:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あなたの勝ち");
							return;
						// 相手がチョキの時
						case 1:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あなたの負け");
							return;
						// 相手がパーの時
						case 2:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)で...");
							System.out.println("あいこだよ！");
							System.out.println("あいこで:");
							break;
						default:
							break;
					}
					break;
				// それ以外
				default:
					System.out.println("0 ~ 2 を入力してください:");
					break;
			}
		}
	}
}
