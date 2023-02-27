package view;

import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author 川人
 *
 */
public class Movement {
	
	//ctrl shift + で画面拡大ができる。
	
	/**
	 * 駒の現在位置を表します。
	 */
	private int piecePlace = 0;
	
	/**
	 * サイコロの出た目を表します。
	 */
	private int diceNum;
	/**
	 * 入力されたメッセージを表します。
	 */
	private String inMessage;
	
	/**
	 * 出力するメッセージを表します。
	 */
	private String outMessage;
	
	/**
	 * すごろくのゴールの位置を表します。
	 */
	final int goal = 10;
	
	/**
	 * こんそーる入力を待ち、メッセージを入力する。
	 * @param str 文字列
	 */
	private void inputMessage(String str) {
		System.out.println(str);

        Scanner sc1 = new Scanner(System.in);
        inMessage = sc1.nextLine();
        
	}
	
	/**
	 * 現在のすごろくの盤面をコンソール画面に表示する。
	 */
	public void display() {
		for(int i=0;i<piecePlace*2+5;i++) {
			System.out.print(" ");
		}
		System.out.println("P");
		System.out.println("     _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("     0 1 2 3 4 5 6 7 8 9 10");
		System.out.println("start                     goal");
		System.out.println();
	}
	/**
	 * ダイスを投げ、1－3の値を返す。
	 */
	public void throwDice() {
		outMessage = "Enterを押してください。サイコロを投げます。";
		inputMessage(outMessage);
		Random rand = new Random();
	    diceNum = rand.nextInt(3) + 1;
	    String sNum = String.valueOf(diceNum);
	    System.out.println(sNum + "が出ました。");
		
	}
	/**
	 * 入力された値分、駒の現在位置を移動させる。
	 */
	public void moveSpace() {
		piecePlace += diceNum;
		if(piecePlace >goal) {
			piecePlace = goal;
		}
		display();
	}
	/**
	 * 止まったマスのイベントを行う。
	 */
	public void doEvent() {
		outMessage = "イベントが発生しました！！！ Enterを押してください。";
		inputMessage(outMessage);
		Random rand = new Random();
	    diceNum = rand.nextInt(2) + -1;
	    String sNum = String.valueOf(diceNum);
	    if(diceNum == 0) {
	    	System.out.println("おじいさんがでました。特に何も起こりません");
	    }else {
	    	System.out.println("毒蛇が出ました。驚いたため、"+sNum+"マス分後退します。");
	    }
	    System.out.println();
	}
	/**
	 * piecePlaceのゲッター。
	 * @return piecePlace 駒の現在位置
	 */
	public int getPiecePlace() {
		return piecePlace;
	}
	/**
	 * goalのゲッター。
	 * @return　goal ゴールの位置
	 */
	public int getGoal() {
		return goal;
	}
	
	
}

