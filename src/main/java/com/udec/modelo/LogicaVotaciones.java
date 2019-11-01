/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.modelo;

/**
 *
 * @author Michael Cardenas
 * clase encargada de hallar el ganador y devolverselo al controlador
 */
public class LogicaVotaciones {
   
    /**
     * constructor vacio de la clase
     */
    
    public LogicaVotaciones(){
        
    }
    
    /**
     * metodo que calcula el ganador basandose en los votos finales de cada candidato
     * @param a guarda el numero de votos del candidato 1
     * @param b guarda el numero de votos del candidato 2
     * @param c guarda el numero de votos del candidato 3
     * @return devuelve el ganador de los 3 candidatos
     */
    public int calcularGanador(int a,int b, int c){
        if(a>b&&a>c)
            return 1;
        else if(b>a&&b>c)
            return 2;
        else if(c>a&&c>b)
            return 3;
        else 
            return 0;
    }
}
