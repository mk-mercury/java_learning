package nyumon;

import java.util.Random;
import java.util.Scanner;

public class Nyumon04{
	public static final String card[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public static final int card_max = 13;

	public static void main(String[] args) {

		var stdin = new Scanner(System.in);

		Random random = new Random();

		int player_sum;
		int player_draw;
		int player_ace;
		int player_bj;
		int cpu_sum;
		int cpu_draw;
		int cpu_ace;
		int cpu_bj;
		String draw_yn;
		int player_coin = 100;
		int i;

		while(true) {
			player_sum = 0;
			player_ace = 0;
			player_bj = 0;
			cpu_sum = 0;
			cpu_ace = 0;
			cpu_bj = 0;

			System.out.println("所持コイン：" + player_coin + "枚");
			System.out.println("コインを10賭けます。");
			player_coin -= 10;

			/* 最初の2枚を引く処理 */
			for(i = 0;i < 2;i++) {
				player_draw = random.nextInt(card_max);
				cpu_draw = random.nextInt(card_max);
				System.out.println("あなたに「" + card[player_draw] + "」が配られました。");
				System.out.println("ディーラーに「" + card[cpu_draw] + "」が配られました。");

				if(player_draw >= 10) {
					player_sum += 10;
				}
				else if(player_draw == 0) {
					player_sum += 11;
					player_ace++;
				}
				else {
					player_sum += (player_draw + 1);
				}

				if(cpu_draw >= 10) {
					cpu_sum += 10;
				}
				else if(cpu_draw == 0) {
					cpu_sum += 11;
					cpu_ace++;
				}
				else {
					cpu_sum += (cpu_draw + 1);
				}
			}

			/* 最初の2枚がAだった時の処理 */
			if(player_sum > 21) {
				player_sum = player_sum - 10;
				player_ace--;
			}

			if(cpu_sum > 21) {
				cpu_sum = cpu_sum - 10;
				cpu_ace--;
			}

			/* BJの判定 */
			if(cpu_sum == 21) {
				System.out.println("ディーラーの合計は" + cpu_sum + "、BJです。");
				cpu_bj = 1;
			}
			else {
				System.out.println("ディーラーの合計は" + cpu_sum + "です。");
			}

			if(player_sum == 21) {
				System.out.println("現在の合計は" + player_sum + "、BJです。");
				player_bj = 1;
			}
			else {
				System.out.println("現在の合計は" + player_sum + "です。");
			}

			/* プレイヤーの処理 */
			while(true) {
				/* ブラックジャックだった場合は処理を抜ける */
				if(player_bj == 1) {
					break;
				}
				System.out.print("もう1枚カードを引きますか？(Y/N)：");
				draw_yn = stdin.next();

				if(draw_yn.contentEquals("Y")) {
					player_draw = random.nextInt(card_max);
					System.out.println("あなたに「" + card[player_draw] + "」が配られました。");
					if(player_draw >= 10) {
						player_sum += 10;
					}
					else if(player_draw == 0) {
						player_sum += 11;
						player_ace++;
					}
					else {
						player_sum += (player_draw + 1);
					}
					if(player_sum > 21 && player_ace > 0){
						player_sum -= 10;
						player_ace--;
					}
					System.out.println("現在の合計は" + player_sum + "です。");
					if(player_sum == 21) {
						break;
					}
					else if(player_sum > 21) {
						System.out.println("バーストしました・・・");
						break;
					}
				}
				else {
					break;
				}
			}

			/* ディーラーの処理 */
			while(true) {
				/* ブラックジャックだった場合は処理を抜ける */
				if(cpu_bj == 1) {
					break;
				}
				if(cpu_sum < 17) {
					cpu_draw = random.nextInt(card_max);
					System.out.println("ディーラーに「" + card[cpu_draw] + "」が配られました。");
					if(cpu_draw >= 10) {
						cpu_sum += 10;
					}
					else if(cpu_draw == 0) {
						cpu_sum += 11;
						cpu_ace++;
					}
					else {
						cpu_sum += (cpu_draw + 1);
					}
					if(cpu_sum > 21 && cpu_ace > 0) {
						player_sum -= 10;
						player_ace--;
					}
					System.out.println("ディーラーの合計は" + cpu_sum + "です。");
				}
				else {
					break;
				}
			}

			/* 勝敗の判定 */
			if(player_bj == 1) {
				if(cpu_bj == 1) {
					System.out.println("どちらもBJのため引き分けです。");
					player_coin += 10;
				}
				else {
					System.out.println("BJであなたの勝ちです。");
					player_coin += 30;
				}
			}
			else if(cpu_bj == 1) {
				System.out.println("BJでディーラーの勝ちです。");
			}
			else if(player_sum > 21) {
				if(cpu_sum > 21) {
					System.out.println("引き分けです。");
					player_coin += 10;
				}
				else {
					System.out.println("ディーラーの勝ちです。");
				}
			}
			else if(cpu_sum > 21) {
				System.out.println("あなたの勝ちです。");
				player_coin += 20;
			}
			else {
				if(player_sum > cpu_sum) {
					System.out.println("あなたの勝ちです。");
					player_coin += 20;
				}
				else if(cpu_sum > player_sum) {
					System.out.println("ディーラーの勝ちです。");
				}
				else {
					System.out.println("引き分けです。");
					player_coin += 10;
				}
			}
			if(player_coin <= 0) {
				System.out.println("手持ちのコインがなくなりました。終了します。");
				break;
			}
		}
		stdin.close();
	}
}