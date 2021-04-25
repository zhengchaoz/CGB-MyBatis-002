package com.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.tedu.pojo.Emp;

// com.tedu.mapper.EmpMapper
public interface EmpMapper {

	public List<Emp> findAll();
	
	@Insert("insert into emp values(null, #{name}, #{job}, #{salary});")
	public int insert(Emp e);

}
