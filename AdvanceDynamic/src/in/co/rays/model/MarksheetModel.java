package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.com.rays.util.JdbcDataSource;

public class MarksheetModel {

	public Integer nextpk()throws Exception {
		int pk=0;
		Connection con = JdbcDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select max(id) from marksheet");
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		con.close();
		
		return pk+1;
		
	}
	public void add(MarksheetBean bean) throws Exception{
		Connection con = JdbcDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		ps.setInt(1,nextpk());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4,bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		int i = ps.executeUpdate();
		
		System.out.println("data inserted"+i);
		con.close();
	}
	public void update(MarksheetBean bean)throws Exception{
		Connection con = JdbcDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("update marksheet set name =?,roll_no=?,physics=?,chemistry=?,maths=? where id =?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRollNo());
		ps.setInt(3,bean.getPhysics());
		ps.setInt(4, bean.getChemistry());
		ps.setInt(5, bean.getMaths());
		ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();
		
		System.out.println("data inserted"+i);
		con.close();
	}
	public void delete(int id)throws Exception{
		Connection con = JdbcDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from marksheet where id =?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("data deleted"+i);
		con.close();
	}
	public MarksheetBean findById(int id)throws Exception{
		Connection con = JdbcDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from marksheet where id =?");
		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		con.close();
		return bean;
	}
	public List search(MarksheetBean bean,int pageNo,int pageSize)throws Exception{
		Connection con = JdbcDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
		if(bean != null) {
			if(bean.getName() != null && bean.getName().length()>0) {
				sql.append("and name like'"+bean.getName()+"%'");
			}
			if(bean.getRollNo() >0) {
				sql.append("and roll_no like"+bean.getRollNo());
			}
		}
		if(pageSize >0) {
			pageNo = (pageNo -1)*pageSize;
			sql.append(" limit "+pageNo+","+pageSize);
		}
		System.out.println("SQL"+sql);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		con.close();
		return list;
}
}
