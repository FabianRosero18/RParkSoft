/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Login;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class LoginDAO {

    private List<Login> login;
    
    public LoginDAO() {
        login = new ArrayList<>();
    }
    
    public void consultarUsuarios(){
        
        EntityManager em = JpaUtil.getEntityManager();
        try {
            login = em.createQuery("select l from Login l",Login.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Login> getLogin() {
        return login;
    }

}
