/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.controlador;

import com.udec.modelo.LogicaVotaciones;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author michl
 */
@Named(value = "votaciones")
@ViewScoped
public class Votaciones implements Serializable {
    
    private int contadorUno,contadorDos,contadorTres;
    private PieChartModel grafica;

    /**
     * Creates a new instance of Votaciones
     */
    public Votaciones() {
    }
    
    @PostConstruct
    public void init(){
        contadorUno=0;
        contadorDos=0;
        contadorTres=0;
    }
    
    public int votosCandidatoUno(){
        contadorUno++;
        setContadorUno(contadorUno);
        crearGrafica();
        return getContadorUno();
    }
    
    
    public int votosCandidatoDos(){
        contadorDos++;
        setContadorDos(contadorDos);
        crearGrafica();
        return getContadorDos();
    }
    
    public int votosCandidatoTres(){
        contadorTres++;
        setContadorTres(contadorTres);
        crearGrafica();
        return getContadorTres();
    }
    
    private void crearGrafica(){
        grafica = new PieChartModel();
        grafica.set("Alvaro Fajardo",getContadorUno());
        grafica.set("Diego Garzon",getContadorDos());
        grafica.set("Guillermo Aldana",getContadorTres());
        
        grafica.setTitle("VALORES ACTUALES");
        grafica.setLegendPosition("e");
        grafica.setFill(false);
        grafica.setShowDataLabels(true);
        grafica.setDiameter(150);
        grafica.setShadow(false);
    }

    public int getContadorUno() {
        return contadorUno;
    }

    public void setContadorUno(int contadorUno) {
        this.contadorUno = contadorUno;
    }

    public int getContadorDos() {
        return contadorDos;
    }

    public void setContadorDos(int contadorDos) {
        this.contadorDos = contadorDos;
    }

    public int getContadorTres() {
        return contadorTres;
    }

    public void setContadorTres(int contadorTres) {
        this.contadorTres = contadorTres;
    }

    public PieChartModel getGrafica() {
        return grafica;
    }

    public void setGrafica(PieChartModel grafica) {
        this.grafica = grafica;
    }
}
