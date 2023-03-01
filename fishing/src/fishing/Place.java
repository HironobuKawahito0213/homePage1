package fishing;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Place {
	private int tokyoBay;
	private int oskaBay;
	private int nagoyaBay;
	

	private List<String> ls = new ArrayList<String>();
	
	Place(){
		makePlaceList();
	}
	
	public int getTokyoBay() {
		return tokyoBay;
	}
	public void setTokyoBay(int tokyoBay) {
		this.tokyoBay = tokyoBay;
	}
	public int getOskaBay() {
		return oskaBay;
	}
	public void setOskaBay(int oskaBay) {
		this.oskaBay = oskaBay;
	}
	public int getNagoyaBay() {
		return nagoyaBay;
	}
	public void setNagoyaBay(int nagoyaBay) {
		this.nagoyaBay = nagoyaBay;
	}
	
	public List<String> getPlList() {
		return ls;
	}

	public void makePlaceList() {
		
		Field[] fields = Place.class.getDeclaredFields();
		
		for(Field field:fields) {
			
			field.setAccessible(true);
			
			String s = field.getName();
			
			if(!s.equals("ls")) {
				ls.add(s);
			}
		}
	}
	public void showPlaceList() {
		for(String place: ls){
			System.out.println(place);
		}
	}
}
