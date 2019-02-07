package org.bhupinder.zversal.messenger.resources;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import java.util.List;
import java.lang.Object;
import java.net.URI;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.bhupinder.zversal.messenger.model.Message;
import org.bhupinder.zversal.messenger.patch.PATCH;
import org.bhupinder.zversal.messenger.service.Messageservice;



@Path("/messages")
public class Messageresource {
	
	Messageservice messageService = new Messageservice();
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> mymessage() {
		return messageService.getAllMessages();
		
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> mymessage(@QueryParam("year") int year) {
		return messageService.getAllMessagesForYear(year);
		
		}*/
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addmessages(Message message , @Context UriInfo uriInfo) throws URISyntaxException {
		Message newMessage = messageService.addMessages(message);
		String newId= String.valueOf(newMessage.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
		 return Response.created(uri)
		                .entity(newMessage)
	                    .build();
		
		        
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updatemessages(@PathParam("messageId") long Id ,Message message) {
		message.setId(Id);
		return messageService.updateMessage(message);
	}
	
	
	@Path("/{messageId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String delmessage(@PathParam("messageId") long Id) {
		return "DELETED";
		
	} 
	@PATCH
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message partialupdate(@PathParam("messageId") long Id, Message message) {
      return message;
		
	}
	
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getMessages(@PathParam("messageId") long Id, @Context Request request) {
		
		Message newMessages = messageService.getMessage(Id);
		CacheControl cc =new CacheControl();
		cc.setMaxAge(86400);
		
		
		EntityTag etag = new EntityTag(Integer.toString(newMessages.hashCode()));
		ResponseBuilder builder =request.evaluatePreconditions(etag);
		if(builder != null){
	        
	       return builder.cacheControl(cc).tag(etag).build();
	        
	    }
		
		
		builder = Response.ok(newMessages);
        builder.tag(etag);
		return builder.build();
		
	}
}

