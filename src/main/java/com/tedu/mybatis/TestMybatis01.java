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
		// 读取MyBatis的核心配置文件
		is = Resources.getResourceAsStream("mybatis-config.xml");
		// 通过上面配置文件信息获取SqlSessionFactory工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// 通过工厂对象获取SqlSession对象，打开与数据库的连接
		session = factory.openSession(true);// true 设置自动提交事务
	}

	@After
	public void close() throws IOException {
//		session.commit();// 手动提交事务
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
		int i = mapper.insert(new Emp(null, "大嘴", "厨子", 5200d));
		System.out.println(i);
	}

}




























