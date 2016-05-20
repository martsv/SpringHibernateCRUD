CREATE TABLE test.User (
    id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25) DEFAULT NULL,
    age INT DEFAULT NULL,
    isAdmin BOOLEAN DEFAULT NULL,
    createdDate DATE DEFAULT NULL
);

insert into test.User (id, name, age, isAdmin, createdDate)
values (1, 'bill', 25, 1, '2011-01-10');
insert into test.User (id, name, age, isAdmin, createdDate)
values (2, 'john', 44, 0, '2011-04-04');
insert into test.User (id, name, age, isAdmin, createdDate)
values (3, 'fred', 18, 0, '2012-07-12');
insert into test.User (id, name, age, isAdmin, createdDate)
values (4, 'lisa', 21, 0, '2011-11-12');
insert into test.User (id, name, age, isAdmin, createdDate)
values (5, 'bart', 33, 0, '2015-01-31');
insert into test.User (id, name, age, isAdmin, createdDate)
values (6, 'bender', 38, 1, '2012-10-10');
insert into test.User (id, name, age, isAdmin, createdDate)
values (7, 'lila', 28, 1, '2011-01-10');
insert into test.User (id, name, age, isAdmin, createdDate)
values (8, 'fry', 41, 1, '2016-02-15');
insert into test.User (id, name, age, isAdmin, createdDate)
values (9, 'doctor', 35, 0, '2014-12-31');
insert into test.User (id, name, age, isAdmin, createdDate)
values (10, 'anna', 23, 0, '2013-02-24');
insert into test.User (id, name, age, isAdmin, createdDate)
values (11, 'maria', 26, 0, '2012-05-05');
insert into test.User (id, name, age, isAdmin, createdDate)
values (12, 'isabella', 37, 0, '2014-08-02');
insert into test.User (id, name, age, isAdmin, createdDate)
values (13, 'gomer', 46, 0, '2015-09-03');
insert into test.User (id, name, age, isAdmin, createdDate)
values (14, 'steve', 55, 0, '2011-04-15');
insert into test.User (id, name, age, isAdmin, createdDate)
values (15, 'mark', 22, 0, '2012-05-16');
insert into test.User (id, name, age, isAdmin, createdDate)
values (16, 'sergey', 40, 0, '2013-06-17');
insert into test.User (id, name, age, isAdmin, createdDate)
values (17, 'ilon', 35, 0, '2014-07-18');
insert into test.User (id, name, age, isAdmin, createdDate)
values (18, 'james', 60, 0, '2015-08-19');
insert into test.User (id, name, age, isAdmin, createdDate)
values (19, 'larry', 57, 0, '2011-12-04');
insert into test.User (id, name, age, isAdmin, createdDate)
values (20, 'jeff', 54, 0, '2014-03-08');
