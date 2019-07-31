package kadai3_2;

import java.util.Random;
import java.util.Scanner;

public class Kadai3_2 {
	static String[] attimuitehoiArray = {"上", "右", "下", "左"};
	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	static int roopCount = 1;
	static int winCount = 0;
	static int loseCount = 0;

	public static void main(String[] args) {
		int number;
		int cpuNumber;
		Boolean roopFlg = true;

		String[] jankenArray = {"グー", "チョキ", "パー"};

		System.out.println("じゃんけん勝負");
		System.out.println("グーチョキパーを数字で入力してね");

		for (int i = 0; i < jankenArray.length; i++) {
			System.out.println(i + ":" + jankenArray[i]);
		}

		while (roopFlg) {
			System.out.println("最初はぐー、じゃんけん:");
			number = scanner.nextInt();
			cpuNumber = random.nextInt(jankenArray.length);
			switch (number) {
				// 自分がグーの時
				case 0:
					switch (cpuNumber) {
						// 相手がグーの時
						case 0:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							System.out.println("あいこだよ！");
							System.out.println("あいこで:");
							roopCount--;
							break;
						// 相手がチョキの時
						case 1:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							attimuitehoi(true);
							break;
						// 相手がパーの時
						case 2:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							attimuitehoi(false);
							break;
						default:
							break;
					}
					break;
				// 自分がチョキの時
				case 1:
					switch (cpuNumber) {
						// 相手がグーの時
						case 0:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							attimuitehoi(false);
							break;
						// 相手がチョキの時
						case 1:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							System.out.println("あいこだよ！");
							System.out.println("あいこで:");
							roopCount--;
							break;
						// 相手がパーの時
						case 2:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							attimuitehoi(true);							
							break;
						default:
							break;
					}
					break;
				// 自分がパーの時
				case 2:
					switch (cpuNumber) {
						// 相手がグーの時
						case 0:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							attimuitehoi(true);
							break;
						// 相手がチョキの時
						case 1:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							attimuitehoi(false);
							break;
						// 相手がパーの時
						case 2:
							System.out.println(jankenArray[cpuNumber] + "(COM)と" + jankenArray[number] + "(Player)");
							System.out.println("あいこだよ！");
							System.out.println("あいこで:");
							roopCount--;
							break;
						default:
							break;
					}
					break;
				// それ以外
				default:
					System.out.println("0 ~ 2 を入力してください:");
					roopCount--;
					break;
			}

			if (roopCount == 3) {
				System.out.println("total win: " + winCount + "/ lose: " + loseCount);
				return;
			}
			roopCount++;
		}
	}

	// あっちむいてホイを行う
	private static void attimuitehoi(Boolean isPlayerWin) {
		for (int i = 0; i < attimuitehoiArray.length; i++) {
			System.out.println(i + ":" + attimuitehoiArray[i]);
		}

		System.out.println("あっちむいてホイ:");
		// プレイヤー選択の番号
		int attimuitehoiNumber = scanner.nextInt();
		// CPUの選択番号
		int cpuAttimuitehoiNumber = random.nextInt(attimuitehoiArray.length);

		if (isPlayerWin) {
			if (attimuitehoiNumber == cpuAttimuitehoiNumber) {
				System.out.println(attimuitehoiArray[cpuAttimuitehoiNumber] + "(COM)と" + attimuitehoiArray[attimuitehoiNumber] + "(Player)で...");	
				System.out.println("あなたの勝ち");
				winCount++;
			} else {
				System.out.println(attimuitehoiArray[cpuAttimuitehoiNumber] + "(COM)と" + attimuitehoiArray[attimuitehoiNumber] + "(Player)で...");	
				System.out.println("再度じゃんけん");
				roopCount--;
			}
		} else {
			if (attimuitehoiNumber == cpuAttimuitehoiNumber) {
				System.out.println(attimuitehoiArray[cpuAttimuitehoiNumber] + "(COM)と" + attimuitehoiArray[attimuitehoiNumber] + "(Player)で...");	
				System.out.println("あなたの負け");
				loseCount++;
			} else {
				System.out.println(attimuitehoiArray[cpuAttimuitehoiNumber] + "(COM)と" + attimuitehoiArray[attimuitehoiNumber] + "(Player)で...");	
				System.out.println("再度じゃんけん");
				roopCount--;
			}
		}
	}
}
