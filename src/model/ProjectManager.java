package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;

import dao.Project;
import dto.FeedObjectsHero;
import dto.FeedObjectsTerm;
import dto.Ispit;
import dto.Student;
import dto.ispitniRok;

public class ProjectManager {
	
	
	public Student getStudent(int id)throws Exception{
		ArrayList <Student> students = getAllStudents();
		
		//ArrayList<Student> tmp = new ArrayList();
		for (Student student: students){
			if (student.getId() == id){
				//tmp.add(student);
				return student;
			}
			
		}
		return null;
	}
	public ArrayList<Student> getAllStudents()throws Exception {
		ArrayList<Student> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetAllStudents(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<ispitniRok> getAllTerms(int id)throws Exception {
		ArrayList<ispitniRok> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetAllTerms(connection, id);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<ispitniRok> getFutureTerms()throws Exception {
		ArrayList<ispitniRok> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetFutureTerms(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	public ArrayList<FeedObjectsTerm> GetTerms()throws Exception {
		ArrayList<FeedObjectsTerm> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetTerms(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<FeedObjectsHero> GetFeeds()throws Exception {
		ArrayList<FeedObjectsHero> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetFeeds(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<Ispit> getPolozeniIspiti(int studentId, int rokId)throws Exception {
		ArrayList<Ispit> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.getPolozeniIspiti(connection, studentId, rokId);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
}
