package com.jcg.hibernate.crud.operations;

import java.util.List;

import org.apache.log4j.Logger;

public class AppMain {

	//public final static Logger logger = Logger.getLogger(AppMain.class);

	public static void main(String[] args) {
		List<Student>viewStudents = DbOperations.displayRecords();
		if(viewStudents != null & viewStudents.size() > 0) {
			for(Student studentObj : viewStudents) {
				//logger.info(studentObj.toString());
				System.out.println(studentObj);
			}
		}
		//System.exit(0);
	}
}