package com.project.ISAM;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Default {

	List_data data = new List_data();
	String type;
	public List_data getData() {
		return data;
	}

	public void settype(String type) {
		this.type=type;
	}

	public void basic() {
		String DB_URL="jdbc:oracle:thin:@localhost:1521/LUKAWITCH";
		String id="maple";
		String pw="lukawitch1226";
		PreparedStatement ps =null;
		Connection con =null;
		Statement sta =null;
		ResultSet rs =null;
		String sql=null;
		sql="select projectname,name,major,end from project_test";
		List<data> basic_data = new ArrayList<data>();
		
	

		try{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection(DB_URL,id,pw);
			System.out.println("연결완료");
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			int h;
			while(rs.next()){
				data info = new data();
				info.setProjectName(rs.getString(1));			
				info.setname(rs.getString(2));
				info.setmajor(rs.getString(3));	
				h=rs.getInt(4);
				if(h==1) {
				info.setNow("진행중");}
				else {
					info.setNow("완료");
				}
				basic_data.add(info);
				
			}
			data.setBasic_data(basic_data);

	

		}catch(SQLException e){System.out.println(e);
		System.out.println("연결에러");}
	}
}
