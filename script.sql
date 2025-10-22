--계정 생성(system 계정으로 실행)
alter session set "_ORACLE_SCRIPT" = true;
create user spring identified by java1234;
grant connect, resource, dba to spring;
alter user spring default tablespace users;

select * from tabs;

create table tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null,
    gender char(1) not null
);
create sequence seqAddress;
select * from tblAddress;
insert into tblAddress
    values (seqAddress.nextval, '홍길동', 20, '서울시 강남구 대치동', 'm');
insert into tblAddress
    values (seqAddress.nextval, '강아지', 30, '강아지마을', 'm');
insert into tblAddress
    values (seqAddress.nextval, '고양이', 27, '고양이마을', 'f');
commit;