package com.cg.hotelservices.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.hotelservices.bean.Bill;
import com.cg.hotelservices.bean.Hotel;
import com.cg.hotelservices.exception.HotelException;
import com.cg.hotelservices.util.DBConnection;

public class HotelDaoImpl implements IHotelDao{

	@Override
	public List<Hotel> showRooms(String roomType) throws ClassNotFoundException, SQLException, IOException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			pst = con.prepareStatement("select * from hotel_details where roomtype='"+roomType+"'");
			rs = pst.executeQuery();
			List<Hotel> l = new ArrayList<>();
			while(rs.next())
			{
				Hotel hotel = new Hotel();
				
				hotel.setRoomId(rs.getString(1));
				hotel.setHotelName(rs.getString(2));
				hotel.setHotelContact(rs.getString(3));
				hotel.setRoomType(rs.getString(4));
				hotel.setRoomRent(rs.getString(5));
				
				l.add(hotel);
			}
			return l;
		}
		catch(Exception he)
		{
			System.err.println(he.getMessage());
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bill generateBill(String customerId) throws ClassNotFoundException, SQLException, IOException {
		
		Connection con = DBConnection.getConnection();
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try
		{
			String type = null;
			int days=0;
			int rent = 0;
			int total ;
			pst1 = con.prepareStatement("select (checkoutdate-checkindate)as days,roomtype from customer_details where customerid='"+customerId+"'");
			rs1 = pst1.executeQuery();
			Bill bill = new Bill();
			while(rs1.next())
			{
				days = rs1.getInt(1);
				type = rs1.getString(2);
			}
			pst2 = con.prepareStatement("select roomrent from hotel_details where roomtype='"+type+"'");
			rs2 = pst2.executeQuery();
			while(rs2.next())
			{
				rent = rs2.getInt(1);
			}
			total = days * rent;
			System.out.println(total);
			bill.setCustomerId(customerId);
			bill.setDays(days);
			bill.setBill(total);
			return bill;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return null;
		// TODO Auto-generated method stub
		
	}

}
