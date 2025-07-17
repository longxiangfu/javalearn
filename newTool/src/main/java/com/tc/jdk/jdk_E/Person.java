package com.tc.jdk.jdk_E;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Person {
	private String id;
	private String name;
	private String sex;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public boolean equals(Object object) {
		if (object == null || getClass() != object.getClass()) return false;
		Person person = (Person) object;
		return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(sex, person.sex);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, sex);
	}

	@Override
	public String toString() {
		return "Person{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
