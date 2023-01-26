package com.project.runnerclub.entities;

import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long userId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false,insertable=false, updatable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	User user;
	
	String startingLocation;
	String destination;
	int hour;
	String status;
	int seatNo;
	
	static String pattern = "yyyy/MM/dd";
	SimpleDateFormat date = new SimpleDateFormat(pattern);
	
	
}
