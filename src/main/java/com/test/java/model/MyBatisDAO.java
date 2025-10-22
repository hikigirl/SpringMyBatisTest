package com.test.java.model;

import java.util.List;
import java.util.Map;

public interface MyBatisDAO {

	void m1();

	int m2(String seq);

	int m3(Map<String, String> map);

	int m4(AddressDTO dto);

	String m5(String seq);

	AddressDTO m6(String seq);

	List<String> m7();

	List<AddressDTO> m8();

}
