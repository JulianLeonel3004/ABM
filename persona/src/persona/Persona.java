/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

//import persona.Calendario;
import DAO.Calendario;

/**
 *
 * @author nestor
 */
public class Persona
{
	private int dni;
	
	public String apyn;
	
	private Calendario fechaNac;
	
	private char sexo;

	public Persona()
	{
	}

	
	public Persona(int dni) throws PersonaInvalidaException
	{
		setDni(dni);
	}

	public Persona(int dni, String apyn, Calendario fechaNac, char sexo) 
			throws PersonaInvalidaException
	{
		setDni(dni);
		this.apyn = apyn;
		this.fechaNac = fechaNac;
		setSexo(sexo);
	}

	public int getDni()
	{
		return dni;
	}

	public void setDni(int dni) throws PersonaInvalidaException
	{
		if (dni <0) {
			throw new PersonaInvalidaException("El DNI no puede ser negativo");
		}
		this.dni = dni;
	}

	public String getApyn()
	{
		return apyn;
	}

	public void setApyn(String apyn)
	{
		this.apyn = apyn;
	}

	public Calendario getFechaNac()
	{
		return fechaNac;
	}

	public void setFechaNac(Calendario fechaNac)
	{
		this.fechaNac = fechaNac;
	}

	public char getSexo()
	{
		return sexo;
	}

	public void setSexo(char sexo) throws PersonaInvalidaException
	{
		sexo = Character.toLowerCase(sexo);
		if (sexo!='m'&& sexo!='f') {
			throw new PersonaInvalidaException("El sexo no es válido");
		}
		this.sexo = sexo;
	}
        
      /* public String calendarioToString(Calendario fecha)
        {
                return fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAnio();
        }

	/*@Override
	public String toString()
	{
		return "Persona{" + "dni=" + dni + ", apyn=" + apyn + 
				", fechaNac=" + calendarioToString(fechaNac) + ", sexo=" + sexo + '}';
	}*/
        
        
	
}
