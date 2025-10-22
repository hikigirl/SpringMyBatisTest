# MyBatisTest

## Java(Spring)와 DB 연동

- new - spring legacy project - spring mvc project
- project name: `MyBatisTest`
- root package: `com.test.java`

---

#### 자바 버전과 pom.xml 수정

- 프로젝트 우클릭 -> Project Facets -> Java 11
- properties 태그에 있는 java-version 11
- 그 아래 스프링 버전 5.0.7.RELEASE로
- 맨 아래쪽 plugin 태그 -> maven plugin 내부
  - configuration 태그 내부 source, target 내부 11로 변경

#### DB작업

- JetBrains Datagrip 설치해보기(dbeaver같은 툴임)
- 프로젝트 루트에 `script.sql` 생성

#### MyBatis 세팅

- `root-context.xml`

---

#### 파일, 패키지

##### src/main/java - 구현용
- com.test.java(root)
- .controller
  - `MyBatisController.java`
- .model
  - `MyBatisDAO.java`(I)
  - `MyBatisDAOImpl.java`(C)
  - `AddressDTO.java`
- views
  - `result.jsp`
  - `list.jsp`
  - `add.jsp`

##### src/test/java - 단위테스트용
- com.test.java.model
  - `CommonsDBCPTests.java` : JUnit Test Case로 만들기(JUnit4 버전)