package fishing;

/**
 * 
 * 釣りゲームの実行用メインメソッド。
 * 
 * @author 川人
 *
 */
public class Main {
	

	public static void main(String[] args) {
		Game gm = new Game(1);
		Fish fish = new Fish();
		fish.showFish();
		gm.chooseFishingSpot();
		gm.playFishingGame();
		
	}
	
	

}
