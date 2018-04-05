package com.cs.test;

import com.cs.delegate.RegDelegate;
import com.cs.util.HibernateUtil;

public class CSTest {
	public static void main(String[] args) {
		RegDelegate delegate = new RegDelegate();
		delegate.reg();
		HibernateUtil.closeSessionFactory();
	}
}
