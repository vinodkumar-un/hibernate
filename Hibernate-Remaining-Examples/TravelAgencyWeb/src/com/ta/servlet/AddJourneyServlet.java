package com.ta.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ta.delegate.JourneyDelegate;
import com.ta.valueobjects.JourneyVO;

public class AddJourneyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		JourneyVO journey = null;
		JourneyDelegate delegate = null;
		RequestDispatcher dispatcher = null;

		journey = new JourneyVO();
		journey.setSource(request.getParameter("source"));
		journey.setDestination(request.getParameter("destination"));
		journey.setDateOfJourney(request.getParameter("doj"));
		journey.setBusNo(request.getParameter("bus"));
		String staff[] = request.getParameterValues("staff");
		journey.setStaff(staff);

		delegate = new JourneyDelegate();
		try {
			delegate.saveJourney(journey);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dispatcher = request.getRequestDispatcher("journey_created.jsp");
		dispatcher.forward(request, response);
	}
}
