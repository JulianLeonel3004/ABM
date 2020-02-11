/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Julian Lopez
 */
public class Calendario {
    private int dia,mes,anio;
    
    public Calendario(int dia, int mes, int anio) throws DAOException
    {
       if(!validarFecha(dia,mes,anio))
            throw new DAOException("Fecha invalida");
       setDia(dia);
       setMes(mes);
       setAnio(anio);
    }
    public void setDia(int dia)
    {
        this.dia = dia;
        
    }
    public void setMes(int mes)
    {
        this.mes = mes;
    }
    
    public void setAnio(int anio)
    {
        this.anio = anio;
    }
    public int getdia()
    {
        return dia;
    }
    public int getmes()
    {
        return mes;
    }
    public int getanio()
    {
        return anio;
    }
   

    private boolean validarFecha(int dia, int mes, int anio) 
    {
        int  dias [][] ={ {31,28,31,30,31,30,31,31,30,31,30,31},
                          {31,29,31,30,31,30,31,31,30,31,30,31}}; 
        
        if(anio < 1900 || anio > 5000)
            return  false;
        if(mes < 1 || mes > 12)
            return false;
        if((anio % 400 == 0) || ( (anio % 4 == 0) && (anio % 100 != 0)))
            if (dias[0][mes] < dia)
                return false;
        else
            if (dias[1][mes] < dia)
                return false;  
        return true;
            
    }
    
    
    public String calendarioToString(Calendario calendario)
    {
        return calendario.dia+ "/" + calendario.mes + "/"  + calendario.anio;
    }
    
    

}
