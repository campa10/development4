
DROP TABLE public.student;
CREATE TABLE IF NOT EXISTS student (
	id serial4 NOT NULL,
	studentname varchar(50) NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (id),
	CONSTRAINT students_studentname_key UNIQUE (studentname)
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
INSERT INTO public.student (studentname) VALUES('student1');
INSERT INTO public.student (studentname) VALUES('student2');
INSERT INTO public.student (studentname) VALUES('student3');
INSERT INTO public.student (studentname) VALUES('student4');
INSERT INTO public.student (studentname) VALUES('student5');
INSERT INTO public.student (studentname) VALUES('student6');
INSERT INTO public.student (studentname) VALUES('student7');
INSERT INTO public.student (studentname) VALUES('student8');
