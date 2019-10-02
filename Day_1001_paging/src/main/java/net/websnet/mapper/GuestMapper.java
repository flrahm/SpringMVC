package net.websnet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import net.websnet.domain.GuestVO;
import net.websnet.domain.PageVO;

public interface GuestMapper {
	
	// whole page count
	public int guestCount();
	
	public List<GuestVO> guestList_paged(PageVO pvo);
	
	
	
	//@Select("select * from guest_tbl")
	public List<GuestVO> guestList();
}
