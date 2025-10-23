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

select * from TBLINSA;

select * from tblAddress;
create sequence seqPoint;
create table tblPoint (
    seq number primary key,
    point number default 100 not null,
    aseq number not null references tblAddress(seq)
);

select * from tblPoint;

insert into tblPoint values(seqPoint.nextval, default, 2);

select
    a.seq, a.name, a.age, a.address, a.gender,
	p.seq as pseq, p.point, p.aseq
from tblAddress a
    left outer join tblPoint p on a.seq = p.aseq
order by a.seq asc;

delete from tbladdress where seq between 64 and 67;
commit;


select * from tblAddress a
    left outer join tblPoint p on a.seq = p.aseq;


--tblInsa <-> tblProject
create table tblProject (
    seq number primary key,
    name varchar2(100) not null,
    location varchar2(100) not null,
    num number not null references tblInsa(num) --fk, tblInsa의 직원번호
);
insert into tblProject values(1, '해외수출',  '서울', 1001);

insert into tblProject values(2, 'TV광고',    '부산', 1002);
insert into tblProject values(3, '고객홍보',  '울산', 1003);
insert into tblProject values(4, '자재매입',  '광주', 1004);
insert into tblProject values(5, '재고확보',  '대전', 1005);

insert into tblProject values(6, 'TV광고',    '부산', 1001);
insert into tblProject values(7, '고객홍보',  '울산', 1001);
commit;

select * from tblProject;
select * from tblInsa;


select
    i.num as inum,
    i.name as iname,
    i.buseo,
    i.jikwi,
    i.basicpay, --부모 테이블 5개
    p.seq,
    p.name as pname,
    p.num as pnum --자식 테이블 3개
from tblInsa i
left outer join tblProject p
    on i.num = p.num;