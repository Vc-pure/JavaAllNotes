# ���ű�
drop table if exists dept;
create table dept(
    deptno int primary key,
    dname varchar(255),
    loc varchar(255)
);
insert into dept(deptno, dname, loc) values(10,'���۲�','����');
insert into dept(deptno, dname, loc) values(20,'�з���','�Ϻ�');
insert into dept(deptno, dname, loc) values(30,'������','����');
insert into dept(deptno, dname, loc) values(40,'ý�岿','����');
commit;
select * from dept;