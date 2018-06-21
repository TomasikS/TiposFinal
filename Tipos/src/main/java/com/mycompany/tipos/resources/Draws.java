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
import com.mycompany.tipos.Draw_Number;
import com.mycompany.tipos.db.MySQL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by host on 6.3.2018.
 */
@Path("/draw/{id}")
public class Draws {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrawNumbers(@PathParam("id")  int id){
        MySQL mySQL = new MySQL();
        System.out.println(id);
        Draw_Number draw_number = mySQL.getDrawNumbers(id);
        if(draw_number!=null){
            String result="{\"bet1 \":"+draw_number.bet1+", ";
            result+="\"bet2 \":"+draw_number.bet2+", ";
            result+="\"bet3 \":"+draw_number.bet3+", ";
            result+="\"bet4 \":"+draw_number.bet4+", ";
            result+="\"bet5 \":"+draw_number.bet5+"} ";
            return Response.ok(result).build();
        }
        return  Response.status(Response.Status.NOT_FOUND).build();
    }
}

