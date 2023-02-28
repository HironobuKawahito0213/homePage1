package fishing;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FishList {
	
	public static void makeFishList()  {
		
		Map<String,Integer> fLs = new HashMap<>();
		
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
			fLs.put(s, price);
		}
		
		
		
	}
}
