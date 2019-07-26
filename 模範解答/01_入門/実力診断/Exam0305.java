package introduction;

import java.util.Scanner;

public class Exam0305 {

	public static void main(String[] args) {
		// キーボード入力を行うための Scanner の準備
		Scanner stdin = new Scanner(System.in);
		int number[] = new int[8];
		int count = 0;

		System.out.println("8つの整数を入力してください");
		for(int i = 0; i < 8; i++) {
			// 入力を促すメッセージの出力
			System.out.printf("input number" + (i + 1) + " : ");

			// 入力を受け付ける
			number[i] = stdin.nextInt();
			if(number[i] < 0) {
				// 負の値が入力された場合、for文の抜ける
				break;
			}

			count++;
		}

		System.out.println("");

		// 入力された値を逆順かつ6桁0埋めで表示を行う
		for(int i = count; i > 0; i--) {
			System.out.println("number" + i + " : (" + String.format("%06d", number[i - 1]) + ")");
		}

		// プログラム終了前の後片付け
		stdin.close();
	}
}
