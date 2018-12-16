package com.cg.hotelservices.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.hotelservices.bean.Bill;
import com.cg.hotelservices.bean.Hotel;

public interface IHotelDao {

	public List<Hotel> showRooms(String roomType) throws ClassNotFoundException, SQLException, IOException;
	public Bill generateBill(String customerId) throws ClassNotFoundException, SQLException, IOException;
}
