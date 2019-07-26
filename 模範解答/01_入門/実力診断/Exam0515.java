package introduction;

import java.util.Scanner;

public class Exam0515 {

	static int sum = 0;
	static int data_count = 0;
	static int oldNumber = 0;

	public static void main(String[] args) {
		var stdin = new Scanner(System.in);

		while(true) {
			System.out.printf("input number (more than 0) : ");

			int number = stdin.nextInt();
			if (number <= 0) {
				// 0未満が入力された場合、再入力を行う
				System.out.println("input more than 0, please.");
			} else {
				if (avg_display(number) == 0) {
					// 連続した値が入力された場合、処理を終了する
					break;
				}
			}
		}

		// 終了処理
		stdin.close();
	}

	/**
	 整数値の値を受け取り、その値を毎回加算していき、その時点で平均値を求める関数
	 @param int 入力した値
	 @return int 値が連続した場合は 0 それ以外は 1
	 */
	private static int avg_display(int number)
	{
		if (number != oldNumber) {
			// 前回と異なる値だった場合
			sum += number;
			data_count++;

			// 平均を計算して出力
			double average = (double)sum / (double)data_count;
			System.out.printf("SUM : %d / DATA_COUNT : %d / AVERAGE : %.2f", sum, data_count, average);
			System.out.println();

			// 値を保持して 1 を返す
			oldNumber = number;
			return 1;
		}

		// 前回と同じ値だった場合は 0 を返す
		return 0;
	}
}
