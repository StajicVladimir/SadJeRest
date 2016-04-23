package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ProjectManager;

import com.google.gson.Gson;


import dto.FeedObjectsTerm;

import dto.IspitRok;
import dto.Predmet;
import dto.Student;
import dto.IspitniRok;
import dto.Odsek;

@Path("/WebService")
public class FeedService {
	
	@POST
	@Path ("/Students/")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateStudent(@FormParam("id") int studentId, 
			@FormParam("ime") String ime, @FormParam("prezime") String prezime, 
				@FormParam("adresa") String adresa){
		String feeds  = null;
		try 
		{	
			
			String feedData = null;
			ProjectManager projectManager= new ProjectManager();
			System.out.println("hey" + studentId);
			feedData = projectManager.updateStudent(studentId, ime,prezime,adresa);
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
	@Path("/SviPredmeti/{odsekid}")
	@Produces("application/json")
	public String feedPredmetiOdsek(@PathParam ("odsekid") int odsekId)
	{
		String feeds  = null;
		try 
		{
			ArrayList<Predmet> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getPredmetiOdsek(odsekId);
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
	//**************Svi rokovi u kojima je student bio aktivan ISTORIJAT ROKOVA
	@GET
	@Path("/Rokovi/student/{studentid}")
	@Produces("application/json")
	
	public String feedRokoviStudent(@PathParam ("studentid") int id)
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
	//**********TO DO **************************
	@GET
	@Path("/Rokovi/{rokid}")
	@Produces("application/json")
	
	public String feedRok(@PathParam ("rokid") int id)
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
			
			ArrayList<IspitRok> feedData = null;
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
	
	@GET
	@Path("/odseci")
	@Produces("application/json")
	
	public String feedOdseci()
	{	
		
		String feeds  = null;
		try 
		{	
			
			ArrayList<Odsek> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getOdseci();
			
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
	@Path("/odseci/{odsekid}")
	@Produces("application/json")
	public String feedOdsek(@PathParam("odsekid") int odsekId){
		String feeds  = null;
		try 
		{	
			
			Odsek feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.getOdsek(odsekId);
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

}
