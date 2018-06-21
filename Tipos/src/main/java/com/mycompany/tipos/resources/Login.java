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
import com.mycompany.tipos.Registration;
import com.mycompany.tipos.User;
import com.mycompany.tipos.db.MySQL;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 

/**
 * Created by host on 20.2.2018.
 */

@Path("/auth")
public class Login {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkCredentials(Credentials credential){
      
        MySQL mySQL = new MySQL();
        User user=mySQL.getUser(credential.login, credential.password);
        if(user==null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        else{
            String result;
            result="{\"firstname\":\""+user.getFirstname()+"\" , ";
            result+="\"lastname\":\""+user.getLastname()+"\" , ";
            result+="\"email\":\""+user.getEmail()+"\" , ";
            result+="\"login\":\""+user.getLogin()+"\" , ";
            result+="\"token\":\""+user.getToken()+"\"}";
            return Response.ok(result,MediaType.APPLICATION_JSON_TYPE).build();
        }

    }

  @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(Credentials credentials){
            MySQL mySQL = new MySQL();
       
        mySQL.logout(credentials.login, credentials.token);
        return Response.ok().build();
    }

    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewUser(Registration registration) {
         MySQL mySQL=new MySQL();
         boolean exist=mySQL.checkIfEmailOrLoginExist(registration.login.trim(), registration.email.trim());
    if(exist){
            System.out.println("User already exists");
            return Response.status(406).build();

        }
        else{
            
            System.out.println("go on with registration");
            mySQL.insertNewUserIntoDb(registration);
        }
          return Response.status(200).build();
    }



}

