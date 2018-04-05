package com.ta.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ta.delegate.JourneyDelegate;
import com.ta.valueobjects.JourneyVO;

public class ViewBuyTicketServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<JourneyVO> journeys = null;
		JourneyDelegate delegate = null;
		RequestDispatcher dispatcher = null;
		Calendar calendar = null;
		Date nextWeekDate = null;

		delegate = new JourneyDelegate();
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 7);
		nextWeekDate = calendar.getTime();

		journeys = delegate.getAllJourneys(new Date(), nextWeekDate);
		request.setAttribute("journeys", journeys);

		dispatcher = request.getRequestDispatcher("buy_ticket.jsp");
		dispatcher.forward(request, response);
	}

}
