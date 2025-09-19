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
    private List<String> preciosModificar = new ArrayList<>();

    public TarifaService(){
        tarifaDAO = new TarifaDAO();
    }

    public void listarTarifas(){
        tarifaDAO.consultarTarifas();
    }
    
    public void validarTarifasActualizar(){
        
        int i = 1;
        
        for(String precio : preciosModificar){
        // Este try intenta convertir el valor ingresado a entero.
        // Si el campo está vacío ("") o contiene texto no numérico,
        // se lanzará un NumberFormatException.            
            try {
                int precioValidado = Integer.parseInt(precio);
                if(precioValidado > 0) tarifaDAO.modificarTarifa(i,precioValidado);
            } catch (NumberFormatException  e) {
            // Si el campo está vacío o contiene un valor inválido,
            // no se realiza ninguna modificación y se continúa con la siguiente iteración.
            }               
            
            i++;
        }
    }
    
    
    public List<Integer> precios(){
        return tarifaDAO.getPrecios();
    }


    public void setPreciosModificar(List<String> preciosModificar) {
        this.preciosModificar = preciosModificar;
    }

}
