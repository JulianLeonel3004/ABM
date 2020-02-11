/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txt;
import DAO.AlumnoDAOTXT;
import DAO.DAOException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.PersonaInvalidaException;
import DAO.Calendario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author julian lopez
 */

public class Txt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException, FileNotFoundException, PersonaInvalidaException, IOException {
        int cont = 0;
        int i;
        Alumno alumno = new Alumno();
        List<Alumno> listaAlumnos = new ArrayList<>();
      
        Calendario fechaNac = new Calendario(20,3,1997);
        Calendario fechaIngre = new Calendario(20,3,2000);
        
        alumno.setDni(22222227);
        alumno.setApyn("Julian");
        alumno.setEstado(1);
        alumno.setFechaNac(fechaNac);
        alumno.setFechaIngreso(fechaIngre);
        alumno.setMateriasAprob(3);
        alumno.setPromedio((float) 4.5);
        alumno.setEstado(1);
        
        RandomAccessFile archivoRAF = new RandomAccessFile("Alumnos.txt","rw");
        AlumnoDAOTXT daotxt = new AlumnoDAOTXT(archivoRAF);
        //daotxt.insertar(alumno);
        listaAlumnos = daotxt.listarTodos();
        for(i=0; i< listaAlumnos.size(); i++)
        {
            System.out.println(listaAlumnos.get(i));
        }
        /*String dni = "";
        String comillas = "";
        if(dni != "")
        {
            if(Integer.valueOf(dni.substring(0, 8)).equals(22222221))
            System.out.println("OK");
        else
            System.out.println("ERROR");
        } 
        else
            System.out.println("hay comillas"); */
        
        
   
       /* if(daotxt.existe(alumno.getDni()))
            System.out.println("Existe");
         else
            System.out.println("No existe");*/
        
        // TODO code application logic herext","rws");
      /*String cadena = "hola";
      archivo.seek(archivo.length());
      archivo.writeBytes(cadena);*/
         
        /*FileWriter fichero = null;
        PrintWriter pw = null;
            
        Alumno alumno = new Alumno();
        alumno.setDni(39712927);
        alumno.setApyn("Julian Lopez");
        alumno.setEstado(1);
        String cadena = alumno.getApyn();
        try
        {
            fichero = new FileWriter("Alumnos.txt");
            pw = new PrintWriter(fichero);
            System.out.println("Escribiendo en el archivo.txt");
            pw.print(cadena);
 
        } catch (Exception e) {
        	e.printStackTrace();
        }
       	try {
        	if (null != fichero)
                    fichero.close();
       	} catch (Exception e2) {
       	e2.printStackTrace();
       }*/
        
    }
    
    
}

