package ブラックジャック;

import java.util.Random;
import java.util.Scanner;

public class ブラックジャックチャレンジ {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		
		String cardnumber[]={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String dealer[]={"","","","","",""};
		String you[]={"","","","","",""};
		
		int randomcard=rand.nextInt(13);
		int coin=100;
		
		
		while(true){
			for(int i=0;i<dealer.length;i++){
				System.out.println(you[i]);
			}
			for(int i=0;i<dealer.length;i++){
				System.out.println(dealer[i]);
			}
			System.out.println("コインは"+coin+"です。");
			coin-=10;
			System.out.println("コインを10払いました");
			for(int i=0;i<2;i++){
				randomcard=rand.nextInt(13);
				System.out.print("あなたに「"+cardnumber[randomcard]+"」が配られました。");
				you[i]=cardnumber[randomcard];
			
				
				randomcard=rand.nextInt(13);
				System.out.println("ディーラーに「"+cardnumber[randomcard]+"」が配られました。");
				dealer[i]=cardnumber[randomcard];
			}
			int yourpoint=0;
			int dealerpoint=0;
			int count=0;
			int NO=1;
			
			while(true){
				while(true){
					
						
				if(you[count].equals("A")){
					yourpoint+=11;
				}
				if(you[count].equals("2")){
					yourpoint+=2;
				}
				if(you[count].equals("3")){
					yourpoint+=3;
				}
				if(you[count].equals("4")){
					yourpoint+=4;
				}
				if(you[count].equals("5")){
					yourpoint+=5;
				}
				if(you[count].equals("6")){
					yourpoint+=6;
				}
				if(you[count].equals("7")){
					yourpoint+=7;
				}
				if(you[count].equals("8")){
					yourpoint+=8;
				}
				if(you[count].equals("9")){
					yourpoint+=9;
				}
				if(you[count].equals("10")){
					yourpoint+=10;
				}
				if(you[count].equals("J")){
					yourpoint+=10;
				}
				if(you[count].equals("Q")){
					yourpoint+=10;
				}
				if(you[count].equals("K")){
					yourpoint+=10;
					
				}
			switch(dealer[count]){		
			case "A":dealerpoint+=11; break;
			case "J":case "Q":case "K":	dealerpoint+=10; break;
			case "2":dealerpoint+=2; break;
			case "3":dealerpoint+=3; break;
			case "4":dealerpoint+=4; break;
			case "5":dealerpoint+=5; break;
			case "6":dealerpoint+=6; break;
			case "7":dealerpoint+=7; break;
			case "8":dealerpoint+=8; break;
			case "9":dealerpoint+=9; break;
			case "10":dealerpoint+=10; break;
				}
			
			count++;
			if(count!=1){
				break;
			}
		}
				//Aは１か１１の判定
				if(yourpoint>21){
					for(int i=0;i<count;i++){
						if(you[i].equals("A")){
								yourpoint-=10;
								you[i]="A(1)";
							}
						}
				}
				if(dealerpoint>21){
					for(int i=0;i<count;i++){
						if(dealer[i].equals("A")){
								dealerpoint-=10;
								dealer[i]="A(1)";
							}
						}
				}
				int countA=0;
				int count10=0;
				int comcountA=0;
				int comcount10=0;
				
				//Aと10点があるか判定
				for(int i=0;i<count;i++){
					if(you[i]==cardnumber[0]){
						countA++;
					}else if(you[i].equals(cardnumber[9])||you[i].equals(cardnumber[10])){
						count10++;
					}else if(you[i].equals(cardnumber[11])||you[i].equals(cardnumber[12])){
						count10++;
					}else{
						countA=0;
						count10=0;
					}
					
						if(dealer[i]==cardnumber[0]){
							comcountA++;
						}else if(dealer[i].equals(cardnumber[9])||dealer[i].equals(cardnumber[10])){
							comcount10++;
						}else if(dealer[i].equals(cardnumber[11])||dealer[i].equals(cardnumber[12])){
							comcount10++;
						}else{
							comcountA=0;
							comcount10=0;
						}
				}
				
				
				
				String reply="";//キーボード入力の変数
			
			if(NO==1){
				System.out.println("あなたの合計は"+yourpoint+"です。"+"ディーラーの合計は"+dealerpoint+"です。");
				
				System.out.print("カードを引きますか？(Y/N)");
				 reply=scan.nextLine();
				System.out.println("");
			}
			
			
			if(reply.equals("Y")){
				randomcard=rand.nextInt(13);
				System.out.println("あなたに"+cardnumber[randomcard]+"が配られました");
				you[count]=cardnumber[randomcard];
				
			}else if(dealerpoint<=17){
				randomcard=rand.nextInt(13);
				System.out.println("ディーラーに"+cardnumber[randomcard]+"が配られました");
				dealer[count]=cardnumber[randomcard];
				 NO=0;
				continue;
			}else//ブラックジャックの判定
				if(yourpoint==dealerpoint&&count==2&&countA==1&&count10==1&&(comcountA==0||comcount10==0)){
					System.out.println("あなたが"+yourpoint+"(ブラックジャック)  ディーラーが"+dealerpoint+"であなたの勝ちです");
					coin+=30;
					break;
				}else if(yourpoint==dealerpoint&&count==2&&(countA==0||count10==0)&&comcountA==1&&comcount10==1){
					System.out.println("あなたが"+yourpoint+"  ディーラーが"+dealerpoint+"(ブラックジャック)であなたの負けです");
					
					break;
				}else if(yourpoint==dealerpoint&&count==2&&countA==1&&count10==1&&comcountA==1&&comcount10==1){
					System.out.println("あなたが"+yourpoint+"(ブラックジャック)  ディーラーが"+dealerpoint+"(ブラックジャック)で引き分けです");
					coin+=10;
					break;
				}else if(yourpoint>dealerpoint&&count==2&&countA==1&&count10==1){
					System.out.println("あなたが"+yourpoint+"(ブラックジャック)  ディーラーが"+dealerpoint+"であなたの勝ちです");
					coin+=30;
					break;
				}else if(yourpoint<dealerpoint&&countA!=1&&count10!=1&&comcountA==1&&comcount10==1){
					System.out.println("あなたが"+yourpoint+"  ディーラーが"+dealerpoint+"(ブラックジャック)であなたの負けです");
					break;
				}else	//バーストの判定
					if(yourpoint>21){
						System.out.println(".*BUST*.");
						System.out.println("あなたが"+yourpoint+" ディーラーが"+dealerpoint+"で あなたの負けです");
						break;
					}else if(dealerpoint>21){
						System.out.println(".*BUST*.");
						System.out.println("あなたが"+yourpoint+" ディーラーが"+dealerpoint+"で あなたの勝ちです");
						coin+=20;
						break;
					}else if(yourpoint>dealerpoint){
				System.out.println("あなたが"+yourpoint+" ディーラーが"+dealerpoint+"であなたの勝ちです");
				coin+=20;
				break;
			}else if(yourpoint<dealerpoint){
				System.out.println("あなたが"+yourpoint+" ディーラーが"+dealerpoint+"であなたの負けです");
				
				break;
			}
		}
			
			//コインがあるかの判定
			if(coin<=0){
				System.out.println("コインがありません");
				break;
			}
			System.out.println("");
			 
		}
		
		scan.close();
		
	}

}