package com.capgemini.contactbook.dao;


import java.io.IOException;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.util.DBConnection;

public class ContactBookDaoImpl implements ContactBookDao{

	@Override
	public int addEnquiry(EnquiryBean enqry) throws IOException, SQLException {
			
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=null;		
				ResultSet resultSet = null;
				
				int enqryId=0;
				
				preparedStatement=connection.prepareStatement(QueryMapper.Insert_Details);

				preparedStatement.setString(1,enqry.getfName());			
				preparedStatement.setString(2,enqry.getlName());
				preparedStatement.setString(3,enqry.getContactNo());
				preparedStatement.setString(4,enqry.getpDomain());
				preparedStatement.setString(5, enqry.getpLocation());
				resultSet=preparedStatement.executeQuery();
				
				Statement statement=connection.createStatement();
				resultSet=statement.executeQuery("Select enqryId_Seq.currval from enquiry");
				while(resultSet.next())
				{
					enqryId=resultSet.getInt(1);
				}
			
			
			return enqryId;
		}
	

	@Override
	public EnquiryBean getEnquiryDetails(int enqryId) throws SQLException, IOException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement1=null;		
		ResultSet resultSet = null;
		EnquiryBean enqry=new EnquiryBean();
		
		preparedStatement1=connection.prepareStatement("Select * from enquiry where enqryId=?");
		preparedStatement1.setInt(1,enqryId);
		resultSet=preparedStatement1.executeQuery();
		
		
		
		while(resultSet.next())
		{
			enqry.setEnqryId(resultSet.getInt(1));
			enqry.setfName(resultSet.getString(2));
			enqry.setlName(resultSet.getString(3));
			enqry.setContactNo(resultSet.getString(4));
			enqry.setpDomain(resultSet.getString(5));
			enqry.setpLocation(resultSet.getString(6));
		}
		
		
		return enqry;
		
	}




	

	
	}


