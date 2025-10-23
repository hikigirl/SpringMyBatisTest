package com.test.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository @RequiredArgsConstructor
public class MyBatisDAOImpl implements MyBatisDAO {
	
	private final SqlSessionTemplate template;
	
	/*
		SqlSessionTemplate -> SQL 실행
		- SQL은 XML Mapper에 작성되어 있음
		
		int stat.executeUpdate(); (JDBC)
		- 반환값이 없는 쿼리
		- int template.insert()
		- int template.update()
		- int template.delete()
		
		ResultSet stat.executeQuery(); (JDBC)
		- 반환값이 있는 쿼리
		- template.selectOne()  : 결과셋의 레코드가 1개 = if (rs.next())
		- template.selectList() : 결과셋의 레코드가 N개 = while (rs.next())
		
	*/
	
	@Override
	public void m1() {
		
		//insert문
		//1. connection
		//2. sql
		//3. statement 
		//---------------- 여기까진 이미 완료
		
		//4. executeUpdate()
		template.insert("address.m1");
		
	}

	@Override
	public int m2(String seq) {
		//seq를 쿼리 매개변수로 설정하고 쿼리 날리기(오버로딩 되어있음)
		
		//SqlSessionTemplate.delete(String statement, Object parameter)
		//return: int The number of rows affected by the delete.
		
		//int result = template.delete("address.m2", seq);
		//return result;
		
		return template.delete("address.m2", seq); //성공하면 1, 실패하면 0 반환
	}

	@Override
	public int m3(Map<String, String> map) {
		
		//update(String Statement, Object Parameter)
		// Parameter에는 DTO, map, 등등 다 들어갈 수 있다.
		
		return template.update("address.m3", map);
	}

	@Override
	public int m4(AddressDTO dto) {
		
		return template.update("address.m4", dto);
	}

	@Override
	public String m5(String seq) {
		/*
			1. Connection
			2. SQL
			3. Statement 
			-------------------- 여기까진 완료
			4. executeQuery()
			5. ResultSet
			6. if(rs.next()){}
			7. rs.getString("name")
			8. return
		*/
		// SQL의 결과를 객체에 매핑
		return template.selectOne("address.m5", seq);
	}
	
	@Override
	public AddressDTO m6(String seq) {
		/*
			1. Connection
			2. SQL
			3. Statement 
			-------------------- 여기까진 완료
			4. executeQuery()
			5. ResultSet
			6. if(rs.next()){}
			7. rs.getString("name")
			8. AddressDTO
			9. dto.setName
			10. return dto
		*/
		// SQL의 결과를 객체에 매핑
		return template.selectOne("address.m6", seq);
	}
	
	@Override
	public List<String> m7() {
		/*
		1. Connection
		2. SQL
		3. Statement 
		-------------------- 여기까진 완료(다른곳에서)
		4. executeQuery()
		5. ResultSet
		6. List<String> names 
		7. while(rs.next()){}
		7. rs.getString("name")
		8. rs.getString("name")
		9. names.add(name)
		10. return names
	*/
		return template.selectList("address.m7");
	}
	
	@Override
	public List<AddressDTO> m8() {
		
		return template.selectList("address.m8");
	}
	
	@Override
	public List<AddressDTO> m9(Map<String, String> map) {
		return template.selectList("address.m9", map);
	}
	
	@Override
	public List<AddressDTO> m10(int age) {
		return template.selectList("address.m10", age);
	}
	
	@Override
	public List<AddressDTO> m11(String word) {
		return template.selectList("address.m11", word);
	}
	
	@Override
	public List<AddressDTO> m12(String gender) {
		return template.selectList("address.m12", gender);
	}
	
	@Override
	public List<AddressDTO> m13(AddressDTO dto) {
		return template.selectList("address.m13", dto);
	}
	
	@Override
	public List<InsaDTO> m14(ArrayList<String> buseo) {
		return template.selectList("address.m14", buseo);
	}
	
	@Override
	public void add(AddressDTO dto) {
		template.insert("address.add", dto);
	}
	
	@Override
	public String getSeq() {
		return template.selectOne("address.getSeq");
	}
	
	@Override
	public void addPoint(PointDTO pdto) {
		template.insert("address.addPoint", pdto);		
	}
	
	@Override
	public List<AddressPointDTO> m17() {
		return template.selectList("address.m17");
	}
	
	@Override
	public List<AddressDTO> m18() {
		return template.selectList("address.m18");
	}
	
	@Override
	public List<InsaDTO> m19() {
		return template.selectList("address.m19");
	}
}
