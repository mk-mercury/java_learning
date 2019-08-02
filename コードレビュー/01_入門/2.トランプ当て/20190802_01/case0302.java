package Playin_Cards;

import java.util.Random;
import java.util.Scanner;

public class case0302 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int win = 0;
		int count = 0;
		int cpu = 0;
		int cpu1 = 0;

		String[] t_mark = {"ハート", "ダイヤ", "スペード", "クローバー"};
		String[] t_num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

		Random random = new Random();
		//CPU側トランプ図柄設定
		cpu = random.nextInt(4);
		//トランプの数字設定
		cpu1 = random.nextInt(13);

		//最終正解判定
		while (true) {
			int a = mark (count, cpu);
			if (a == 1) {
				int w = number (win, cpu1);
				if (w == 1) {
					System.out.println("正解！"+ t_mark[cpu] + "の" + t_num[cpu1]  + "だよ");
					break;
				} else if (w == 2) {
					System.out.println("無念！正解は"+ t_mark[cpu] + "の" + t_num[cpu1] + "でした");
					break;
				}
			} else if (a == 2) {
				System.out.println("正解は"+ t_mark[cpu] + "の" + t_num[cpu1] + "でした");
				break;
			}
		}
	}

	//トランプ図柄あてクラス
	public static int mark (int count, int cpu) {
		//トランプ図柄初期入力メニュー表示
		Scanner stdin = new Scanner(System.in);
		String[] t_mark = {"ハート", "ダイヤ", "スペード", "クローバー"};

		System.out.println("トランプを選んだよ");
		System.out.println("トランプの図柄を当ててね。回答回数は2回までだよ");
		System.out.println("0 : ハート" + "\n1 : ダイヤ" + "\n2 : スペード" + "\n3 : クローバー");

		for (int i =1; i < 3; i++) {
			System.out.println(i +"回目の挑戦");
			System.out.println("トランプの図柄を数字で入力してね");
			System.out.print("\nどれだと思う？ : ");

			//Player側トランプ図柄設定
			int p_mark = stdin.nextInt();

			//例外入力時判定
			if (p_mark <= -1 || p_mark >= 4) {
				System.out.print("\nどれだと思う？ : ");
				p_mark = stdin.nextInt();
			}

			//正解判定
			if (cpu-p_mark == 0) {
				System.out.println("正解！図柄は"+ t_mark[p_mark] + "だよ");
				count++;
				break;
			} else {
				System.out.println("残念！"+ t_mark[p_mark] + "じゃないよ");
			}
			if (i ==2) {
				count = 2;
				break;
			}
		}
		return count;
	}

	//トランプ数字あてクラス
	public static int number (int win, int cpu1) {
		Scanner stdin = new Scanner(System.in);
		String[] t_num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

		//トランプ数字あて初期入力メニュー表示
		System.out.println("");
		System.out.println("次は数字を当ててね。回答回数は4回までだよ");

		for (int i =1; i < 5; i++) {
			System.out.println("");
			System.out.println(i +"回目の挑戦");
			System.out.print("どれだと思う？");

			//Player側の数字設定
			int p_num = stdin.nextInt()-1;

			//例外入力時判定
			if (p_num <= -1 || p_num>= 14) {
				System.out.println("数字で入力してね(1～13）");
				p_num = stdin.nextInt()-1;
			}
			//数字判定
			if (cpu1 == p_num) {
				win ++;
				break;

			} else {
				System.out.println("残念！"+ t_num[p_num] + "じゃないよ");
				if (p_num < cpu1) {
					System.out.println("手札より大きな数字だよ");
				}else if (p_num > cpu1) {
					System.out.println("手札より小さい数字だよ");
				}
			}
			if (i ==4) {
				win = 2;
				break;
			}
		}
		return win;
	}
}



