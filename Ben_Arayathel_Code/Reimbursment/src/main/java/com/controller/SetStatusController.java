package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAO;
import com.model.User;

public class SetStatusController {
	
	public static void printUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\r\n" + 
				"    <title>EMPLOYEE LOGIN</title>\r\n" + 
				"\r\n" + 
				"    <link rel = \"stylesheet\"  type = \"text/css\" href=\"../css/UserStyle.css\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"    <div class=\"flex-container\">\r\n" + 
				"        <div class = \"row\">\r\n" + 
				"            <div class = \"col-sm-4\">\r\n" + 
				"                <div class = \"container pt-3\">\r\n" + 
				"                <form method=\"POST\" action=\"RegisterTicket.do\" id=\"RegisterForm\">\r\n" + 
				"                    <select name=\"status\">\r\n" + 
				"                        <option value = \"LODGE\">LODGE</option>\r\n" + 
				"                        <option value = \"TRAVEL\">TRAVEL</option>\r\n" + 
				"                        <option value = \"FOOD\">FOOD</option>\r\n" + 
				"                        <option value = \"OTHER\">OTHER</option>\r\n" + 
				"                    </select><br>\r\n" + 
				"                    <input class = \"textsubmit\" type=\"number\" name = \"price\" placeholder=\"How much did you spend in dollars?\"><br>\r\n" + 
				"                    <textarea name = \"Description\" placeholder=\"description\"></textarea><br>\r\n" + 
				"                    <button type=\"submit\" class=\"btn btn-primary\" id=\"submit\">SUBMIT!!</button>\r\n" + 
				"                </form>\r\n" + 
				"                <br>\r\n" + 
				"                <button class = \"btn btn-secondary\" id = \"logout\"><a href =\"file:///C:/Users/benBF/OneDrive/Documents/VisualStudioCode/MainLogin.html\" >LOGOUT</a></button>\r\n" + 
				"            </div>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\".col-sm-8\">\r\n" + 
				"                <table class = \"table table-bordered\">\r\n" + 
				"                    <thead class = \"thread-dark\">\r\n" + 
				"                        <tr>\r\n" + 
				"                            <th>Status</th>\r\n" + 
				"                            <th>ID</th>\r\n" + 
				"                            <th>Cost</th>\r\n" + 
				"                            <th>Type</th>\r\n" + 
				"                            <th>TIMESTAMP</th>\r\n" + 
				"                            <th>Email</th>\r\n" + 
				"                            <th>Description</th>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </thead>\r\n" + 
				"                    <tr class = \"table-warning\">\r\n" + 
				"                        <td>\r\n" + 
				"                            <form method = \"POST\" action = \"SetStatus.do\">\r\n" + 
				"                                <select name=\"status\">\r\n" + 
				"                                    <option value = \"approve\">Approve</option>\r\n" + 
				"                                    <option value = \"deny\">Deny</option>\r\n" + 
				"                                </select>\r\n" + 
				"                                <button type=\"button\" class=\"btn btn-primary\">SUBMIT!!</button>\r\n" + 
				"                            </form>\r\n" + 
				"                        </td>\r\n" + 
				"                        <td>3</td>\r\n" + 
				"                        <td>£12</td>\r\n" + 
				"                        <td>TRAVEL</td>\r\n" + 
				"                        <td>12/12/12</td>\r\n" + 
				"                        <td>blah@blah.com</td>\r\n" + 
				"                        <td>blah blah blahasdfa </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                    <tr class = \"table-success\">\r\n" + 
				"                        <td>Approved</td>\r\n" + 
				"                        <td>3</td>\r\n" + 
				"                        <td>£12</td>\r\n" + 
				"                        <td>TRAVEL</td>\r\n" + 
				"                        <td>12/12/12</td>\r\n" + 
				"                        <td>blah@blah.com</td>\r\n" + 
				"                        <td>blah blah blah</td>\r\n" + 
				"                    </tr>\r\n" + 
				"                </tr>\r\n" + 
				"                </table>\r\n" + 
				"            </div>\r\n" + 
				"        </div>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"    <!--<script type = \"text/javascript\" src = \"Ajaxexample.js\"></script>-->\r\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	public static String setStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		try {
			HttpSession session = request.getSession();
			DAO dao = (DAO) session.getAttribute("dao");
			User u = (User) session.getAttribute("user");
			String id = request.getParameter("id"); // ?????????????
			String status = request.getParameter("status");
			if (dao == null || u == null) {
				System.out.printf("LOGIN FIRST\n");
				return "./login.html";
			}
			if (id == null || status == null) {
				System.out.printf("PARAMETERS NOT PASSED IN PROPERLY\nid: %s status: %s", id, status);
				return "./employee.html";
			}
			if (!dao.modTicket(Integer.valueOf(id), (Integer.valueOf(status)==1)?true:false)) {
				System.out.printf("TICKET MODIFICATION FAILURE\n");
				return "./employee.html";
			}
		}catch(Exception e) { System.out.printf("%s\n", e.getMessage()); }
		return "./employee.html";
		
		
		
		
		//return "./manager.html";
	}

}
