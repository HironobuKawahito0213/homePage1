package fishing;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FishList {

	private Map<String,Integer> mp = new HashMap<>();
	
	
	FishList(){
		makeFishList();
	}
	
	public Map<String, Integer> getMp() {
		return mp;
	}

	private void makeFishList()  {
		
		Fish fish = new Fish();
		
		Field[] fields = Fish.class.getDeclaredFields();
		
		for(Field field: fields) {
			
			field.setAccessible(true);
			
			String s = field.getName();
			
			//初期化してなかった。
			int price  = 0;
			try {
				price = (int) field.get(fish);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			mp.put(s, price);
		}
		
	}
	public void showFishList() {
		for(Map.Entry<String,Integer> entry:mp.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
}
