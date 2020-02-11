package DAO;

import DAO.DAOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julialopez / Lara Molina
 */
public abstract class DAO <T, K> {
    
    public abstract void insertar(T obj) throws DAOException;
    public abstract void modificar(T obj) throws DAOException;
    public abstract void guardar(T obj) throws DAOException;
    public abstract void eliminar(T obj) throws DAOException;
    public abstract void eliminarPorId(K id) throws DAOException;
    public abstract T buscar(K id) throws DAOException;
    public abstract boolean existe(K id) throws DAOException;
    public abstract List<T> listarTodos() throws DAOException;
}
