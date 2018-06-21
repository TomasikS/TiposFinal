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
public class Credentials {
    @JsonProperty("login")
    public String login;

    @JsonProperty("password")
    public String password;

    @JsonProperty("token")
    public String token;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

