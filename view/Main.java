package view;

import java.util.Scanner;

/**
 * 
 * @author 川人
 *
 */
public class Main {

	public static void main(String[] args) {
		Movement mv = new Movement();
		mv.display();
		
		/**
		 * ゲームを続行するか判別するフラグ
		 */
		boolean flg = false;
		
		/**
		 * 駒の現在の位置
		 */
		int currentPiece = mv.getPiecePlace();
		
		/**
		 * ゴールの位置
		 */
		int goal = mv.getGoal();
		
		/**
		 * コンソールから入力されたメッセージ
		 */
		String msg = "";
		
		while(true) {
			if(currentPiece < goal) {
				while(flg == false) {
					System.out.println("このゲームを継続しますか？続けるならy/終わるならnを入力してください。");
					Scanner sc1 = new Scanner(System.in);
			        msg = sc1.nextLine();
			        if(msg.equals("y")) {
			        	flg = true;
			        }
			        else if(msg.equals("n")) {
			        	System.out.println("ゲームを終了します。");
			        	System.out.println();
			        	flg = true;
			        }
			        else {
			        	System.out.println("yまたはnのどちらかを入力してください。");
			        	System.out.println();
			        }
				}
				
				if(msg.equals("y")) {
					mv.throwDice();
					mv.moveSpace();
					//ゴールにつき次第、ゴール判定を行う。
					currentPiece = mv.getPiecePlace();
					if(currentPiece < goal) {
						mv.doEvent();
						mv.moveSpace();
						currentPiece = mv.getPiecePlace();
						flg = false;
					}
				}
			}
			else {
				System.out.println("ゴールおめでとう。クリアです。");
				break;
			}
		}
		
		
	}

}
