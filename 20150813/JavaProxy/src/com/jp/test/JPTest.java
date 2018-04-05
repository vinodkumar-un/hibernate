package com.jp.test;

import java.lang.reflect.Proxy;

import com.jp.entities.Account;
import com.jp.entities.SavingsAccount;
import com.jp.helper.AccountHelper;

public class JPTest {
	public static void main(String[] args) {
		Account account = new SavingsAccount();
		AccountHelper handler = new AccountHelper(account);

		/*Account proxy = (Account) Proxy.newProxyInstance(account.getClass()
				.getClassLoader(), new Class[] { Account.class }, handler);*/
		System.out.println("balance : " + account.getBalance());
	}
}





