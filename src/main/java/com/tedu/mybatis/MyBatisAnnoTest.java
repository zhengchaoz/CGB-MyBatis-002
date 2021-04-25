package com.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tedu.dao.EmpDao;
import com.tedu.pojo.Emp;

public class MyBatisAnnoTest {

	private InputStream in;
	private SqlSession sqlSession;
	private EmpDao dao;

	@Before
	public void init() throws IOException {
		in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(in);
		sqlSession = factory.openSession();
		dao = sqlSession.getMapper(EmpDao.class);
	}

	@After
	public void close() throws IOException {
		sqlSession.commit();
		sqlSession.close();
		in.close();
	}

	@Test
	public void findAll() throws IOException {
		List<Emp> emps = dao.selectAll();
		emps.forEach(System.out::println);
	}

}
