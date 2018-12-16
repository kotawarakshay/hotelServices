package com.cg.hotelservices.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.hotelservices.bean.Bill;
import com.cg.hotelservices.bean.Hotel;
import com.cg.hotelservices.dao.HotelDaoImpl;
import com.cg.hotelservices.dao.IHotelDao;

public class HotelServiceImpl implements IHotelService{

	IHotelDao hotelDao = new HotelDaoImpl();
	@Override
	public List<Hotel> showRooms(String roomType) throws ClassNotFoundException, SQLException, IOException {
		List<Hotel> list = new ArrayList<Hotel>();
		list = hotelDao.showRooms(roomType);
		return list;
	}

	@Override
	public Bill generateBill(String customerId) throws ClassNotFoundException, SQLException, IOException {
		Bill bill = new Bill();
		bill = hotelDao.generateBill(customerId);
		return bill;
		// TODO Auto-generated method stub
		
	}

	public boolean validateRoomType(String roomType)
	{
		Pattern pat1 = Pattern.compile("^[ABC]$");
		Matcher mat1 = pat1.matcher(roomType);
		return mat1.matches();
	}
	
}
