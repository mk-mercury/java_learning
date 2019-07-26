package introduction;

import java.util.Scanner;

public class Exam0308 {

	public static void main(String[] args) {
		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);
		int point[] = new int[5];
		int count = 0;
		System.out.println("整数を最大5つ入力してください。-1を入力すると終了します。");

		for(int i = 0; i < 5;) {
			// 入力を促すメッセージの出力
			System.out.printf("input number" + (i + 1) + " : ");

			// 入力を受け付ける
			point[i] = stdin.nextInt();

			if (point[i] == -1) {
				// -1が入力された場合、入力処理を終了する
				break;
			}

			if (point[i] >= 0 && point[i] <= 50) {
				i++;
				count++;
			} else {
				// 範囲外の値が入力された場合、エラーメッセージを表示して再入力を行う
				System.out.println("");
				System.out.println("Sorry. Input point (0-50 or -1).");
				System.out.println("");
			}
		}

		System.out.println("");

		// グラフ表示を行う
		for(int i = 0; i < count; i++) {
			String pointStr = String.format("%02d", point[i]);
			System.out.print("point" + (i + 1) + "(" + pointStr + "):");

			for (int j = 0; j < point[i]; j++) {
				System.out.print("*");
			}

			System.out.println("");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
