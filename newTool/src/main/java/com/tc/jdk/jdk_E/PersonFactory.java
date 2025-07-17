package com.tc.jdk.jdk_E;

public interface PersonFactory<P extends Person> {
	P create(String id, String name, String sex);

}
