package edu.vt.ece5574.gae;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class log extends HttpServlet {
	static Integer cx = 0;
	static Integer cy = 0;
	static String cAgent = "";
	static String cId = "";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<String> list = new ArrayList<String>();
	    list.add(cAgent);
	    list.add(cId);
	    list.add(Integer.toString(cx));
	    list.add(Integer.toString(cy));
	    String json = new Gson().toJson(list);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	    System.out.println("do get called inside logservelet");
	}
	
	public static void updateEvent(String Agent, String Id, int x, int y){
		cAgent = Agent;
		cId = Id;
		cx = x;
		cy = y;
	}

}