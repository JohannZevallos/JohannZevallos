package com.cibertec.business;

import java.util.List;

import com.cibertec.model.Docente;

public interface DocenteService {

	public int registrarDocente(Docente docente);
	
	public List<Docente> listarDocentes();
	
	public Docente listaDocentePorId(int id);
	
	public int actualizarDocente(Docente docente);

	public int eliminarDocentePorId(int id);
}
