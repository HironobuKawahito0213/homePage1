package fishing;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishList {
	
	public static void makeFishList()  {
		List <String> ls = new ArrayList<String>();
		
		Map<String,Integer> fLs = new HashMap<>();
		
		Fish fish = new Fish();
		
		Field[] fields = Fish.class.getDeclaredFields();
		
		for(Field field: fields) {
			
			field.setAccessible(true);
			
			String s = field.getName();
			
			
			
			System.out.println(s);
			fLs.put(s, null);
		}
		
		
		
	}
}
