/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tipos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Lenovo
 */
public class Registration{
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("email")
    public String email;
    @JsonProperty("login")
    public String login;
    @JsonProperty("password")
    public String password;
}
