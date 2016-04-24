package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Datum;
import dto.FeedObjectsTerm;

import dto.IspitRok;
import dto.Predmet;
import dto.Student;
import dto.IspitniRok;
import dto.Odsek;


public class Project {
	Integer a;
	
	public String updateStudent(Connection connection, int studentId, String ime, String prezime, String adresa)throws Exception{
		try{
			String SQLStatement = "UPDATE student SET ime= '"+ime+"', prezime='"+prezime+"', adresa='"+adresa+"' WHERE id = "+studentId;
			System.out.println("u project.updatestudent()" + SQLStatement);
			
			PreparedStatement ps = connection.prepareStatement(SQLStatement);
			Integer a = ps.executeUpdate();
		}catch(Exception e){
			throw e;
		}
		return "vlada";
	}
	public String deleteStudent(Connection connection, int studentId)throws Exception{
		try{
			
			PreparedStatement ps = connection.prepareStatement("delete FROM student WHERE id = " +studentId);
			Integer a = ps.executeUpdate();
			System.out.println("hellooo");
			return a.toString();
			   
		}catch (Exception e){
			throw e;
			
		}
		
	}
	
	public ArrayList<FeedObjectsTerm> GetTerms(Connection connection) throws Exception

	{
		ArrayList<FeedObjectsTerm> feedData = new ArrayList<FeedObjectsTerm>();
		try
		{
			
			PreparedStatement ps = connection.prepareStatement("SELECT  id, date FROM terms ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			
				FeedObjectsTerm feedObject = new FeedObjectsTerm();
				
				feedObject.setDate(rs.getString("date"));
				
				
				feedObject.setId(rs.getInt("id"));
			
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	//************Svi studenti
	public ArrayList<Student> GetAllStudents(Connection connection) throws Exception
	{
		ArrayList<Student> feedData = new ArrayList<Student>();
		try
		{
			
			PreparedStatement ps = connection.prepareStatement("SELECT  * FROM student ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			
				Student feedObject = new Student();
				feedObject.setId(rs.getInt("id"));
				feedObject.setIme(rs.getString("ime"));
				feedObject.setPrezime(rs.getString("prezime"));
				feedObject.setGodinaStudija(rs.getInt("godina_studija"));
				feedObject.setOdsek(rs.getInt("odsek"));
				feedObject.setKredit(rs.getInt("kredit"));
				feedObject.setPass(rs.getString("pass"));
				feedObject.setAdresa(rs.getString("adresa"));
			
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<IspitniRok> GetAllTerms(Connection connection, int studentId) throws Exception
	{
		ArrayList<IspitniRok> feedData = new ArrayList<IspitniRok>();
		try
		{
		
			String sql = "select ispitni_rok.id, ispitni_rok.datum_pocetka, ispitni_rok.datum_zavrsetka, ispitni_rok.naziv_roka"
					+ " from ispitni_rok join ispit on ispitni_rok.id = ispit.rok and ispit.student ="+studentId +" group by ispitni_rok.id";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				IspitniRok feedObject = new IspitniRok();
				feedObject.setId(rs.getInt("id"));
				//pom = rs.getDate("datum_pocetka");
				feedObject.setDatumPocetka(rs.getDate("datum_pocetka"));
				//pom = rs.getDate("datum_zavrsetka").toString();
				feedObject.setDatumZavrsetka(rs.getDate("datum_zavrsetka"));
				feedObject.setNaziv(rs.getString("naziv_roka"));
				
				
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	//********* Buduci rokovi u narednih 5 meseci (na njima mogu da se prijavljuju ispiti
	public ArrayList<IspitniRok> GetFutureTerms(Connection connection) throws Exception
	{
		ArrayList<IspitniRok> feedData = new ArrayList<IspitniRok>();
		try
		{
		
			String sql = "select id, datum_pocetka, datum_zavrsetka, naziv_roka"
					+ " from ispitni_rok where datum_pocetka > now() and datum_pocetka < DATE_ADD(now(),  INTERVAL 5 MONTH)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				IspitniRok feedObject = new IspitniRok();
				feedObject.setId(rs.getInt("id"));
				//pom = rs.getDate("datum_pocetka").toString();
				feedObject.setDatumPocetka(rs.getDate("datum_pocetka"));
				//pom = rs.getDate("datum_zavrsetka").toString();
				feedObject.setDatumZavrsetka(rs.getDate("datum_zavrsetka"));
				feedObject.setNaziv(rs.getString("naziv_roka"));
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	//******** Polozeni predmeti u odredjenom roku
	public ArrayList<IspitRok> getPolozeniIspiti(Connection connection, int studentId, int rokId) throws Exception
	{
		ArrayList<IspitRok> feedData = new ArrayList<IspitRok>();
		try
		{
		
			String sql = "select predmet.naziv, predmet.profesor, ispit.datum, ispit.ocena from predmet "
					+ "join ispit on ispit.predmet = predmet.id "
					+ "and ispit.student = " + studentId+" and ispit.rok = "+rokId;
			//select predmet.naziv, ispit.ocena from predmet join ispit on ispit.predmet = predmet.id and ispit.student = 2256 and ispit.rok = 2;
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			
				IspitRok feedObject = new IspitRok();
				feedObject.setNazivPredmeta(rs.getString("naziv"));
				feedObject.setProfesor(rs.getString("profesor"));
				//pom = rs.getDate("datum").toString();
				feedObject.setDatum(rs.getDate("datum"));
				feedObject.setPolozio(rs.getInt("ocena"));
				
				
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	//***********Vraca sve predmete******************
	public ArrayList<Predmet> GetSvePredmete(Connection connection) throws Exception
	{
		ArrayList<Predmet> feedData = new ArrayList<Predmet>();
		try
		{
		
			String sql = "select id, naziv, profesor from predmet";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
			
				Predmet feedObject = new Predmet();
				feedObject.setId(rs.getInt("id"));
				
				feedObject.setNaziv(rs.getString("naziv"));
				feedObject.setProfesor(rs.getString("profesor"));
				
				
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public ArrayList<Predmet> getPredmetOdsek(Connection connection, int odsekId) throws Exception
	{
		ArrayList<Predmet> feedData = new ArrayList<Predmet>();
		try
		{
		
			String sql = "select id, naziv, profesor from predmet where odsek =" + odsekId;
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
			
				Predmet feedObject = new Predmet();
				feedObject.setId(rs.getInt("id"));
				
				feedObject.setNaziv(rs.getString("naziv"));
				feedObject.setProfesor(rs.getString("profesor"));
				
				
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//************Odsek
	public ArrayList<Odsek> getOdseci(Connection connection) throws Exception
	{
		ArrayList<Odsek> feedData = new ArrayList<Odsek>();
		try
		{
		
			String sql = "select id, naziv from odsek";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
			
				Odsek feedObject = new Odsek();
				feedObject.setId(rs.getInt("id"));
				
				feedObject.setNaziv(rs.getString("naziv"));
				
				
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public ArrayList<Datum> getDatume(Connection connection) throws Exception
	{
		ArrayList<Datum> feedData = new ArrayList<Datum>();
		try
		{
		
			String sql = "select datum from datum";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
			
				Datum feedObject = new Datum();
				
				
				feedObject.setDatum(rs.getDate("datum"));
				
				
				
			feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	

}
