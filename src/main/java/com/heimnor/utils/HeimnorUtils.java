package com.heimnor.utils;

import java.util.ArrayList;
import java.util.List;

public class HeimnorUtils
{

	
	public static <T> List<T> toArrayList(T[] table){
		
		List<T> al = new ArrayList<T>();
		
		for(T obj: table) {
			al.add(obj);
		}
		
		return al;
		
	}
}
