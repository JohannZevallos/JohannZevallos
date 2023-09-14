package com.cibertec.business.impl;

import com.cibertec.business.UsuarioService;
import com.cibertec.dao.UsuarioDao;
import com.cibertec.dao.impl.UsuarioDaoImpl;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDao dao = new UsuarioDaoImpl();
	
	@Override
	public Boolean validaUsuario(String usuario, String clave) {
		
		return null != dao.validaUsuario(usuario, clave) ? Boolean.TRUE : Boolean.FALSE;
	}

}
