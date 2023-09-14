package com.cibertec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cibertec.config.Conectar;
import com.cibertec.dao.UsuarioDao;

import com.cibertec.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

	private Conectar conectar;
	public UsuarioDaoImpl() {
		conectar = new Conectar();
	}
	
	@Override
	public Usuario validaUsuario(String usuario, String clave) {
		Usuario objeto = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = conectar.conectarMySQL();
			String sql = "SELECT * FROM usuario WHERE nombre = ? AND password = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			if(rs.next()) {
				objeto = new Usuario();
				objeto.setId(rs.getInt("idUsuario"));
				objeto.setUser(rs.getString("nombre"));
				objeto.setClave(rs.getString("password"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(cn != null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return objeto;
	}

}
