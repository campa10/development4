
DROP TABLE public.student;
CREATE TABLE IF NOT EXISTS student (
	id serial4 NOT NULL,
	courseid int4 NOT NULL,
	studentname varchar(50) NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (id),
	CONSTRAINT students_studentname_key UNIQUE (courseid, studentname)
);

DROP TABLE public.course;
CREATE TABLE IF NOT EXISTS course (
	id serial4 NOT NULL,
	coursename varchar(50) NOT NULL,
	CONSTRAINT course_pkey PRIMARY KEY (id),
	CONSTRAINT courses_coursename_key UNIQUE (coursename)
);

DELETE FROM public.course;
INSERT INTO public.course (coursename) VALUES('course1');
INSERT INTO public.course (coursename) VALUES('course2');
INSERT INTO public.course (coursename) VALUES('course3');
INSERT INTO public.course (coursename) VALUES('course4');
INSERT INTO public.course (coursename) VALUES('course5');

DELETE FROM public.student;
INSERT INTO public.student (courseid, studentname) VALUES(1, 'student1');
INSERT INTO public.student (courseid, studentname) VALUES(2, 'student1');
INSERT INTO public.student (courseid, studentname) VALUES(3, 'student1');
INSERT INTO public.student (courseid, studentname) VALUES(1, 'student2');
INSERT INTO public.student (courseid, studentname) VALUES(2, 'student2');
INSERT INTO public.student (courseid, studentname) VALUES(3, 'student');
INSERT INTO public.student (courseid, studentname) VALUES(1, 'student3');
INSERT INTO public.student (courseid, studentname) VALUES(2, 'student3');
INSERT INTO public.student (courseid, studentname) VALUES(3, 'student3');

