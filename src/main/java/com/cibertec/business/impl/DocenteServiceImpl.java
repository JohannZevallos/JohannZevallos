package com.cibertec.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cibertec.business.DocenteService;
import com.cibertec.dao.DocenteDao;
import com.cibertec.dao.impl.DocenteDaoImpl;
import com.cibertec.model.Docente;

public class DocenteServiceImpl implements DocenteService {

	private DocenteDao dao = new DocenteDaoImpl();
	
	
	@Override
	public int registrarDocente(Docente docente) {
		return dao.registrarDocente(docente);
	}

	@Override
	public List<Docente> listarDocentes() {
		return dao.listarDocentes()
				.stream()
				//.filter(docente -> docente.getEstado()== 1)
				.collect(Collectors.toList());
	}
	
	public List<Docente> listarDocentes2() {
		List<Docente> lista = dao.listarDocentes();
		List<Docente> listaHabilitados = new ArrayList<Docente>();
		for (int i=0; i<lista.size(); i++) {
			if(lista.get(i).getEstado() == 1){
				listaHabilitados.add(lista.get(i));
			}
		}
		return listaHabilitados;
	}

	
	@Override
	public Docente listaDocentePorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizarDocente(Docente docente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarDocentePorId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
