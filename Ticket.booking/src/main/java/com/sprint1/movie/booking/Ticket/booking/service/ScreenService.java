package com.sprint1.movie.booking.Ticket.booking.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.Ticket.booking.entities.Screen;

@Component
public interface ScreenService {
	public Screen addScreen(Screen screen);
	@Transactional
	public Screen updateScreen(Screen screen);
	public Screen removeScreen(Screen screen);
	public Screen viewScreenById(int screenId);
	public List<Screen>viewScreenListAll();
	public List<Screen>viewScreenList(int theatreId);
}
