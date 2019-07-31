package sample;

import java.util.Scanner;

public class Sample01 {
	public static void main(String[] args) {
		System.out.println("あっち向いてほい");
		System.out.println("グーチョキパーを数字で入力してね");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー");
		System.out.println();


		int a = janken();
		if (a == 1) {
			lose();
		} else if (a == 2) {
			win();
		}
	}
	@SuppressWarnings("resource")
	public static int janken() {
		String[] names = { "グー", "チョキ", "パー" };
		var stdin = new Scanner(System.in);
		Boolean isFirst = true;
		while (true) {
			if (isFirst == true) {
				System.out.print("最初はぐー、じゃんっけんっ:");
			} else {
				System.out.print("あいこでっ:");
			}
			int player = stdin.nextInt();
			System.out.println(player);
			int com = (int) (Math.random() * 3);
			System.out.println(names[com] + "(COM)と" + names[player] + "(Player)で...");
			if (com == player) {
				System.out.println("あいこだよ!");
			} else if ((com == 0 && player == 1) ||
					(com == 1 && player == 2) ||
					(com == 2 && player == 0)) {
				System.out.println("あなたの負け");
				return 1;

			} else {
				System.out.println("あなたの勝ち");
				return 2;

			}
			System.out.println();
			isFirst = false;
		}
	}

	public static void win() {
		System.out.println("0:上");
		System.out.println("1:下");
		System.out.println("2:右");
		System.out.println("3:左");
		System.out.println("あっちむいてー");

		int com = (int) (Math.random() * 4);
		int player;
		var stdin2 = new Scanner(System.in);
		int s1 = stdin2.nextInt();
		if (s1 == 0)
			player = 0;
		else if (s1 == 1)
			player = 1;
		else if (s1 == 2)
			player = 2;
		else if (s1 == 3)
			player = 3;
		else {
			System.out.println("もう一度入力してね");
			player = 0;
			win();
		}
		if (com != player) {
			System.out.println("残念！");
			System.out.println("もう一回");
			main(null);
		} else {
			System.out.println("あなたの勝ち");
		}
		stdin2.close();
	}

	public static void lose() {
		System.out.println("0:上");
		System.out.println("1:下");
		System.out.println("2:右");
		System.out.println("3:左");
		System.out.println("あっちむいてー");
		int com = (int) (Math.random() * 4);
		int player;
		var stdin3 = new Scanner(System.in);
		int s2 = stdin3.nextInt();
		if (s2 == 0)
			player = 0;
		else if (s2 == 1)
			player = 1;
		else if (s2 == 2)
			player = 2;
		else if (s2 == 3)
			player = 3;
		else {
			System.out.println("もう一度入力してね");
			player = 0;
			lose();
		}
		if (com != player) {
			System.out.println("セーフ！");
			System.out.println("もう一回");
			main(null);
		} else {
			System.out.println("あなたの負け");
		}
		stdin3.close();
	}
}
