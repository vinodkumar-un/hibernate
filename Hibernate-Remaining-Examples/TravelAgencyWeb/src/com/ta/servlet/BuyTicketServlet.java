package com.ta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ta.delegate.JourneyDelegate;
import com.ta.valueobjects.TicketVO;

public class BuyTicketServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isExistingPassenger = false;
		JourneyDelegate delegate = null;
		RequestDispatcher dispatcher = null;
		TicketVO ticket = null;
		int ticketNo = 0;

		ticket = new TicketVO();
		if (request.getParameter("passengerId") != null
				&& request.getParameter("passengerId").trim().length() > 0) {
			ticket.setPassengerId(request.getParameter("passengerId"));
			isExistingPassenger = true;
		} else {
			ticket.setFirstNm(request.getParameter("firstNm"));
			ticket.setLastNm(request.getParameter("lastNm"));
			ticket.setAge(request.getParameter("age"));
			ticket.setGender(request.getParameter("gender"));
		}
		ticket.setJourneyId(request.getParameter("journeyId"));
		delegate = new JourneyDelegate();

		if (isExistingPassenger) {
			ticketNo = delegate.newTicket(ticket.getPassengerId(),
					ticket.getJourneyId());
		} else {
			ticketNo = delegate.newTicket(ticket);
		}
		ticket.setTicketNo(String.valueOf(ticketNo));
		request.setAttribute("ticket", ticket);
		dispatcher = request.getRequestDispatcher("ticket_details.jsp");
		dispatcher.forward(request, response);
	}

}
