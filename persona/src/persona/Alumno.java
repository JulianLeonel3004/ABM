/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persona;

import java.io.RandomAccessFile;
//import persona.Calendario;
import DAO.Calendario;
import DAO.DAOException;


/**
 *
 * @author Julian Lopez / Lara Molina
 */
public class Alumno extends Persona
{
    private int dni;
    
    private Calendario fechaIngreso;
    
    private float promedio;
    
    private int materiasAprob;
    
    private int estado;
    
    
    public Alumno() 
	{ 
	}
    
   
    public Alumno(int dni, Calendario fechaIngreso, float promedio, int materiasAprob, int estado) throws PersonaInvalidaException 
    {
        setDni(dni);
        setFechaIngreso(fechaIngreso);
        setPromedio(promedio);
        setMateriasAprob(materiasAprob);
        setEstado(estado);
        //setLinea(linea);
    }
  
//STRAT DNI
    @Override
   public void setDni(int dni) throws PersonaInvalidaException
   {
       Alumno alumno = new Alumno(); 
       if(dni < 10000000)
            throw new PersonaInvalidaException("DNI invalido");
       this.dni = dni;
   }
   
    @Override
   public int getDni()
   {
       return dni;
   }
    
//END
//START FECHA DE INGRESO
    public void setFechaIngreso(Calendario fechaIngreso) throws PersonaInvalidaException
    {
        Alumno alumno = new Alumno();  
        String fechaingre = null;
        
        fechaingre = fechaIngreso.calendarioToString(fechaIngreso);
        this.fechaIngreso = fechaIngreso;
    }
    
    public Calendario getFechaIngreso() 
    {
        return fechaIngreso;
    }

//END START

//START PROMEDIO
    public void setPromedio(float promedio) throws PersonaInvalidaException
    {
        if(promedio < 0 || promedio > 10)
        {
            throw new PersonaInvalidaException("Promedio no valido");
        }
        this.promedio = promedio;
    }
    
    public float getPromedio() 
    {
        return promedio;
    }
//END PROMEDIO

//START MATERIAS APOBADAS
    public void setMateriasAprob(int materiasaprob) throws PersonaInvalidaException
    {
        if(materiasaprob < 0 || materiasaprob > 100)
        {
            throw new PersonaInvalidaException("No es valida las materias ingresadas");
        }
        this.materiasAprob = materiasaprob;
    }
    
    public int getMateriasAprob() 
    {
        return materiasAprob;
    }
//END MATERIAS APROBADAS
    
//START ESTADO
     public void setEstado (int estado) throws PersonaInvalidaException
     {       
         if((estado != 1) && (estado != 0) )
            throw new PersonaInvalidaException("El estado debe ser 0 o 1");
         this.estado = estado;
     }
     
     public int getEstado()
     {
         return estado;
     }
//END ESTADO

//START LINEA
    public Alumno setLinea(String linea) throws PersonaInvalidaException, DAOException
    {
       String vacio = "";
       Alumno alumno = new Alumno();
       if(!linea.equals(vacio))
       {
       Calendario fechaNac = null;
       Calendario fechaIngre = null;
      
       fechaNac = toCalendario(linea.substring(40,49));
       fechaIngre = toCalendario(linea.substring(51,60));

       alumno.setDni(Integer.valueOf(linea.substring(0, 8)));
       alumno.setApyn(linea.substring(9, 39));
       alumno.setFechaNac(fechaNac);
       alumno.setFechaIngreso(fechaIngre);
       alumno.setMateriasAprob(Integer.valueOf(linea.substring(64,66)));
       alumno.setPromedio(Float.valueOf(linea.substring(68,72)));
       alumno.setEstado(Integer.valueOf(linea.substring(74)));
       
       }
       
       return alumno;
       
    }
 //END
    
    public String toString(Alumno alumno)
	{
            Calendario fechaNaci = alumno.getFechaNac();
            Calendario fechaIngre = alumno.getFechaIngreso();
            return   String.format( "%-8s" ,alumno.getDni()) + "\t" +String.format("%-30s",alumno.getApyn()) + "\t" 
                    + String.format("%-10s", fechaNaci.calendarioToString(alumno.getFechaNac()))
                     + "\t" + String.format("%-10s",fechaIngre.calendarioToString(alumno.getFechaIngreso())) + 
                    "\t" + String.format("%-2s",alumno.getMateriasAprob()) + "\t" 
                    + String.format("%-4s", alumno.getPromedio()) + "\t" + String.format("%-1s",alumno.getEstado()) + System.getProperty("line.separator");
	}
    
    public Calendario toCalendario(String fechaLinea) throws DAOException
    {
        String[] partes; 
        Calendario fecha;
        partes = fechaLinea.split("/");
        
        fecha = new Calendario(Integer.valueOf(partes[0]), Integer.valueOf(partes[1]),Integer.valueOf(partes[2]));        
 
        return fecha;
    }


}
