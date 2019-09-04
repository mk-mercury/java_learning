package ヒットアンドブロー;

import java.util.Random;
import java.util.Scanner;

public class ヒットアンドブローチャレンジ {


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		
		int keycount=5;
		int randomNumber=rand.nextInt(10);
		int numberkeycount[]=new int[keycount]; for(int i=0;i<numberkeycount.length;i++){
			numberkeycount[i]=-1;
		}
		int keynumber[]=new int[keycount];
		
		String number="";
		int count=0;
		
		  for(int i=0;i<keycount;i++){
		    loop :	while(true){
					for(int j=0;j<numberkeycount.length;j++){
						if(numberkeycount[j]==randomNumber){
							randomNumber=rand.nextInt(10);
							continue loop;
						}	
					}
					break;
				}
				
				numberkeycount[i]=randomNumber;System.out.print("["+numberkeycount[i]+"]");
			}
		
		
		while(true){
			int hit=0;
			int blow=0;
			
				System.out.print(keycount+"桁の数字を入力してください。");
				 number=scan.nextLine();

		
		for(int i=0;i<number.length();i++){
			String s=number.substring(i,i+1);
			int figure=Integer.parseInt(s);
			keynumber[i]=figure;
			if(keynumber[i]==numberkeycount[i]){
				hit++;
			}else{
				for(int j=0; j<keycount;j++){
					if(keynumber[i]==numberkeycount[j]){
						blow++;
					}
			
				}
				
				}
		}
 
		 if(number.length()!=keycount){
			 
			 
			 continue;
		 }
		
		
		count++;
		randomNumber=rand.nextInt(keycount);
		
		if(hit!=keycount){
			System.out.println("ヒット："+hit+"個、　ブロー："+blow+"個");
			if(count%3==0){
				System.out.println("ヒント："+numberkeycount[randomNumber]+"が入ってるよ");
				System.out.println("");
			}

		}else{
			System.out.println("正解しました！"+count+"回目です。");
			break;
		}
		
		}
		scan.close();
	}

}