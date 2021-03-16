package com.iesvdc.acceso.simplecrud.model;

import com.iesvdc.acceso.simplecrud.controller.Enum.Tipo;

public class Usuario {
    
    String username;
    String password;
    Tipo userType;
    Integer id;
    
    public Usuario() {

    }

    public Usuario(String username, String password,String userType){
        this.username = username;
        this.password = password;
        this.userType = toEnum(userType);
    }

    public Usuario(Integer id, String username, String password,String userType){
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = toEnum(userType);
    }

    public Usuario(String username, String password,Tipo userType){
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public Usuario(Integer id, String username, String password,Tipo userType){
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }


    private Tipo toEnum(String userType) {
        System.out.println("dentro");
        for (Tipo tipo : Tipo.values()) {
            if(userType.equals(tipo)){
                return tipo;
            }
        }
        return Tipo.alumno;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Tipo getUserType() {
        return userType;
    }
    public String getUserTypeString() {
        return userType.toString();
    }

    public void setUserType(Tipo userType) {
        this.userType = userType;
    }

    

    @Override 
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }

        Usuario u = (Usuario) o;
        
        return u.getId() == this.id &&
            u.getUsername().compareTo(this.username)==0 &&
            u.getPassword().compareTo(this.password)==0;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", password=" + password + ", userType=" + userType + ", username=" + username
                + "]";
    }

    
}