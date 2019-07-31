package pg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack
{

	public static void main(String[] args)
	{
		// TODO 自動生成されたメソッド・スタブ
		int playerSum = 0;
		List<	Integer> playerCards = new ArrayList<Integer>();

		int dealerSum = 0;
		List<	Integer> dealerCards = new ArrayList<Integer>();
		
		int result = 0;
		for(int i= 0; i  < 2; i++)
		{
			//各プレイヤーにカードを配る
			result = DistributeCard();
			playerCards.add(result);
			System.out.println("あなたに配られたカード[ " + result + "]");
			
			result = DistributeCard();
			dealerCards.add(result);
			System.out.println("ディーラーに配られたカード[ " + result + "]");
		}

		// 各カードの合計を計算
		playerSum = CalculationCardsSum(playerCards);
		dealerSum = CalculationCardsSum(dealerCards);
		
		if(playerSum > 21)
		{
			System.out.println("あなたはバーストしました");
			return;
		}
		if(dealerSum > 21)
		{
			System.out.println("ディーラーはバーストしました");
			return;
		}

		System.out.println("あなたのカードの合計は[" +  playerSum + "]です");
		System.out.println("ディーラーのカードの合計は[" +  dealerSum + "]です");

		//,プレイヤーのカードの合計が21未満の時はカードを引ける
		Scanner scanner = new Scanner(System.in);
		while(playerSum < 21)
		{
			System.out.println("もう一度カードを引きますか?(y/n)");
			System.out.println("y か n を入力してください");
			char input = scanner.next().charAt(0);

			if(input == 'y')
			{
				result = DistributeCard();
				System.out.println("あなたに配られたカード[ " + result + "]");
				playerCards.add(result);
				playerSum = CalculationCardsSum(playerCards);
				System.out.println("あなたのカードの合計は[" +  playerSum + "]です");

				if(playerSum > 21)
				{
					System.out.println("あなたはバーストしました");
					return;
				}
			}
			else if(input == 'n')
			{
				break;
			}
		}

		//ディーラーのカードの合計が17以下の場合はカードを引く
		while(dealerSum <= 17)
		{
			result = DistributeCard();
			System.out.println("ディーラーがもう一度カードを引きました");
			System.out.println("ディーラーに配られたカード[ " + result + "]");
			dealerCards.add(result);
			dealerSum = CalculationCardsSum(dealerCards);
			System.out.println("ディーラーのカードの合計は[" +  dealerSum + "]です");

			if(dealerSum > 21)
			{
				System.out.println("ディーラーはバーストしました");
				return;
			}
		}

		//差が小さいほうがが勝ち
		if(21 - playerSum < 21 - dealerSum)
		{
			System.out.println("あなたの勝ちです");
		}
		else
		{
			System.out.println("ディーラーの勝ちです");
		}
	}

	private static  int DistributeCard()
	{
		int result = 0;

		Random random =new Random();
		int rand = random.nextInt(13);

		// カード一覧
		String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

		if(rand == 0)
		{
				result = 1;
		}		//配られるカードがJ ~ K
		else if(rand == 11 || rand == 12 || rand == 13)
		{
			result = 10;
		}
		else
		{
			//System.out.println(result);
			result = Integer.parseInt(cards[rand]);
		}
		return result;
	}

	private static int CalculationCardsSum(List<Integer> cards)
	{
		int sum =0 ;

		for(int card : cards)
		{
			// Aを引いていた時
			if(card == 1 )
			{
				// 11として計算してバーストするときは1のまま計算
				if(sum + 11 > 21)
				{
					sum += 1; 
				}
				else 
				{
					// バーストしないときは11として計算
					sum += 11;
				}
			}
			else //A以外のカードのときはそのまま合計を計算する
			{
				sum += card;
			}
		}
		
		return sum;
	}
}
