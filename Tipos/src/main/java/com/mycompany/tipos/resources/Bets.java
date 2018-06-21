/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tipos.resources;

/**
 *
 * @author Lenovo
 */
import com.mycompany.tipos.Credentials;
import com.mycompany.tipos.Ticket;
import com.mycompany.tipos.db.MySQL;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by host on 22.2.2018.
 */
@Path("/bets")
public class Bets {

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newTicket(Ticket ticket){
      MySQL mySQL=new MySQL();
        boolean ret1 = mySQL.checkLogin(ticket.login);
        boolean ret2 = mySQL.checkToken(ticket.token);
        if(ret1 && ret2) {
            System.out.println("Token and username are correct!");
            mySQL.insertBets(ticket);
            return Response.status(201).build();
        }
        else
        {
            System.out.println("Invalid username or token");
            return Response.status(401).build();
        }
     // return Response.status(201).build();
    }

    @POST
    @Path("/actual")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newTicket(Credentials credentials) {
        MySQL mySQL = new MySQL();
        boolean ret1 = mySQL.checkLogin(credentials.login);
        boolean ret2 = mySQL.checkToken(credentials.token);
        if(ret1 && ret2) {
            List<Ticket> tickets;
            tickets= mySQL.getActualTickets(credentials.login);
            Response.ok().build();
        }
        else return Response.status(401).build();


        return null;
    }
}

