package com.cibertec.dao;

import com.cibertec.model.Usuario;

public interface UsuarioDao {

	public Usuario validaUsuario(String usuario, String clave);
}
