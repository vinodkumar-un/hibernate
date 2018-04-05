package com.dp.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.dp.service.LoanApprover;

public class LoanApproverHandler implements InvocationHandler {
	private LoanApprover loanApprover;

	public LoanApproverHandler(LoanApprover loanApprover) {
		this.loanApprover = loanApprover;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret = null;

		System.out.println("log stmt: method : " + method.getName());
		ret = method.invoke(loanApprover, args);

		return ret;
	}

}
