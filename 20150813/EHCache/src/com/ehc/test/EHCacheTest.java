package com.ehc.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheTest {
	public static void main(String[] args) {
		CacheManager cacheManager = CacheManager
				.create("D:\\Work\\Hibernate\\Master\\20150813\\EHCache\\src\\ehcache.xml");
		Cache cache = cacheManager.getCache("mycache");
		cache.put(new Element("key1", "value1"));

		Element elem = cache.get("key1");
		System.out.println(elem.getObjectValue().toString());
	}
}
