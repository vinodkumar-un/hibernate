package com.bs.util;

import java.util.Base64;
import java.util.Base64.Decoder;

public class Decode {

	public static String decode(String str){
		
		Decoder dc = Base64.getDecoder();
		str = new String(dc.decode(str.getBytes()));
		return str;
	}
}
