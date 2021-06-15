INSERT INTO "PUBLIC"."STUDENT" VALUES
(111, 'Abhishek', 'Vijay', '77XXXXXX'),
(222, 'Shayam', 'Sharma', '71XXXXXX');
INSERT INTO "PUBLIC"."DEPARTMENT" VALUES
('DSA', 'jaipur');
INSERT INTO "PUBLIC"."INSTRUCTOR" VALUES
(333, 'Mr Bean', 'Mr Karlos', 'Robert', '66XXXXXX', 'DSA'),
(444, 'Mr Charls', 'Mr Karlos', 'Robert', '61XXXXXX', 'DSA');
INSERT INTO "PUBLIC"."COURSE" VALUES
(555, 5, 'Basic Math', 'DSA', 333),
(666, 7, 'Advance Math', 'DSA', 444);
INSERT INTO "PUBLIC"."STUDENT_COURSE" VALUES
(555, 111),
(555, 222),
(666, 222),
(666, 111);