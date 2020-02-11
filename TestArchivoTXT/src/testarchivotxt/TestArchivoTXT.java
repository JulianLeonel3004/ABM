/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testarchivotxt;
import java.io.RandomAccessFile;
import persona.Alumno;
import persona.Calendario;
import DAO.AlumnoDAOTXT;
import persona.PersonaInvalidaException;
/**
 *
 * @author Julian Lopez /Lara Molina
 */
public class TestArchivoTXT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersonaInvalidaException, DAOException {
        Alumno alumno = new Alumno();
        //Calendario fechanac = new Calendario();
        AlumnoDAOTXT alumnotxt = new AlumnoDAOTXT();
        
        RandomAccessFile  raf = null;
        alumno.setApyn("Lopez Julian");
        alumno.setDni(23999888);
        
        alumnotxt.insertar(alumno);
        
       
    }
    
}
