package com.geekq.nettyrpc.service.impl;

import com.geekq.nettyrpc.service.ITest;

public class TestImpl implements ITest {

	@Override
	public String getMessage() {
		
		return "hello";
	}

}
