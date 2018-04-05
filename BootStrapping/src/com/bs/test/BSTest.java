package com.bs.test;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;

import com.bs.dao.EventDao;
import com.bs.util.HibernateUtil;

public class BSTest {

	public static void main(String[] args) {
		EventDao eventDao = new EventDao();
		eventDao.saveEvent(2, new Date(), "Hibernate BootStrapping Meeting", 2,
				350);
		HibernateUtil.closeSessionFactory();
		/*String str = "balu";
		Encoder encode = Base64.getEncoder();
		 str =new String (encode.encode(str.getBytes()));
		 System.out.println(str);
		*/ 
		
	}

}
