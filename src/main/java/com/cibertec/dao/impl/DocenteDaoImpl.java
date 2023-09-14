package com.cibertec.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.config.Conectar;
import com.cibertec.dao.DocenteDao;
import com.cibertec.model.Docente;


public class DocenteDaoImpl implements DocenteDao{

	private Conectar conectar;
	
	public DocenteDaoImpl() {
		conectar =new Conectar();
	}
	
	@Override
	public int registrarDocente(Docente docente) {
		int valor = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = conectar.conectarMySQL();
			String sql = "INSERT INTO docente VALUES (null,?,?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1, docente.getNombre());
			ps.setString(2, docente.getApellido());
			ps.setString(3, docente.getDni());
			ps.setInt(4, docente.getEstado());
			valor = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return valor;
	}

	@Override
	public List<Docente> listarDocentes() {
		List<Docente> lista = new ArrayList<Docente>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = conectar.conectarMySQL();
			String sql = "SELECT * FROM docente";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Docente docente = new Docente();
				docente.setId(rs.getInt("iddocente"));
				docente.setNombre(rs.getString("nombre"));
				docente.setApellido(rs.getString("apellidos"));
				docente.setDni(rs.getString("dni"));
				docente.setEstado(rs.getInt("estado"));
				lista.add(docente);
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
		return lista;
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
