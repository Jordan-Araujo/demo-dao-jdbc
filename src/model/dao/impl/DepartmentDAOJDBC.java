package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class DepartmentDAOJDBC implements DepartmentDAO{
	
	private Connection conn;

	public DepartmentDAOJDBC(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void insert(Department department) {
		
	}

	@Override
	public void update(Department department) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department WHERE department.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()){
				Department obj = instantiateDepartment(rs);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM department ");
			rs = st.executeQuery();
			
			while(rs.next()) {
				Department dep = instantiateDepartment(rs);
				list.add(dep);
			}
			return list;
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}	
}