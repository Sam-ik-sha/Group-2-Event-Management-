package com.group2.event_management.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Event")
public class Event {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer eventId;
		@Column(name="Event_name")
		private String eventName;
		@Column(name="Description")
		private String description;
		@Column(name="Location")
		private String location;
		@Column(name="Start_date")
		private LocalDate startDate;
		@Column(name="End_date")
		private LocalDate endDate;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public String getEventName() {
			return eventName;
		}
		public void setEventName(String eventName) {
			this.eventName = eventName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		@Override
		public String toString() {
			return "Event [id: " + eventId + "\n EventName: " + eventName +"\n Description: " + description + "\n Location: " + location+"\n Start Date: "+startDate +"\n End Date: " + endDate+"]";
		}
		
}
