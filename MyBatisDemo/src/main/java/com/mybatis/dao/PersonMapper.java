package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.model.Person;

@Mapper
public interface PersonMapper {

	@Insert("Insert into person(name,city,salary) values (#{name},#{city},#{salary})")
	public abstract Integer save(Person person);

	@Update("Update Person set name= #{name},city= #{city},salary= #{salary} where id=#{id}")
	public abstract void updatePerson(Person person);

	@Delete("Delete from Person where id=#{personId}")
	public abstract void deletePersonById(Integer personId);

	@Select("SELECT id, name,city,salary FROM person WHERE id = #{personId}")
	public abstract Person getPerson(Integer personId);

	@Select("Select * from person")
	public abstract List<Person> getAllPersons();
}
