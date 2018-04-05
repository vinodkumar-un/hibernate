package com.ta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ta.delegate.JourneyDelegate;
import com.ta.valueobjects.BusVO;
import com.ta.valueobjects.StaffVO;

public class ViewNewJourneyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<BusVO> buses = null;
		List<StaffVO> staff = null;
		JourneyDelegate delegate = null;
		RequestDispatcher dispatcher = null;

		delegate = new JourneyDelegate();
		buses = delegate.getAllBuses();
		staff = delegate.getAllStaff();

		request.setAttribute("buses", buses);
		request.setAttribute("staff", staff);

		dispatcher = request.getRequestDispatcher("new_journey.jsp");
		dispatcher.forward(request, response);
	}

}
