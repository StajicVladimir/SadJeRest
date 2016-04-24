package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;

import dao.Project;
import dto.Datum;
import dto.FeedObjectsTerm;
import dto.IspitRok;
import dto.Predmet;
import dto.Student;
import dto.IspitniRok;
import dto.Odsek;

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
	
	
	
	public ArrayList<IspitRok> getPolozeniIspiti(int studentId, int rokId)throws Exception {
		ArrayList<IspitRok> feeds = null;
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
	//***************** odsek
	public ArrayList<Odsek> getOdseci()throws Exception {
		ArrayList <Odsek> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.getOdseci(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public Odsek getOdsek(int odsekId)throws Exception{
		ArrayList <Odsek> odseci = getOdseci();
		
		
		for (Odsek odsek: odseci){
			if (odsek.getId() == odsekId){
				
				return odsek;
			}
			
		}
		return null;
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

	public ArrayList<Predmet> getPredmetiOdsek(int odsekId)throws Exception {
		ArrayList<Predmet> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.getPredmetOdsek(connection, odsekId);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<Datum> getDatume()throws Exception {
		ArrayList<Datum> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.getDatume(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
}
