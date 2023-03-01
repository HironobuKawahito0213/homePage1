package fishing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * 釣りゲームの実行用メインメソッド。
 * 
 * @author 川人
 *
 */
public class Main {
	/**
	 * プレイ回数
	 */
	private static final int PLAY_COUNTER = 4;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		chooseFishingSpot(sc);
		playFishingGame(PLAY_COUNTER,sc);
		
	}
	/**
	 * 
	 * 
	 * @return inputText コンソールに入力された文字列
	 */
	public static String inputStringByConsole(Scanner sc) {
			String inputText = sc.nextLine();
			return inputText;
	}
	/**
	 * 釣り場を選択するメソッド。
	 */
	public static void chooseFishingSpot(Scanner sc) {
		Place pl = new Place();
		List<String> ls  = pl.getPlList();
		System.out.println("釣り場選択画面");
		for(int i=0;i<ls.size();i++) {
			System.out.println("["+i+"]"+ls.get(i));
		}
		System.out.println("選択したい釣り場の番号を入力し、Enterキーを押してください。");
		String inputText = inputStringByConsole(sc);
		boolean flg = false;
		for(int i=0;i<ls.size();i++) {
			String s = String.valueOf(i);
			if(inputText.equals(s)) {
				System.out.println(ls.get(i)+"が選択されました。");
				flg = true;
				break;
			}
		}
		if(flg==false) {
			System.out.println("デフォルトのtokyoBayを選択しました。");
		}
	}
	/**
	 * 
	 * 入力されたゲームのプレイ回数分、ゲームを繰り返す。
	 * 
	 * @param numbersOfPlays ゲームのプレイ回数。
	 */
	public static void playFishingGame(int numbersOfPlays,Scanner sc){
		FishList fl = new FishList();
		Map<String,Integer> mp = fl.getMp();
		List<Map.Entry<String,Integer>> ls = new ArrayList<>(mp.entrySet());
		int pointSum = 0;
		for(int i=0;i<numbersOfPlays;i++) {
			Collections.shuffle(ls);
			System.out.println("0-3を選択し、釣竿を投げてください。(デフォルト:0)");
			String s = inputStringByConsole(sc);
			boolean flg = false;
			for(int j=0;j<numbersOfPlays;j++) {
				String key = String.valueOf(j);
				if(s.equals(key)) {
					System.out.println(key+"番目の海から"+ls.get(j).getKey()+"を吊り上げました。"+ls.get(j).getKey()+"は"+ls.get(j).getValue()+"点です。");
					pointSum += ls.get(j).getValue();
					System.out.println("合計得点は"+pointSum+"です。");
					flg = true;
					break;
				}				
			}
			if(flg == false) {
				System.out.println("デフォルトの海から"+ls.get(0).getKey()+"を吊り上げました。"+ls.get(0).getKey()+"は"+ls.get(0).getValue()+"点です。");
				pointSum += ls.get(0).getValue();
				System.out.println("合計得点は"+pointSum+"です。");
				flg = true;
			}
			System.out.println();
		}
	}

}
