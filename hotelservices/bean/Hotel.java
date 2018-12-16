package com.cg.hotelservices.bean;

public class Hotel 
{
		private String roomId;
		private String hotelName;
		private String hotelContact;
		private String roomType;
		private String roomRent;
		
		public String getHotelName() {
			return hotelName;
		}
		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		public String getHotelContact() {
			return hotelContact;
		}
		public void setHotelContact(String hotelContact) {
			this.hotelContact = hotelContact;
		}
		public String getRoomType() {
			return roomType;
		}
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
		public String getRoomRent() {
			return roomRent;
		}
		public void setRoomRent(String roomRent) {
			this.roomRent = roomRent;
		}
		public String getRoomId() {
			return roomId;
		}
		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}
		
		
		@Override
		public String toString() {
			return "Hotel [roomId=" + roomId + ", hotelName=" + hotelName + ", hotelContact=" + hotelContact
					+ ", roomType=" + roomType + ", roomRent=" + roomRent + "]";
		}
	
		
}
