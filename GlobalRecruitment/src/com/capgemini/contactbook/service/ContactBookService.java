package com.capgemini.contactbook.service;

import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.contactbook.bean.EnquiryBean;

public interface ContactBookService {

	public int addEnquiry(EnquiryBean enqry) throws IOException, SQLException;
	public EnquiryBean getEnquiryDetails(int enqryId) throws SQLException, IOException;
	public boolean isValidEnquiry(EnquiryBean enqry);
}
