package com.cibertec.dao;

import java.util.List;

import com.cibertec.model.Docente;

public interface DocenteDao {
	
	public int registrarDocente(Docente docente);
	
	public List<Docente> listarDocentes();
	
	public Docente listaDocentePorId(int id);
	
	public int actualizarDocente(Docente docente);

	public int eliminarDocentePorId(int id);
}
