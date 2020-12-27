package com.imooc.services.impl;

import com.imooc.services.HiService;
import org.springframework.stereotype.Service;

@Service
public class HiServiceImpl implements HiService {
	@Override
	public void sayHi() {
		System.out.println("I am HiServiceImpl , sayHi");
	}

	@Override
	public void sayHiService() {
		System.out.println("I am HiServiceImpl , sayHiService");
	}
}
