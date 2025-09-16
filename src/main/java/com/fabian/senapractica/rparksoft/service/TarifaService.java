/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.TarifaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */
public class TarifaService {
    
    private TarifaDAO tarifaDAO;
    private List<Integer> precios = new ArrayList<>();

    public TarifaService(){
        tarifaDAO = new TarifaDAO();
    }

    public void listarTarifas(){
        tarifaDAO.consultarTarifas();
    }
    public void validarTarifasActualizar(){
        
        int i = 1;
        
        for(int precio : precios){
            if(precio > 0) tarifaDAO.modificarTarifa(i,precio);
            i++;
        }
        
    }
    
    public ArrayList<Integer> precios(){
        return tarifaDAO.getPrecios();
    }

    public void setPrecios(List<Integer> precios) {
        this.precios = precios;
    }
    
    
}
