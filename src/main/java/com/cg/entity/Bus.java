package com.cg.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bus {
	
		//bus details
		@Id
		private String busId;
		@Column
		private int seats;
		@Column
		private float fare; 
		@Column
		private Time arrivalTime;
		@Column
		private Time departureTime;
		
		//route details
		@Column
		private String src;
		@Column
		private String dest;
		
		public Bus() {
		
			// TODO Auto-generated constructor stub
		}

		public Bus(String busId, int seats, float fare, Time arrivalTime, Time departureTime,
				 String src, String dest) {
			super();
			this.busId = busId;
			this.seats = seats;
			this.fare = fare;
			this.arrivalTime = arrivalTime;
			this.departureTime = departureTime;
			this.src = src;
			this.dest = dest;
		}

		public String getBusId() {
			return busId;
		}

		public void setBusId(String busId) {
			this.busId = busId;
		}

		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}

		public float getFare() {
			return fare;
		}

		public void setFare(float fare) {
			this.fare = fare;
		}

		public Time getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(Time arrivalTime) {
			this.arrivalTime = arrivalTime;
		}

		public Time getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(Time departureTime) {
			this.departureTime = departureTime;
		}

		
		public String getSrc() {
			return src;
		}

		public void setSrc(String src) {
			this.src = src;
		}

		public String getDest() {
			return dest;
		}

		public void setDest(String dest) {
			this.dest = dest;
		}
		
		
		
		
		
}