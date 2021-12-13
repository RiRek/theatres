package org.acme;

import org.acme.entities.Movie;
import org.acme.entities.Theater;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/theater")
public class TheaterResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Theater> theatres= Theater.listAll();
        return  Response.ok(theatres).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getById(@PathParam("id") Long id){

        return  Theater.findByIdOptional(id)
                .map(theater ->Response.ok(theater).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Theater theater){

        Theater.persist(theater);
        if(theater.isPersistent()){
            return  Response.created((URI.create("/theater" +theater.id))).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted =Theater.deleteById(id);
        if(deleted){
            return Response.noContent().build();

        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @PUT
    @Transactional
    @Path("/{id}")
    public void updateMovie(@PathParam("id") Long id, Theater newTheater) {
        Theater p = Theater.findById(id);
        if(p == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        p.name =newTheater.name;
        p.address=newTheater.address;
        p.city=newTheater.city;
        p.state=newTheater.state;
    }
}
