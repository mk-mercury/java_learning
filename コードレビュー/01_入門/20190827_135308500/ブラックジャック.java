package kadai4_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kadai4_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int playerScore;
		int dealerScore;

		Boolean isPlayerBJ = false;
		Boolean isDealerBJ = false;

		String[] card = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		ArrayList<String> playerTotalCard = new ArrayList<String>();
		ArrayList<String> dealerTotalCard = new ArrayList<String>();

		int randomNumber;

		for (int i = 0; i < 2; i++) {
			// プレイヤー
			randomNumber = random.nextInt(card.length);
			System.out.println("あなたに「" + card[randomNumber] + "」が配られました。");
			playerTotalCard.add(card[randomNumber]);

			// ディーラー
			randomNumber = random.nextInt(card.length);
			System.out.println("ディーラーに「" + card[randomNumber] + "」が配られました。");
			dealerTotalCard.add(card[randomNumber]);
		}

		playerScore = getScore(playerTotalCard);
		dealerScore = getScore(dealerTotalCard);

		System.out.println("ディーラーの合計は" + dealerScore + "です");
		System.out.println("現在の合計は" + playerScore + "です");

		// 配列の要素が2つでスコアが21の場合はBJ / それ以外は違う
		if (playerTotalCard.size() == 2 && playerScore == 21) {
			isPlayerBJ = true;
		}

		if (dealerTotalCard.size() == 2 && dealerScore == 21) {
			isDealerBJ = true;
		}

		// プレイヤーのスコアが21未満の場合、もう一枚カードを引くか引かないかを選択できる
		while (playerScore < 21) {
			System.out.println("もう一枚カードを引きますか？(Y/N)");
			// Y / N の判定
			if (scanner.next().equals("Y")) {
				// カードを引く場合
				randomNumber = random.nextInt(card.length);
				System.out.println("あなたに「" + card[randomNumber] + "」が配られました。");
				playerTotalCard.add(card[randomNumber]);
				// スコアの計算
				playerScore = getScore(playerTotalCard);
				System.out.println("現在の合計は" + playerScore + "です。");
			} else {
				// カードを引かない場合
				break;
			}

		}

		// ディーラーのスコアが 17 以下の場合、もう一枚引く
		while (dealerScore <= 17) {
			// カードを引く
			randomNumber = random.nextInt(card.length);
			System.out.println("ディーラーに「" + card[randomNumber] + "」が配られました。");
			dealerTotalCard.add(card[randomNumber]);

			// スコアの計算
			dealerScore = getScore(dealerTotalCard);
			System.out.println("ディーラーの合計は" + dealerScore + "です。");
		}

		// スコアが 21 を超えた場合、バーストする
		if (playerScore > 21 && dealerScore > 21) {
			System.out.println("あなたとディーラーはバーストしました");
			return;
		} else if (playerScore > 21) {
			System.out.println("あなたはバーストしました");
			System.out.println("ディーラーの勝ちです");
			return;
		} else if (dealerScore > 21) {
			System.out.println("ディーラーはバーストしました");
			System.out.println("あなたの勝ちです");
			return;
		}

		// バーストしなかった場合、スコアが大きい方が勝ち
		if (playerScore > dealerScore) {
			System.out.println("あなたの勝ちです");
		} else if (dealerScore > playerScore) {
			System.out.println("ディーラーの勝ちです");
		} else if (playerScore == dealerScore) {
			if (isPlayerBJ && isDealerBJ == false) {
				System.out.println("あなたの役はブラックジャックです");
				System.out.println("あなたの勝ちです");
			} else if (isDealerBJ && isPlayerBJ == false) {
				System.out.println("ディーラーの役はブラックジャックです");
				System.out.println("ディーラーの勝ちです");
			}
			System.out.println("引き分けです");
		}
	}

	// スコアを返す
	private static int getScore(ArrayList<String> totalCard) {
		// 現在持っているカードを判定し、数値に置き換える
		int score = 0;
		int aCount = 0;
		for (int i = 0; i < totalCard.size(); i++) {
			totalCard.get(i);
			switch (totalCard.get(i)) {
				case "A":
					// スコアが 21 以下の場合は 11 として加算する
					score += 11;
					// スコアが 21 を超えた場合、 1 として加算する計算を行う為、Aの枚数をカウントする
					aCount++;
					break;
				case "J":
				case "Q":
				case "K":
					// J Q K の場合、 10 としてスコアに加算する
					score += 10;
					break;
				default:
					// 絵柄以外のカードはそのまま数値に変換してスコアに加算する
					score += Integer.parseInt(totalCard.get(i));
					break;
			}
		}

		// スコアが 21 を超えていて手持ちのカードにAが含まれている場合、スコアの再計算を行う
		while (score > 21) {
			if (aCount > 0) {
				// Aの計算値を 11 -> 1 にする為、調整する
				score -= 10;
				// 計算に必要なAの枚数を1枚減らす
				aCount--;
			} else {
				// スコアが21を超えていてAの計算が必要ない場合、ループを抜ける
				break;
			}
		}
		return score;
	}
}
