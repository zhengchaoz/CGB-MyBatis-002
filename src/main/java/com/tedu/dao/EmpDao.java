package com.tedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tedu.pojo.Emp;

public interface EmpDao {

	@Select("select * from emp;")
	List<Emp> selectAll();

}
