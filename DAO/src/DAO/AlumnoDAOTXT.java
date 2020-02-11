package DAO;

//import persona.PersonaInvalidaException;

import persona.Alumno;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persona.PersonaInvalidaException;


/* @author Julian Lopez / Lara Molina*/

public class AlumnoDAOTXT extends DAO<Alumno, Integer>
{

    public AlumnoDAOTXT(RandomAccessFile archivo) //throws FileNotFoundException
    {
        archivoRAF = archivo;
    }    

    @Override
    public void insertar(Alumno alu) throws DAOException 
    {
        if(existe(alu.getDni()))
        {
            try 
            {
                throw new Exception("Clave " + alu.getDni() + " Duplicada.");       
            } 
            catch (Exception ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try 
            {
                archivoRAF.seek(archivoRAF.length());
            }
            catch (IOException ex) {
                Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            }
            try 
            {
                archivoRAF.writeBytes(alu.toString(alu));//alu.toString() + System.lineSeparator()
            } catch (IOException ex) {
                Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void modificar(Alumno obj)throws DAOException 
    {
        String linea;
        long inicioLinea = 0;
        try 
        {
            archivoRAF.seek(0);
        } catch (IOException ex) 
        {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        { 
            while((linea = archivoRAF.readLine()) != null)
            {
                if(Integer.valueOf(linea.substring(0,8)).equals(obj.getDni())){
                    archivoRAF.seek(inicioLinea);
                    archivoRAF.writeBytes(obj.toString(obj));
                    return;
                }
                inicioLinea = archivoRAF.getFilePointer();
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new DAOException("No se encontro el alumno");
    }
    
        @Override
    public void guardar(Alumno obj) throws DAOException {
        modificar(obj);
    }


    public Alumno buscar(Integer id)throws DAOException 
    {
        try
        {
            archivoRAF.seek(0);
        } catch (IOException ex) 
        {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	String linea;
	boolean encontre = false;
        Alumno alu = new Alumno();
	
        try {
            while((linea = archivoRAF.readLine()) != null && !encontre)
            {
                
                if(Integer.valueOf(linea.substring(0, 8)).equals(id))
                {
                    encontre = true;
                    alu = alu.setLinea(linea);
                }
            }
        } catch (IOException ex)
        {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersonaInvalidaException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
 
	return alu;
    }
    
     @Override
    public void eliminarPorId(Integer id) throws DAOException {
        JOptionPane.showMessageDialog(null, "El borrado fisico no esta implementado en archivos de texto", "Atencion", JOptionPane.WARNING_MESSAGE);
    }



public boolean existe(Integer id) throws DAOException
    {
        String vacio = "";
        try {
            archivoRAF.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
	String linea;
	boolean encontre = false;
        try {
            while((linea = archivoRAF.readLine()) != null && !encontre)
            {   
                if(!linea.equals(vacio))
                {
                    if(Integer.valueOf(linea.substring(0, 8)).equals(id))
                        encontre = true;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
	return encontre;
    }
    
    public void eliminar(Alumno obj)throws DAOException 
    {
        JOptionPane.showMessageDialog(null, "El borrado fisico no esta implementado en archivos de texto", "Atencion", JOptionPane.WARNING_MESSAGE);
        
    }

    
    public List<Alumno> listarTodos() throws DAOException
    {
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            archivoRAF.seek(0);
            String linea;
            Alumno alu;
            while((linea=archivoRAF.readLine())!=null) 
            {
                alu = new Alumno();
                alu = alu.setLinea(linea);
                alumnos.add(alu);   
            }
        }catch (IOException ex) {
            throw new DAOException("Error de E/S");
        } catch (PersonaInvalidaException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
        
    }
    
    public List<Alumno> getTodosAlta() throws DAOException, PersonaInvalidaException
    {
        String []vector = null;
        List<Alumno> alumnos = new ArrayList<>();
        try {
            archivoRAF.seek(0);
            String linea;
            Alumno alu;
            while((linea=archivoRAF.readLine())!=null) 
            {
                alu = new Alumno();
                alu = alu.setLinea(linea);               
                vector = linea.split("\t");
                if(vector[7].equals(1))
                    alumnos.add(alu);
            }
        }catch (IOException ex) {
            throw new DAOException("Error de E/S");
        }
        return alumnos; 
    }
    public List<Alumno> getTodosBaja() throws DAOException, PersonaInvalidaException
    {
        String []vector = null;
        List<Alumno> alumnos = new ArrayList<>();
        try {
            archivoRAF.seek(0);
            String linea;
            Alumno alu;
            while((linea=archivoRAF.readLine())!=null) 
            {
                alu = new Alumno();
                alu = alu.setLinea(linea);               
                vector = linea.split("\t");
                if(vector[7].equals(0))
                    alumnos.add(alu);
            }
        }catch (IOException ex) {
            throw new DAOException("Error de E/S");
        }
        return alumnos; 
    }
    
    private RandomAccessFile archivoRAF;


}