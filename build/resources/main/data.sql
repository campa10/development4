DROP TABLE public.student CASCADE;
CREATE TABLE IF NOT EXISTS student (
	id serial4 NOT NULL,
	studentname varchar(50) NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (id),
	CONSTRAINT students_studentname_key UNIQUE (studentname)
);

DROP TABLE public.course CASCADE;
CREATE TABLE IF NOT EXISTS course (
	id serial4 NOT NULL,
	coursename varchar(50) NOT NULL,
	CONSTRAINT course_pkey PRIMARY KEY (id),
	CONSTRAINT courses_coursename_key UNIQUE (coursename)
);

DROP TABLE public.enrollment CASCADE;
CREATE TABLE IF NOT EXISTS enrollment (
    id serial4 NOT NULL,
    studentname varchar(50) NOT NULL,
    courseid serial4 NOT NULL,
    CONSTRAINT enrollment_pkey PRIMARY KEY (id),
    CONSTRAINT enrollment_studentname_courseid_key UNIQUE (studentname, courseid),
    CONSTRAINT FK_enrollment_studentname FOREIGN KEY (studentname) REFERENCES student(studentname),
    CONSTRAINT FK_enrollment_courseid FOREIGN KEY (courseid) REFERENCES course(id)
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

DELETE FROM public.enrollment;
INSERT INTO public.enrollment (studentname, courseid) VALUES('student1', 1);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student1', 2);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student1', 3);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student2', 2);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student3', 3);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student4', 1);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student4', 3);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student5', 2);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student6', 1);
INSERT INTO public.enrollment (studentname, courseid) VALUES('student6', 2);
