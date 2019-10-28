package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Conductor;

public class ConductorDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	// guardar conductor
	public boolean guardar(Conductor conductor) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO persona (nombre, apellido, dni, nro_licencia) VALUES(?,?,?,?)";
			statement = connection.prepareStatement(sql);

			//statement.setInt(1, null);
			statement.setString(1,conductor.getNombre());
			statement.setString(2,conductor.getapellido());
			statement.setString(3,conductor.getdni());
			statement.setString(4,conductor.getnroLicencia());
			
			System.out.println(statement.toString());
			
			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// Editar conductor
	public boolean editar(Conductor conductor) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE persona SET nombre=?, apellido=?, dni=?,nro_licencia=? WHERE id_persona=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, conductor.getNombre());
			statement.setString(2, conductor.getapellido());
			statement.setString(3, conductor.getdni());
			statement.setString(4, conductor.getnroLicencia());
			
			statement.setInt(5, conductor.getId());

			estadoOperacion = statement.executeUpdate() > 0;
			System.out.println(statement.toString());
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// eliminar conductor
	public boolean eliminar(int idConductor) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM persona WHERE id_persona=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idConductor);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// obtener lista de conductores
	public List<Conductor> obtenerConductor() throws SQLException {
		ResultSet resultSet = null;
		List<Conductor> listaConductor= new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM persona";
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Conductor c=new Conductor();
				c.setId(resultSet.getInt(1));
				c.setNombre(resultSet.getString(2));
				c.setapellido(resultSet.getString(3));
				c.setdni(resultSet.getString(4));
				c.setnroLicencia(resultSet.getString(5));
				
				listaConductor.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaConductor;
	}
	
	// obtener Condutor por ID
	public Conductor obtenerConductor(int idconductor) throws SQLException {
		ResultSet resultSet = null;
		Conductor c=new Conductor();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM persona WHERE id_persona =?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idconductor);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {				
				c.setId(resultSet.getInt(1));
				c.setNombre(resultSet.getString(2));
				c.setapellido(resultSet.getString(3));
				c.setdni(resultSet.getString(4));
				c.setnroLicencia(resultSet.getString(5));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	// obtener conexion pool
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}
