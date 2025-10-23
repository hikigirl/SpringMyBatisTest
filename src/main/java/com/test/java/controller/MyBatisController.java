package com.test.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.java.model.AddressDTO;
import com.test.java.model.AddressPointDTO;
import com.test.java.model.InsaDTO;
import com.test.java.model.MyBatisDAO;
import com.test.java.model.PointDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyBatisController {
	
	//의존주입
	private final MyBatisDAO dao;
	
	@GetMapping("/result.do")
	public String test() {
		
		System.out.println(dao != null);
		
		return "result"; //result.jsp 호출
	}
	
	// 스프링(java) -> SQL 실행(MyBatis 사용) -> DB(Oracle)
	
	//반환값X, 인자값X
	@GetMapping("/m1.do")
	public String m1() {
		
		dao.m1();
		
		return "result";
	}

	//반환값X, 인자값O(1개)
	@GetMapping("/m2.do")
	public String m2(Model model, @RequestParam("seq") String seq) {
		//-m2.do?seq=1
		
		int result = dao.m2(seq);
		model.addAttribute("result", result);
		
		return "result";
	}
	
	//반환값X, 인자값O(여러개) - Map 이용
	@GetMapping("/m3.do")
	public String m3(Model model) {
		//update
		//2,아무개,20,서울시 강남구 대치동,m
		
		//DTO or Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", "2");
		map.put("age", "21");
		map.put("address", "경기도 광주시");
		
		int result = dao.m3(map);
		model.addAttribute("result", result);
		
		return "result";
	}
	
	//반환값X, 인자값O(여러개) - DTO 이용
	@GetMapping("/m4.do")
	public String m4(Model model) {
		//update
		//2,아무개,20,서울시 강남구 대치동,m
		
		//DTO or Map
		AddressDTO dto = new AddressDTO(); //여기도 DI 해야하는건지...
		dto.setSeq("2");
		dto.setAge(22);
		dto.setAddress("서울시 강남구 압구정동");
		
		int result = dao.m4(dto);
		model.addAttribute("result", result);
		
		return "result";
	}
	
	//select문
	//반환값O - 원자값(1행 1열)
	@GetMapping("/m5.do")
	public String m5(Model model, @RequestParam("seq") String seq) {
		//m5.do?seq=2 -> 이름 반환
		String name = dao.m5(seq);
		
		model.addAttribute("name", name);
		
		return "result";
	}
	
	//반환값O - 레코드 한줄 반환(1행 n열)
	@GetMapping("/m6.do")
	public String m6(Model model, @RequestParam("seq") String seq) {
		//m5.do?seq=2 -> 이름 반환
		AddressDTO dto = dao.m6(seq);
		
		model.addAttribute("dto", dto);
		
		return "result";
	}
	//반환값O - 레코드 n개 반환(n행 1열)
	@GetMapping("/m7.do")
	public String m7(Model model) {
		
		//List<String> names
		List<String> names = dao.m7();
		
		model.addAttribute("names", names);
		return "list";
	}
	//반환값O - 레코드 n개 반환(n행 n열)
	@GetMapping("/m8.do")
	public String m8(Model model) {
		
		//List<AddressDTO> list
		List<AddressDTO> list = dao.m8();
		
		model.addAttribute("list", list);
		return "list";
	}
	
	//검색 기능 - mybatis 바인딩 표현식 및 XML에서 작성하는 쿼리 관련
	@GetMapping("/m9.do")
	public String m9(Model model, String column, String word) {
		// select * from tblAddress where name = '홍길동'
		// select * from tblAddress where gender = 'm'
		
		//http://localhost:8080/mybatis/m9.do?column=name&word=고양이
		//http://localhost:8080/mybatis/m9.do?column=gender&word=m
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		
		List<AddressDTO> list = dao.m9(map);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	
	@GetMapping("/m10.do")
	public String m10(Model model) {
		
		int age=25;
		
		//List<AddressDTO> list
		List<AddressDTO> list = dao.m10(age);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/m11.do")
	public String m11(Model model, String word) {
		// select * from tblAddress where address like '%대치동%';
		
		//http://localhost:8080/mybatis/m11.do?word=대치동
		
		List<AddressDTO> list = dao.m11(word);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/m12.do")
	public String m12(Model model, String gender) {
		
		// mybatis/m12.do?gender=m
		// mybatis/m12.do?gender=f
		// mybatis/m12.do?gender=all
		
		List<AddressDTO> list = dao.m12(gender);
		
		model.addAttribute("list", list);
		return "list";
	}
	//좀 더 복잡한 검색
	@GetMapping("/m13.do")
	public String m13(Model model, AddressDTO dto) {
		
		// where age = 20
		// where gender = 'm'
		// where address like '%대치동%'
		// where age = 20 and gender = 'm'
		// 등등등... 주소, 나이, 성별을 복합 검색
		
		//m13.do?age=20
		//m13.do?age=20&gender=m
		
		List<AddressDTO> list = dao.m13(dto);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	//좀 더 복잡한 검색 2
	@GetMapping("/m14.do")
	public String m14(Model model) {
		
		// where buseo = '영업부' or buseo = '총무부' 
		
		ArrayList<String> buseo = new ArrayList<String>();
		buseo.add("영업부");
		buseo.add("총무부");
		buseo.add("개발부");
		
		List<InsaDTO> ilist = dao.m14(buseo);
		
		model.addAttribute("ilist", ilist);
		return "list";
	}
	
	@GetMapping("/m15.do")
	public String m15(Model model) {
		//1. tblAddress에 insert
		//2. tblPoint에 insert
		AddressDTO dto = new AddressDTO();
		dto.setName("고슴도치");
		dto.setAge(300);
		dto.setGender("f");
		dto.setAddress("바닷속");
		dao.add(dto);
		
		//방금 추가한 Address -> point 추가
		
		//select max(seq) from tblAddress
		String seq = dao.getSeq();
		
		PointDTO pdto = new PointDTO();
		pdto.setPoint(200);
		pdto.setAseq(seq);
		
		//insert
		dao.addPoint(pdto);
		
		return "result";
	}
	
	@GetMapping("/m16.do")
	public String m16(Model model) {
		//1. tblAddress에 insert
		//2. tblPoint에 insert
		AddressDTO dto = new AddressDTO();
		dto.setName("멸치");
		dto.setAge(300);
		dto.setGender("f");
		dto.setAddress("바닷속");
		dao.add(dto);
		
		//방금 추가한 Address -> point 추가
		
		PointDTO pdto = new PointDTO();
		pdto.setPoint(500);
		
		//insert
		dao.addPoint(pdto);
		
		return "result";
	}
	
	//조인
	@GetMapping("/m17.do")
	public String m17(Model model) {
		
		List<AddressPointDTO> list = dao.m17();
		
		//jsp에게 넘기지 않고 로그로 확인
		return "result";
	}
	//조인 -> 다른 방식
	@GetMapping("/m18.do")
	public String m18(Model model) {
		
		List<AddressDTO> alist = dao.m18();
		
		model.addAttribute("alist", alist);
		return "list";
	}
	//조인 -> 다른 방식(1:N 관계)
	@GetMapping("/m19.do")
	public String m19(Model model) {
		
		List<InsaDTO> ilist = dao.m19();
		
		model.addAttribute("ilist", ilist);
		return "list";
	}
}
