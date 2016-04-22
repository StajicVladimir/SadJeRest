package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;

import dao.Project;

import dto.FeedObjectsTerm;
import dto.Ispit;
import dto.Predmet;
import dto.Student;
import dto.IspitniRok;

public class ProjectManager {
	public String updateStudent(int id, String ime, String prezime, String adresa)throws Exception{
		//ArrayList <Student> students = getAllStudents();
		try{
			Database database= new Database();
		    Connection connection = database.Get_Connection();
			Project project= new Project();
			//System.out.println("hey");
		//ArrayList<Student> tmp = new ArrayList();
		
			return project.updateStudent(connection, id, ime, prezime, adresa);
			
			
		
		}catch(Exception e){
			throw e;
		}
	}
	
	public String deleteStudent(int studentId)throws Exception{
		ArrayList <Student> students = getAllStudents();
		String feeds = null;
		try{
			System.out.println("u try catch od project manager");
			Database database= new Database();
		    Connection connection = database.Get_Connection();
			Project project= new Project();
			
			for (Student student: students){
				if (student.getId() == studentId){
					feeds =project.deleteStudent(connection, studentId);
					
					
				}
			}
		}catch(Exception e){
			throw e;
		}
		return feeds;
	}
	public Student getStudent(int id)throws Exception{
		ArrayList <Student> students = getAllStudents();
		
		
		for (Student student: students){
			if (student.getId() == id){
				
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
	
	public ArrayList<IspitniRok> getAllTerms(int id)throws Exception {
		ArrayList<IspitniRok> feeds = null;
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
	
	public ArrayList<IspitniRok> getFutureTerms()throws Exception {
		ArrayList<IspitniRok> feeds = null;
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

	public ArrayList<Predmet> getSvePredmete()throws Exception {
		ArrayList<Predmet> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.GetSvePredmete(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
}
