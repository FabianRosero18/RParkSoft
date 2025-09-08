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
    
    private TarifaDAO tarifas;
    private List<Integer> precios;

    public TarifaService(){
        tarifas = new TarifaDAO();
    }

    public void listarTarifas(){
        tarifas.consultarTarifas();
    }
    
    public ArrayList<Integer> precios(){
        return tarifas.getPrecios();
    }

    public void setPrecios(List<Integer> precios) {
        this.precios = precios;
    }
    
    
}
