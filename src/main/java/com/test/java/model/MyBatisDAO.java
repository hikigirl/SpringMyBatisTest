package com.test.java.model;

import java.util.ArrayList;
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

	List<AddressDTO> m9(Map<String, String> map);

	List<AddressDTO> m10(int age);

	List<AddressDTO> m11(String word);

	List<AddressDTO> m12(String gender);

	List<AddressDTO> m13(AddressDTO dto);

	List<InsaDTO> m14(ArrayList<String> buseo);

	void add(AddressDTO dto);

	String getSeq();

	void addPoint(PointDTO pdto);

	List<AddressPointDTO> m17();

	List<AddressDTO> m18();

	List<InsaDTO> m19();

}
