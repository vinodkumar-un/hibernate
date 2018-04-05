package com.eh.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {
	public static void main(String[] args) throws CacheException,
			FileNotFoundException {
		CacheManager cmanager = CacheManager
				.create(new FileInputStream(
						new File(
								"D:\\Work\\Hibernate\\Master\\20150211\\EHCache\\src\\ehcache.xml")));
		Cache mycache = cmanager.getCache("mycache");

		mycache.put(new Element(1, "John"));
		mycache.put(new Element(2, "Raju"));

		String name = (String) mycache.get(1).getObjectValue();

		System.out.println(name);
	}
}
