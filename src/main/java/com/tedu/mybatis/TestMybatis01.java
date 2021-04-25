package com.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tedu.mapper.EmpMapper;
import com.tedu.pojo.Emp;

public class TestMybatis01 {

	InputStream is = null;
	SqlSession session = null;

	@Before
	public void init() throws IOException {
		// ��ȡMyBatis�ĺ��������ļ�
		is = Resources.getResourceAsStream("mybatis-config.xml");
		// ͨ�����������ļ���Ϣ��ȡSqlSessionFactory��������
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// ͨ�����������ȡSqlSession���󣬴������ݿ������
		session = factory.openSession(true);// true �����Զ��ύ����
	}

	@After
	public void close() throws IOException {
//		session.commit();// �ֶ��ύ����
		session.close();
		is.close();
	}

	@Test
	public void testFindAll() {
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		List<Emp> emps = mapper.findAll();
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testInsert() {
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		int i = mapper.insert(new Emp(null, "����", "����", 5200d));
		System.out.println(i);
	}

}




























