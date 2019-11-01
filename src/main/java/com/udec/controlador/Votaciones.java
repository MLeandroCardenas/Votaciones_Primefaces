/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.controlador;

import com.udec.modelo.LogicaVotaciones;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Michael Cardenas
 * controlador de la vista 
 */
@Named(value = "votaciones")
@ViewScoped
public class Votaciones implements Serializable {
    
    /**
     * variables para llevar el conteo de votos de cada candidato
     */
    private int contadorUno,contadorDos,contadorTres;
    
    /**
     * variable para crear el grafico y llenarlo
     */
    private PieChartModel grafica;

    /**
     * Creates a new instance of Votaciones
     */
    public Votaciones() {
    }
    
    /**
     * metodo para inciar las variables apenas arranque el programa
     */
    @PostConstruct
    public void init(){
        contadorUno=0;
        contadorDos=0;
        contadorTres=0;
    }
    
    /**
     * metodo que incrementa de a uno el voto del candidato uno
     * @return  el valor actual para verlo en la vista al usuario
     */
    public int votosCandidatoUno(){
        contadorUno++;
        setContadorUno(contadorUno);
        crearGrafica();
        return getContadorUno();
    }
    
    /**
     * metodo que incrementa de a uno el voto del candidato dos
     * @return  el valor actual para verlo en la vista al usuario
     */
    public int votosCandidatoDos(){
        contadorDos++;
        setContadorDos(contadorDos);
        crearGrafica();
        return getContadorDos();
    }
    
    /**
     * metodo que incrementa de a uno el voto del candidato tres
     * @return  el valor actual para verlo en la vista al usuario
     */
    public int votosCandidatoTres(){
        contadorTres++;
        setContadorTres(contadorTres);
        crearGrafica();
        return getContadorTres();
    }
    
    /**
     * metodo que crea la grafica con los datos actuales
     */
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
    
    /**
     * limpia la grafica cuando finaliza la votacion
     */
    public void vaciarGrafica(){
        grafica.clear();
    }
    
    /**
     * metodo que dice quien es el ganador de los 3 candidatos
     */
    public void ganador(){
        int resultado;
        LogicaVotaciones logica = new LogicaVotaciones();
        resultado = logica.calcularGanador(getContadorUno(), getContadorDos(), getContadorTres());
        
        if (resultado == 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Alvaro Fajardo gana con " +getContadorUno() + " votos");       
            PrimeFaces.current().dialog().showMessageDynamic(message);
            init();
            vaciarGrafica();
        } else if (resultado == 2) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Diego Garzon gana con " +getContadorDos()+ " votos");       
            PrimeFaces.current().dialog().showMessageDynamic(message);
            init();
            vaciarGrafica();
        } else if (resultado == 3) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Guillermo Aldana gana con " +getContadorTres()+ " votos");       
            PrimeFaces.current().dialog().showMessageDynamic(message);
            init();
            vaciarGrafica();
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Empate");       
            PrimeFaces.current().dialog().showMessageDynamic(message);
            init();
            vaciarGrafica();
        }            
    }

    /**
     * metodos publicos  y privados para acceder a variables encapsuladas
     * @return 
     */
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
