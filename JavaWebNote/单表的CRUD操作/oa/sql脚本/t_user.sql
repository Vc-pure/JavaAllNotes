drop table if exists t_user;
create table t_user(
		id int PRIMARY KEY auto_increment,
		username varchar(255),
		password varchar(255)

);

insert into t_user(username,password) VALUES('admin','123456');
insert into t_user(username,password) VALUES('zhangsan','123456');
commit;
SELECT * from t_user;