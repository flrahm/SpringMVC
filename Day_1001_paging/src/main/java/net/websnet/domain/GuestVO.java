package net.websnet.domain;

import lombok.Data;

@Data
public class GuestVO {
	
	private int idx;
	private String name;
	private String subject;
	private String contents;
	private String indate;
	private int readcnt;
	
	
	
}
