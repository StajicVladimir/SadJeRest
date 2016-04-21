package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.ProjectManager;

import com.google.gson.Gson;

import dto.FeedObjectsHero;
import dto.FeedObjectsTerm;
import dto.Ispit;
import dto.Student;
import dto.ispitniRok;

@Path("/WebService")
public class FeedService {
	
	@GET
	@Path("/GetFeeds")
	@Produces("application/json")
	public String feed()
	{
		String feeds  = null;
		try 
		{
			ArrayList<FeedObjectsHero> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.GetFeeds();
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}
	
	@GET
	@Path("/GetTerms")
	@Produces("application/json")
	public String feedTerms()
	{
		String feeds  = null;
		try 
		{
			ArrayList<FeedObjectsTerm> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.GetTerms();
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}
	@GET
	@Path("/Students")
	@Produces("application/json")
	public String feedStudents()
	{
		String feeds  = null;
		try 
		{
			ArrayList<Student> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getAllStudents();
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}
	@GET
	@Path("/Students/{studentid}")
	@Produces("application/json")
	
	public String feedStudent(@PathParam ("studentid") int id)
	{	
		//@PathParam ("studentid") int id
		String feeds  = null;
		try 
		{	
			
			Student feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getStudent(id);
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}
	
	@GET
	@Path("/Rokovi/{studentid}")
	@Produces("application/json")
	
	public String feedRokovi(@PathParam ("studentid") int id)
	{	
		
		String feeds  = null;
		try 
		{	
			
			ArrayList<ispitniRok> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getAllTerms(id);
			
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}

	@GET
	@Path("/BuduciRokovi")
	@Produces("application/json")
	
	public String feedFutureRokovi()
	{	
		
		String feeds  = null;
		try 
		{	
			
			ArrayList<ispitniRok> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getFutureTerms();
			
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}
	//***********************************************
	@GET
	@Path("/RokIspiti/{studentid},{rokid}")
	@Produces("application/json")
	
	public String feedRokIspiti(@PathParam ("studentid") int studentid, @PathParam("rokid") int rokid)
	{	
		
		String feeds  = null;
		try 
		{	
			
			ArrayList<Ispit> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getPolozeniIspiti(studentid,rokid);
			
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return feeds;
	}
}
