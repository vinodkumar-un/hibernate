package com.jp.helper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.jp.entities.Account;

public class AccountHelper implements InvocationHandler {
	private Account account;

	public AccountHelper(Account account) {
		this.account = account;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("getBalance")) {
			System.out.println("goto database");
			System.out.println("fetching data...");
			System.out.println("set to original object");
			account.setBalance(10);
		}
		return method.invoke(account, args);
	}
}
