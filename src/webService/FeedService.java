package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ProjectManager;

import com.google.gson.Gson;


import dto.FeedObjectsTerm;
import dto.Ispit;
import dto.Predmet;
import dto.Student;
import dto.IspitniRok;

@Path("/WebService")
public class FeedService {
	
	@PUT
	@Path ("/Students/{studentid}/{ime}")
	@Produces("application/json")
	public String updateStudent(@PathParam ("studentid") int studentId, @PathParam("ime") String ime){
		String feeds  = null;
		try 
		{	
			
			String feedData = null;
			ProjectManager projectManager= new ProjectManager();
			System.out.println("hey");
			feedData = projectManager.updateStudent(studentId, ime);
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return feeds;
	}
	@DELETE
	@Path("/Students/{studentid}")
	@Produces ("application/json")
	public String deleteStudent(@PathParam ("studentid") int studentId){
		String feeds = null;
		try{
			System.out.println("evo me");
			ProjectManager projectManager=new ProjectManager();
			System.out.println("pre ulaska u project manager");
			feeds = projectManager.deleteStudent(studentId);
			Gson gson = new Gson();
			System.out.println(gson.toJson(feeds));
			feeds = gson.toJson(feeds);
		}catch(Exception e){
			
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
	@Path("/SviPredmeti")
	@Produces("application/json")
	public String feedSviPredmeti()
	{
		String feeds  = null;
		try 
		{
			ArrayList<Predmet> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getSvePredmete();
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
			
			ArrayList<IspitniRok> feedData = null;
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
			
			ArrayList<IspitniRok> feedData = null;
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
