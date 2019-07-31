package jp.co.FSsakusei2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Challenge4 {

	public static void main(String[] args) {

		String[] a = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K" };

		Scanner stdin = new Scanner(System.in);
		Random r = new Random();
		int playercoin =100;

		while(playercoin !=0){
		int player = 0;
		ArrayList<String> playercard = new ArrayList<String>();
		int cpu = 0;
		ArrayList<String> cpucard = new ArrayList<String>();
		int count = 1;
		int kazu = r.nextInt(12);
		int playera = 0;
		int cpua = 0;
		//int playercoin =100;
		//int playerten = 0;
		//int cputen = 0;

//while(playercoin !=0){
		System.out.println();
		System.out.println("開始");
		System.out.println("現在持ち金:"+playercoin+"-今回のかけ金:10");
		playercoin=playercoin-10;

		while (count != 5) {
			kazu = r.nextInt(12);
			if (count % 2 != 0) {
				System.out.println("あなたに" + a[kazu] + "が配られました");
				playercard.add(a[kazu]);
				count = count + 1;
			} else {
				System.out.println("相手に" + a[kazu] + "が配られました");
				cpucard.add(a[kazu]);
				count = count + 1;
			}
		}

		for (int i = 0; i < playercard.size(); i++) {
			if ((playercard.get(i) == "J") || (playercard.get(i) == "Q")
					|| (playercard.get(i) == "K")) {
				player = player + 10;
				//playerten = playerten + 1;
			} else if (playercard.get(i) == "A") {
				player = player + 11;
				playera = playera + 1;
			} else {
				player = player + Integer.parseInt(playercard.get(i));
			}
		}
		System.out.println("あなたの合計は" + player);

		for (int i = 0; i < cpucard.size(); i++) {
			if ((cpucard.get(i) == "J") || (cpucard.get(i) == "Q")
					|| (cpucard.get(i) == "K")) {
				cpu = cpu + 10;
				//cputen = cputen + 1;
			} else if (cpucard.get(i) == "A") {
				cpu = cpu + 11;
				cpua = cpua + 1;
			} else {
				cpu = cpu + Integer.parseInt(cpucard.get(i));
			}
		}
		System.out.println("あいての合計は" + cpu);

		while (player < 21) {
			System.out.println("現在の合計" + player);
			System.out.println("もう一枚引く(Y/N)");
			String input1 = stdin.next();
			if (input1.equals("Y")) {
				kazu = r.nextInt(13);
				System.out.println("あなたに" + a[kazu] + "が配られました");
				playercard.add(a[kazu]);

				for (int i = playercard.size() - 1; i < playercard.size(); i++) {
					if ((playercard.get(i) == "J")
							|| (playercard.get(i) == "Q")
							|| (playercard.get(i) == "K")) {
						player = player + 10;
					} else if (playercard.get(i) == "A") {
						player = player + 11;
						playera = playera + 1;
					} else {
						player = player + Integer.parseInt(playercard.get(i));
						//System.out.println(i + "確認用" + playercard.get(i));
					}
				}
				while ((player > 21) && (playera > 0)) {
					player = player - 10;
					playera = playera - 1;
				}
				System.out.println("現在の合計" + player);
			} else {
				System.out.println("あなたの番終了");
				break;
			}
		}

		while (cpu <= 18) {
			kazu = r.nextInt(13);
			System.out.println("相手に" + a[kazu] + "が配られました");
			cpucard.add(a[kazu]);
			for (int i = cpucard.size() - 1; i < cpucard.size(); i++) {
				if ((cpucard.get(i) == "J") || (cpucard.get(i) == "Q")
						|| (cpucard.get(i) == "K")) {
					cpu = cpu + 10;
				} else if (cpucard.get(i) == "A") {
					cpu = cpu + 11;
					cpua = cpua + 1;

				} else {
					cpu = cpu + Integer.parseInt(cpucard.get(i));
				}
			}
			while ((cpu > 21) && (cpua > 0)) {
				cpu = cpu - 10;
				cpua = cpua - 1;
			}
			System.out.println("あいての合計は" + cpu);
		}

		int playerkei = 21 - player;
		int cpukei = 21 - cpu;

		if (playerkei < 0) {
			playerkei = 99;
		} else {
		}
		if (cpukei < 0) {
			cpukei = 99;
		} else {
		}

		if (playerkei > cpukei) {
			System.out.println("負け");
			System.out.println("現在持ち金:"+playercoin);
		} else if (playerkei < cpukei) {
			System.out.println("あなた"+player+"あいて"+cpu+"で勝ち");
			playercoin = playercoin + 20;
			System.out.println("現在持ち金:"+playercoin);
		} else if ((playerkei == cpukei) && (playerkei == 21)) {
			if ((playercard.size() == 2) && (cpucard.size() != 2)) {
				System.out.println("ブラックジャック判定で勝ち");
				playercoin = playercoin + 30;
				System.out.println("現在持ち金:"+playercoin);
			} else if ((playercard.size() != 2) && (cpucard.size() == 2)) {
				System.out.println("ブラックジャック判定で負け");
				System.out.println("現在持ち金:"+playercoin);
			} else {
				System.out.println("21で引き分け");
				playercoin = playercoin + 10;
				System.out.println("現在持ち金:"+playercoin);
			}
		} else {
			System.out.println("引き分け");
			playercoin = playercoin + 10;
			System.out.println("現在持ち金:"+playercoin);
		}

	}
		System.out.println("持ち金がなくなったので終了");
	}
}
