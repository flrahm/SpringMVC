package net.websnet.service;

import java.util.List;

import net.websnet.domain.GuestVO;
import net.websnet.domain.PageVO;

public interface GuestService {
	
	// whole page count
		public int guestCount();
		
		public List<GuestVO> guestList_paged(PageVO pvo);
	
	public List<GuestVO> guestList();
	
	
}
