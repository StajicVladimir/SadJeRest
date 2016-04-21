package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.FeedObjects;
import dto.FeedObjectsHero;
import dto.FeedObjectsTerm;
import dto.Student;
import dto.ispitniRok;


public class Project {
	Integer a;
	
	public ArrayList<FeedObjectsHero> GetFeeds(Connection connection) throws Exception
	{
		ArrayList<FeedObjectsHero> feedData = new ArrayList<FeedObjectsHero>();
		try
		{
			//String uname = request.getParameter("uname");
			//PreparedStatement ps = connection.prepareStatement("SELECT title,name, description,url FROM website ORDER BY id DESC");
			PreparedStatement ps = connection.prepareStatement("SELECT  id, name FROM heroes ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				FeedObjectsHero feedObject = new FeedObjectsHero();
				
				feedObject.setName(rs.getString("name"));
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
	
	public ArrayList<ispitniRok> GetAllTerms(Connection connection, int rokId) throws Exception
	{
		ArrayList<ispitniRok> feedData = new ArrayList<ispitniRok>();
		try
		{
		
			String sql = "select rok.id, rok.datum from rok join ispit on rok.id = ispit.rok and ispit.student ="+rokId +" group by rok.id";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String pom;
			while(rs.next())
			{
			//FeedObjects feedObject = new FeedObjects();
				ispitniRok feedObject = new ispitniRok();
				feedObject.setId(rs.getInt("id"));
				pom = rs.getDate("datum").toString();
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
}
