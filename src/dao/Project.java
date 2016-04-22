package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import dto.FeedObjectsTerm;
import dto.Ispit;
import dto.Predmet;
import dto.Student;
import dto.IspitniRok;


public class Project {
	Integer a;
	
	public String updateStudent(Connection connection, int studentId, String ime)throws Exception{
		try{
			String SQLStatement = "UPDATE student SET ime= '"+ime+"' WHERE id = "+studentId;
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
			System.out.println("u project.deleteStudent()");
			/*PreparedStatement preparedStatement = dbConnection.prepareStatement(deleteSQL);
preparedStatement.setInt(1, 1001);
// execute delete SQL stetement
preparedStatement.executeUpdate();
			 * */
			PreparedStatement ps = connection.prepareStatement("delete FROM student WHERE id = " +studentId);
			Integer a = ps.executeUpdate();
			System.out.println("hellooo");
			return a.toString();
			   
		}catch (Exception e){
			throw e;
			
		}
		
	}
	////OBRISATII!!!!!
	public ArrayList<FeedObjectsTerm> GetTerms(Connection connection) throws Exception

	{
		ArrayList<FeedObjectsTerm> feedData = new ArrayList<FeedObjectsTerm>();
		try
		{
			//String uname = request.getParameter("uname");
			//PreparedStatement ps = connection.prepareStatement("SELECT title,name, description,url FROM website ORDER BY id DESC");
			PreparedStatement ps = connection.prepareStatement("SELECT  id, date FROM terms ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				FeedObjectsTerm feedObject = new FeedObjectsTerm();
				
				feedObject.setDate(rs.getString("date"));
				//a = rs.getInt("id");
				
				feedObject.setId(rs.getInt("id"));
			/*feedObject.setTitle(rs.getString(1));
			feedObject.setName(rs.getString("name"));
			feedObject.setDescription(rs.getString("description"));
			feedObject.setUrl(rs.getString("url"));*/
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
			//String uname = request.getParameter("uname");
			//PreparedStatement ps = connection.prepareStatement("SELECT title,name, description,url FROM website ORDER BY id DESC");
			PreparedStatement ps = connection.prepareStatement("SELECT  * FROM student ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				Student feedObject = new Student();
				feedObject.setId(rs.getInt("id"));
				feedObject.setIme(rs.getString("ime"));
				feedObject.setPrezime(rs.getString("prezime"));
				feedObject.setGodinaStudija(rs.getInt("godina_studija"));
				feedObject.setOdsek(rs.getInt("odsek"));
				feedObject.setKredit(rs.getInt("kredit"));
				feedObject.setPass(rs.getString("pass"));
			/*feedObject.setTitle(rs.getString(1));
			feedObject.setName(rs.getString("name"));
			feedObject.setDescription(rs.getString("description"));
			feedObject.setUrl(rs.getString("url"));*/
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
		
			String sql = "select ispitni_rok.id, ispitni_rok.datum_pocetka"
					+ " from ispitni_rok join ispit on ispitni_rok.id = ispit.rok and ispit.student ="+studentId +" group by ispitni_rok.id";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				IspitniRok feedObject = new IspitniRok();
				feedObject.setId(rs.getInt("id"));
				pom = rs.getDate("datum_pocetka").toString();
				feedObject.setDate(pom);
				
				
				
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
		
			String sql = "select id, datum_pocetka from ispitni_rok where datum_pocetka > now() and datum_pocetka < DATE_ADD(now(),  INTERVAL 5 MONTH)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				IspitniRok feedObject = new IspitniRok();
				feedObject.setId(rs.getInt("id"));
				pom = rs.getDate("datum_pocetka").toString();
				feedObject.setDate(pom);
				
				
				
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
	public ArrayList<Ispit> getPolozeniIspiti(Connection connection, int studentId, int rokId) throws Exception
	{
		ArrayList<Ispit> feedData = new ArrayList<Ispit>();
		try
		{
		
			String sql = "select predmet.naziv, ispit.ocena from predmet "
					+ "join ispit on ispit.predmet = predmet.id "
					+ "and ispit.student = " + studentId+" and ispit.rok = "+rokId;
			//select predmet.naziv, ispit.ocena from predmet join ispit on ispit.predmet = predmet.id and ispit.student = 2256 and ispit.rok = 2;
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				Ispit feedObject = new Ispit();
				feedObject.setNazivPredmeta(rs.getString("naziv"));
				//pom = rs.getDate("datum").toString();
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
}
