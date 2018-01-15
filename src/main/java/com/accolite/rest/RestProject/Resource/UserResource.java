package com.accolite.rest.RestProject.Resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.rest.RestProject.Model.User;
import com.accolite.rest.RestProject.Service.UserService;

@Path("users")
public class UserResource {
	UserService service = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		return service.getUsers();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByID(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		return service.getUserByID(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) throws ClassNotFoundException, SQLException {
		return service.addUser(user);
	}
	
	@Path("/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("id") int id, User user) throws ClassNotFoundException, SQLException {
		return service.updateUser(id, user);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteUser(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		return service.deleteUser(id);
	}
}

