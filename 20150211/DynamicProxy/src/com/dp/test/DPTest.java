package com.dp.test;

import java.lang.reflect.Proxy;

import com.dp.handler.LoanApproverHandler;
import com.dp.service.HomeLoanApprover;
import com.dp.service.LoanApprover;

public class DPTest {
	public static void main(String[] args) {
		LoanApprover loanApprover = new HomeLoanApprover();
		LoanApproverHandler lah = new LoanApproverHandler(loanApprover);

		LoanApprover proxy = (LoanApprover) Proxy.newProxyInstance(loanApprover
				.getClass().getClassLoader(),
				new Class[] { LoanApprover.class }, lah);
		System.out.println("Proxy : " + proxy.getClass().getName());

		System.out.println("Approved : ? " + proxy.approveLoan(1));
	}
}
