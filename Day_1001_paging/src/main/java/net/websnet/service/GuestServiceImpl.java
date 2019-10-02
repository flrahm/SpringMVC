package net.websnet.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.websnet.domain.GuestVO;
import net.websnet.domain.PageVO;
import net.websnet.mapper.GuestMapper;


@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

	private static final Logger log = LoggerFactory.getLogger(GuestServiceImpl.class);
	
	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;
	
	@Override
	public List<GuestVO> guestList() {
		// TODO Auto-generated method stub
		log.info("guestList()....");
		return mapper.guestList();
	}
	
	@Override
	public int guestCount() {
		// TODO Auto-generated method stub
		return mapper.guestCount();
	}
	
	@Override
	public List<GuestVO> guestList_paged(PageVO pvo) {
		// TODO Auto-generated method stub
		return mapper.guestList_paged(pvo);
	}
	
}
