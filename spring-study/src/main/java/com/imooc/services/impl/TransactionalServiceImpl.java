package com.imooc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class TransactionalServiceImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public String testTrans() {
		Map<String, Object> queryForMap = jdbcTemplate.queryForMap("select * from people;");
		for (Map.Entry<String, Object> entry : queryForMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return "testTrans";
	}

}
