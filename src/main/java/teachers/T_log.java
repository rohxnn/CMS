package teachers;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 * Servlet implementation class T_log
 */
@WebServlet("/T_log")
public class T_log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public T_log() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String t_id=(String)session.getAttribute("uname"); 
		PrintWriter out=response.getWriter();
		String br="";
		int c=0;
		
	
		try {
//			  cont.contt();
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://root:_zq27kd-0f5w8g3qfucei-u$pph1onfx@monorail.proxy.rlwy.net:26454/railway","root","_zq27kd-0f5w8g3qfucei-u$pph1onfx");
			  PreparedStatement stmt=con.prepareStatement("select * from staff where t_id='"+t_id+"'");
			 
			  ResultSet rs=stmt.executeQuery();
			  while(rs.next())
			  {
				  br=rs.getString("branch");
				  
				  try {
					  Class.forName("com.mysql.jdbc.Driver");
					   Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
					   PreparedStatement stmt1=con1.prepareStatement("select count(*) from students where s_branch='"+br+"'");
					   ResultSet rs1=stmt1.executeQuery();
					   while(rs1.next())
					   {
						   c=rs1.getInt("count(*)");
					   }
					   
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				  out.println("<!DOCTYPE html>\r\n"
				  		+ "<html lang=\"en\">\r\n"
				  		+ "<head>\r\n"
				  		+ "    <meta charset=\"UTF-8\">\r\n"
				  		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				  		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				  		+ "    <title>Thome</title>\r\n"
				  		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
				  		+ "    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n"
				  		+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n"
				  		+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n"
				  		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\r\n"
				  		+ "    <style>\r\n"
				  		+ "        .container-fluid\r\n"
				  		+ "        {\r\n"
				  		+ "            margin: 0;\r\n"
				  		+ "            padding: 0;\r\n"
				  		+ "\r\n"
				  		+ "        }\r\n"
				  		+ "        .head\r\n"
				  		+ "        {\r\n"
				  		+ "            width: 100%;\r\n"
				  		+ "            height: 100px;\r\n"
				  		+ "            \r\n"
				  		+ "            \r\n"
				  		+ "           \r\n"
				  		+ "        }\r\n"
				  		+ "        #logo {\r\n"
				  		+ "            width: 5%;\r\n"
				  		+ "        }\r\n"
				  		+ "       \r\n"
				  		+ ".hero\r\n"
				  		+ "{\r\n"
				  		+ "    width: 100%;\r\n"
				  		+ "    height: 90vh;\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "}\r\n"
				  		+ ".ab\r\n"
				  		+ "        {\r\n"
				  		+ "            position: absolute;\r\n"
				  		+ "            bottom: 30px;\r\n"
				  		+ "        }\r\n"
				  		+ "        .sidebar {\r\n"
				  		+ "  margin: 0;\r\n"
				  		+ "  padding: 0;\r\n"
				  		+ "  width: 200px;\r\n"
				  		+ "  height: 100%;\r\n"
				  		+ "  overflow: auto;\r\n"
				  		+ "\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "/* Sidebar links */\r\n"
				  		+ ".sidebar a {\r\n"
				  		+ "  display: block;\r\n"
				  		+ "  color:    rgb(19, 17, 17);\r\n"
				  		+ "  padding: 16px;\r\n"
				  		+ "  text-decoration: none;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "/* Active/current link */\r\n"
				  		+ ".sidebar a.active {\r\n"
				  		+ "  background-color: #0e1d93;\r\n"
				  		+ "  color: white;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "/* Links on mouse-over */\r\n"
				  		+ ".sidebar a:hover:not(.active) {\r\n"
				  		+ "  background-color: #555;\r\n"
				  		+ "  color: white;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "/* Page content. The value of the margin-left property should match the value of the sidebar's width property */\r\n"
				  		+ "div.content {\r\n"
				  		+ "  margin-left: 200px;\r\n"
				  		+ "  padding: 1px 16px;\r\n"
				  		+ "  height: 1000px;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "/* On screens that are less than 700px wide, make the sidebar into a topbar */\r\n"
				  		+ "@media screen and (max-width: 700px) {\r\n"
				  		+ "  .sidebar {\r\n"
				  		+ "    width: 100%;\r\n"
				  		+ "    height: auto;\r\n"
				  		+ "    position: relative;\r\n"
				  		+ "  }\r\n"
				  		+ "  .sidebar a {float: left;}\r\n"
				  		+ "  div.content {margin-left: 0;}\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "/* On screens that are less than 400px, display the bar vertically, instead of horizontally */\r\n"
				  		+ "@media screen and (max-width: 400px) {\r\n"
				  		+ "  .sidebar a {\r\n"
				  		+ "    text-align: center;\r\n"
				  		+ "    float: none;\r\n"
				  		+ "  }\r\n"
				  		+ "}\r\n"
				  		+ ".content\r\n"
				  		+ "{\r\n"
				  		+ "    height: fit-content;\r\n"
				  		+ "}\r\n"
				  		+ ":root \r\n"
				  		+ "{\r\n"
				  		+ "    --dark-body: #4d4c5a;\r\n"
				  		+ "    --dark-main: #141529;\r\n"
				  		+ "    --dark-second: #79788c;\r\n"
				  		+ "    --dark-hover: #323048;\r\n"
				  		+ "    --dark-text: #f8fbff;\r\n"
				  		+ "    --light-body: #f3f8fe;\r\n"
				  		+ "    --light-main: #fdfdfd;\r\n"
				  		+ "    --light-second: #c3c2c8;\r\n"
				  		+ "    --light-hover: #edf0f5;\r\n"
				  		+ "    --light-text: #151426;\r\n"
				  		+ "    --blue: #007497;\r\n"
				  		+ "    --white: #fff;\r\n"
				  		+ "    --shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;\r\n"
				  		+ "    --font-family: cursive;\r\n"
				  		+ "}\r\n"
				  		+ ".light {\r\n"
				  		+ "    --bg-body: var(--light-body);\r\n"
				  		+ "    --bg-main: var(--light-main);\r\n"
				  		+ "    --bg-second: var(--light-second);\r\n"
				  		+ "    --color-hover: var(--light-hover);\r\n"
				  		+ "    --color-txt: var(--light-text);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ "\r\n"
				  		+ ".calendar {\r\n"
				  		+ "    height: max-content;\r\n"
				  		+ "    width: max-content;\r\n"
				  		+ "    background-color: var(--bg-main);\r\n"
				  		+ "    border-radius: 30px;\r\n"
				  		+ "    padding: 20px;\r\n"
				  		+ "    position: relative;\r\n"
				  		+ "    overflow: hidden;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".light .calendar {\r\n"
				  		+ "    box-shadow: var(--shadow);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-header {\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "    justify-content: space-between;\r\n"
				  		+ "    align-items: center;\r\n"
				  		+ "    font-size: 25px;\r\n"
				  		+ "    font-weight: 600;\r\n"
				  		+ "    color: var(--color-txt);\r\n"
				  		+ "    padding: 10px;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-body {\r\n"
				  		+ "    padding: 10px;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-week-day {\r\n"
				  		+ "    height: 50px;\r\n"
				  		+ "    display: grid;\r\n"
				  		+ "    grid-template-columns: repeat(7, 1fr);\r\n"
				  		+ "    font-weight: 600;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-week-day div {\r\n"
				  		+ "    display: grid;\r\n"
				  		+ "    place-items: center;\r\n"
				  		+ "    color: var(--bg-second);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days {\r\n"
				  		+ "    display: grid;\r\n"
				  		+ "    grid-template-columns: repeat(7, 1fr);\r\n"
				  		+ "    gap: 2px;\r\n"
				  		+ "    color: var(--color-txt);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div {\r\n"
				  		+ "    width: 50px;\r\n"
				  		+ "    height: 50px;\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "    align-items: center;\r\n"
				  		+ "    justify-content: center;\r\n"
				  		+ "    padding: 5px;\r\n"
				  		+ "    position: relative;\r\n"
				  		+ "    cursor: pointer;\r\n"
				  		+ "    animation: to-top 1s forwards;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span {\r\n"
				  		+ "    position: absolute;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div:hover span {\r\n"
				  		+ "    transition: width 0.2s ease-in-out, height 0.2s ease-in-out;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span:nth-child(1),\r\n"
				  		+ ".calendar-days div span:nth-child(3) {\r\n"
				  		+ "    width: 2px;\r\n"
				  		+ "    height: 0;\r\n"
				  		+ "    background-color: var(--color-txt);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div:hover span:nth-child(1),\r\n"
				  		+ ".calendar-days div:hover span:nth-child(3) {\r\n"
				  		+ "    height: 100%;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span:nth-child(1) {\r\n"
				  		+ "    bottom: 0;\r\n"
				  		+ "    left: 0;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span:nth-child(3) {\r\n"
				  		+ "    top: 0;\r\n"
				  		+ "    right: 0;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span:nth-child(2),\r\n"
				  		+ ".calendar-days div span:nth-child(4) {\r\n"
				  		+ "    width: 0;\r\n"
				  		+ "    height: 2px;\r\n"
				  		+ "    background-color: var(--color-txt);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div:hover span:nth-child(2),\r\n"
				  		+ ".calendar-days div:hover span:nth-child(4) {\r\n"
				  		+ "    width: 100%;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span:nth-child(2) {\r\n"
				  		+ "    top: 0;\r\n"
				  		+ "    left: 0;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div span:nth-child(4) {\r\n"
				  		+ "    bottom: 0;\r\n"
				  		+ "    right: 0;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div:hover span:nth-child(2) {\r\n"
				  		+ "    transition-delay: 0.2s;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div:hover span:nth-child(3) {\r\n"
				  		+ "    transition-delay: 0.4s;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div:hover span:nth-child(4) {\r\n"
				  		+ "    transition-delay: 0.6s;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div.curr-date,\r\n"
				  		+ ".calendar-days div.curr-date:hover {\r\n"
				  		+ "    background-color: var(--blue);\r\n"
				  		+ "    color: var(--white);\r\n"
				  		+ "    border-radius: 50%;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-days div.curr-date span {\r\n"
				  		+ "    display: none;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-picker {\r\n"
				  		+ "    padding: 5px 10px;\r\n"
				  		+ "    border-radius: 10px;\r\n"
				  		+ "    cursor: pointer;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-picker:hover {\r\n"
				  		+ "    background-color: var(--color-hover);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".year-picker {\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "    align-items: center;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".year-change {\r\n"
				  		+ "    height: 40px;\r\n"
				  		+ "    width: 40px;\r\n"
				  		+ "    border-radius: 50%;\r\n"
				  		+ "    display: grid;\r\n"
				  		+ "    place-items: center;\r\n"
				  		+ "    margin: 0 10px;\r\n"
				  		+ "    cursor: pointer;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".year-change:hover {\r\n"
				  		+ "    background-color: var(--color-hover);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".calendar-footer {\r\n"
				  		+ "    padding: 10px;\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "    justify-content: flex-end;\r\n"
				  		+ "    align-items: center;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".toggle {\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".toggle span {\r\n"
				  		+ "    margin-right: 10px;\r\n"
				  		+ "    color: var(--color-txt);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-list {\r\n"
				  		+ "    position: absolute;\r\n"
				  		+ "    width: 100%;\r\n"
				  		+ "    height: 100%;\r\n"
				  		+ "    top: 0;\r\n"
				  		+ "    left: 0;\r\n"
				  		+ "    background-color: var(--bg-main);\r\n"
				  		+ "    padding: 20px;\r\n"
				  		+ "    grid-template-columns: repeat(3, auto);\r\n"
				  		+ "    gap: 5px;\r\n"
				  		+ "    display: grid;\r\n"
				  		+ "    transform: scale(1.5);\r\n"
				  		+ "    visibility: hidden;\r\n"
				  		+ "    pointer-events: none;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-list.show {\r\n"
				  		+ "    transform: scale(1);\r\n"
				  		+ "    visibility: visible;\r\n"
				  		+ "    pointer-events: visible;\r\n"
				  		+ "    transition: all 0.2s ease-in-out;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-list > div {\r\n"
				  		+ "    display: grid;\r\n"
				  		+ "    place-items: center;\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-list > div > div {\r\n"
				  		+ "    width: 100%;\r\n"
				  		+ "    padding: 5px 20px;\r\n"
				  		+ "    border-radius: 10px;\r\n"
				  		+ "    text-align: center;\r\n"
				  		+ "    cursor: pointer;\r\n"
				  		+ "    color: var(--color-txt);\r\n"
				  		+ "}\r\n"
				  		+ "\r\n"
				  		+ ".month-list > div > div:hover {\r\n"
				  		+ "    background-color: var(--color-hover);\r\n"
				  		+ "}\r\n"
				  		+ "      .card_custom :hover{\r\n"
				  		+ "        background-color: #eef4f9;\r\n"
				  		+ "        transition: all 0.3s;\r\n"
				  		+ "        \r\n"
				  		+ "      }\r\n"
				  		+ "      .cal \r\n"
				  		+ "      {\r\n"
				  		+ "        height: fit-content;\r\n"
				  		+ "        position: absolute;\r\n"
				  		+ "        right: 30px;\r\n"
				  		+ "      }\r\n"
				  		+ "      .car\r\n"
				  		+ "      {\r\n"
				  		+ "        width: 20%;\r\n"
				  		+ "    text-align: center;\r\n"
				  		+ "    height: fit-content;\r\n"
				  		+ "    display: flex;\r\n"
				  		+ "    flex-direction: column;\r\n"
				  		+ "    position: relative;\r\n"
				  		+ "    top: 97px;\r\n"
				  		+ "    right: 506px;\r\n"
				  		+ "    \r\n"
				  		+ "      }\r\n"
				  		+ "      .hov1:hover\r\n"
				  		+ "      {\r\n"
				  		+ "        background-color: #eef4f9;\r\n"
				  		+ "        transition: all 0.3s;\r\n"
				  		+ "\r\n"
				  		+ "      }\r\n"
				  		+ "      .tab\r\n"
				  		+ "      {\r\n"
				  		+ "        width: 23%;\r\n"
				  		+ "        height: fit-content;\r\n"
				  		+ "    position: relative;\r\n"
				  		+ "    right: 26%;\r\n"
				  		+ "    top: 15%;\r\n"
				  		+ "    border: solid lightgray;\r\n"
				  		+ "    border-radius: 10px;\r\n"
				  		+ "    border-width: 1px;\r\n"
				  		+ "  \r\n"
				  		+ "     \r\n"
				  		+ "    \r\n"
				  		+ "\r\n"
				  		+ "\r\n"
				  		+ "      }\r\n"
				  		+ "      .tab:hover\r\n"
				  		+ "      {\r\n"
				  		+ "        background-color: #eef4f9;\r\n"
				  		+ "        transition: all 0.3s;\r\n"
				  		+ "      }\r\n"
				  		+ "      #profile\r\n"
				  		+ "      {\r\n"
				  		+ "\r\n"
				  		+ "      }\r\n"
				  		+ "\r\n"
				  		+ "\r\n"
				  		+ "    </style>\r\n"
				  		+ "</head>\r\n"
				  		+ "<body>\r\n"
				  		+ "    <div class=\"container-fluid\">\r\n"
				  		+ "        <div class=\"head\">\r\n"
				  		+ "            <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\r\n"
				  		+ "\r\n"
				  		+ "                    <a class=\"navbar-brand\" href=\"#\">\r\n"
				  		+ "                        <img src=\"https://user-images.githubusercontent.com/85304015/236447598-07f5334f-318b-4260-bf5b-5eb1e1e4cc65.png\"\r\n"
				  		+ "                            alt=\"Bootstrap\" id=\"logo\">\r\n"
				  		+ "        \r\n"
				  		+ "                    </a>\r\n"
				  		+ "                       \r\n"
				  		+ "                   \r\n"
				  		+ "                    <div style=\"display: flex;\">\r\n"
				  		+ "                        <h4 style=\"width: 300px; text-align:right\">Hello "+rs.getString("t_name")+"</h4>\r\n"
				  		+ "                       <img src=\"https://user-images.githubusercontent.com/85304015/240564369-ce187ba1-2052-443c-be1b-c98de3dbee2c.png\"\r\n"
				  		+ "                            alt=\"\" width=\"44\" height=\"44\">\r\n"
				  		+ "                    </div>\r\n"
				  		+ "            </nav>\r\n"
				  		+ "        </div>\r\n"
				  		+ "        <div class=\"hero\">\r\n"
				  		+ "            <div class=\"sidebar\">\r\n"
				  		+ "                <a class=\"active\" href=\"#home\"><b>Dashboard</b> </a>\r\n"
				  		+ "                <a href=\"Myclass\"><b> My Classes</b></a>\r\n"
				  		+ "                <a href=\"#contact\"><b>Team Plans</b> </a>\r\n"
				  		+ "                <a href=\"T_setting\"><b>Settings</b> </a>\r\n"
				  		+ "                <div> <a class=\"ab\" href=\"A_logout\"><b>Logout</b> </a></div>\r\n"
				  		+ "               \r\n"
				  		+ "            </div>\r\n"
				  		+ "              <h1 style=\"color: gray; position: relative; left: 30px;height: fit-content; width: 38%; text-align:right;\">Welcome Back <span style=\"color: black;\">"+rs.getString("t_name")+"</span></h1>\r\n"
				  		+ "              <div class=\"cal\">\r\n"
				  		+ "                <div  class=\"calendar\">\r\n"
				  		+ "                    <div class=\"calendar-header\">\r\n"
				  		+ "                        <span class=\"month-picker\" id=\"month-picker\">April</span>\r\n"
				  		+ "                        <div class=\"year-picker\">\r\n"
				  		+ "                            <span class=\"year-change\" id=\"prev-year\">\r\n"
				  		+ "                                <pre></pre>\r\n"
				  		+ "                            </span>\r\n"
				  		+ "                            <span id=\"year\">2022</span>\r\n"
				  		+ "                            <span class=\"year-change\" id=\"next-year\">\r\n"
				  		+ "                                <pre>></pre>\r\n"
				  		+ "                            </span>\r\n"
				  		+ "                        </div>\r\n"
				  		+ "                    </div>\r\n"
				  		+ "                    <div class=\"calendar-body\">\r\n"
				  		+ "                        <div class=\"calendar-week-day\">\r\n"
				  		+ "                            <div>Sun</div>\r\n"
				  		+ "                            <div>Mon</div>\r\n"
				  		+ "                            <div>Tue</div>\r\n"
				  		+ "                            <div>Wed</div>\r\n"
				  		+ "                            <div>Thu</div>\r\n"
				  		+ "                            <div>Fri</div>\r\n"
				  		+ "                            <div>Sat</div>\r\n"
				  		+ "                        </div>\r\n"
				  		+ "                        <div class=\"calendar-days\"></div>\r\n"
				  		+ "                    </div>\r\n"
				  		+ "                   \r\n"
				  		+ "                    <div class=\"month-list\"></div>\r\n"
				  		+ "                </div>\r\n"
				  		+ "            </div>\r\n"
				  		+ "            <div  class=\"car\">\r\n"
				  		+ "                <div class=\"card text-white bg-info mb-3 hov1\" style=\"max-width: 25rem; border-radius: 50px;\">\r\n"
				  		+ "                    <div class=\"card-body\">\r\n"
				  		+ "                      <h5 class=\"card-title\">Total Lessons</h5>\r\n"
				  		+ "                      <h1 class=\"card-text\">63</h1>\r\n"
				  		+ "                    </div>\r\n"
				  		+ "                  </div>\r\n"
				  		+ "                  <div class=\"card text-white bg-dark mb-3 hov1\" style=\"max-width: 25rem; border-radius: 50px;\" >\r\n"
				  		+ "                    <div class=\"card-body\">\r\n"
				  		+ "                      <h5 class=\"card-title\">Total Students</h5>\r\n"
				  		+ "                      <h1 class=\"card-text\">"+c+"</h1>\r\n"
				  		+ "                    </div>\r\n"
				  		+ "                  </div>\r\n"
				  		+ "                  <div class=\"card text-white bg-warning mb-3 hov1\" style=\"max-width: 25rem; border-radius: 50px;\" >\r\n"
				  		+ "                    <div class=\"card-body\">\r\n"
				  		+ "                      <h5 class=\"card-title\">Total Hours</h5>\r\n"
				  		+ "                      <h1 class=\"card-text\">128</h1>\r\n"
				  		+ "                    </div>\r\n"
				  		+ "                  </div>\r\n"
				  		+ "            </div>\r\n"
				  		+ "           <div class=\"tab\">\r\n"
				  		+ "                <img  style=\"position: relative; left: 55px;\" src=\"https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png\" alt=\"\" id=\"profile\" width=\"60%\"><br><br>\r\n"
//				  		+ "                <div><h4>&nbsp;Id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;"+rs.getString("t_id")+"</h4>\r\n"
//				  		+ "                <h4>&nbsp;Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:"+rs.getString("t_name")+"</h4>\r\n"
//				  		+ "                <h4>&nbsp;Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<span style=\"font-size: small;\">"+rs.getString("t_email")+"</span></h4>\r\n"
//				  		+ "                <h4>&nbsp;Branch&nbsp;&nbsp;&nbsp;&nbsp;:"+rs.getString("branch")+"</h4>\r\n"
//				  		+ "                <h4>&nbsp;Gender&nbsp;&nbsp;&nbsp;:"+rs.getString("sex")+"</h4></div>\r\n"
						+ "  <table>\r\n"
						+ "            <tr>\r\n"
						+ "                <td> <h4>Id</h4></td>\r\n"
						+ "                <td><h4>:</h4></td>\r\n"
						+ "                <td><h4>"+rs.getString("t_id")+"</h4></td>\r\n"
						+ "                </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        <td> <h4>Name</h4></td>\r\n"
						+ "                        <td><h4>:</h4></td>\r\n"
						+ "                        <td><h4>"+rs.getString("t_name")+"</h4></td>\r\n"
						+ "                           \r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        <td> <h4>Email</h4></td>\r\n"
						+ "                        <td><h4>:</h4></td>\r\n"
						+ "                        <td><h4>"+rs.getString("t_email")+"</h4></td>\r\n"
						+ "                        </tr>\r\n"
						+ "                        <tr>\r\n"
						+ "                            <td> <h4>Branch</h4></td>\r\n"
						+ "                            <td><h4>:</h4></td>\r\n"
						+ "                            <td><h4>"+rs.getString("branch")+"</h4></td>\r\n"
						+ "                            </tr>\r\n"
						+ "\r\n"
						+ "                            <tr>\r\n"
						+ "                                <td> <h4>Gender</h4></td>\r\n"
						+ "                                <td><h4>:</h4></td>\r\n"
						+ "                                <td><h4>"+rs.getString("sex")+"</h4></td>\r\n"
						+ "                                </tr>\r\n"
						+ "            </table>"
				  		+ "          \r\n"
				  		+ "           </div>\r\n"
				  		+ "        </div>\r\n"
				  		+ "                <script>let calendar = document.querySelector('.calendar')\r\n"
				  		+ "    \r\n"
				  		+ "                    const month_names = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']\r\n"
				  		+ "                    \r\n"
				  		+ "                    isLeapYear = (year) => {\r\n"
				  		+ "                        return (year % 4 === 0 && year % 100 !== 0 && year % 400 !== 0) || (year % 100 === 0 && year % 400 ===0)\r\n"
				  		+ "                    }\r\n"
				  		+ "                    \r\n"
				  		+ "                    getFebDays = (year) => {\r\n"
				  		+ "                        return isLeapYear(year) ? 29 : 28\r\n"
				  		+ "                    }\r\n"
				  		+ "                    \r\n"
				  		+ "                    generateCalendar = (month, year) => {\r\n"
				  		+ "                    \r\n"
				  		+ "                        let calendar_days = calendar.querySelector('.calendar-days')\r\n"
				  		+ "                        let calendar_header_year = calendar.querySelector('#year')\r\n"
				  		+ "                    \r\n"
				  		+ "                        let days_of_month = [31, getFebDays(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]\r\n"
				  		+ "                    \r\n"
				  		+ "                        calendar_days.innerHTML = ''\r\n"
				  		+ "                    \r\n"
				  		+ "                        let currDate = new Date()\r\n"
				  		+ "                        if (month > 11 || month < 0) month = currDate.getMonth()\r\n"
				  		+ "                        if (!year) year = currDate.getFullYear()\r\n"
				  		+ "                    \r\n"
				  		+ "                        let curr_month = `${month_names[month]}`\r\n"
				  		+ "                        month_picker.innerHTML = curr_month\r\n"
				  		+ "                        calendar_header_year.innerHTML = year\r\n"
				  		+ "                    \r\n"
				  		+ "                        // get first day of month\r\n"
				  		+ "                        \r\n"
				  		+ "                        let first_day = new Date(year, month, 1)\r\n"
				  		+ "                    \r\n"
				  		+ "                        for (let i = 0; i <= days_of_month[month] + first_day.getDay() - 1; i++) {\r\n"
				  		+ "                            let day = document.createElement('div')\r\n"
				  		+ "                            if (i >= first_day.getDay()) {\r\n"
				  		+ "                                day.classList.add('calendar-day-hover')\r\n"
				  		+ "                                day.innerHTML = i - first_day.getDay() + 1\r\n"
				  		+ "                                day.innerHTML += `<span></span>\r\n"
				  		+ "                                                <span></span>\r\n"
				  		+ "                                                <span></span>\r\n"
				  		+ "                                                <span></span>`\r\n"
				  		+ "                                if (i - first_day.getDay() + 1 === currDate.getDate() && year === currDate.getFullYear() && month === currDate.getMonth()) {\r\n"
				  		+ "                                    day.classList.add('curr-date')\r\n"
				  		+ "                                }\r\n"
				  		+ "                            }\r\n"
				  		+ "                            calendar_days.appendChild(day)\r\n"
				  		+ "                        }\r\n"
				  		+ "                    }\r\n"
				  		+ "                    \r\n"
				  		+ "                    let month_list = calendar.querySelector('.month-list')\r\n"
				  		+ "                    \r\n"
				  		+ "                    month_names.forEach((e, index) => {\r\n"
				  		+ "                        let month = document.createElement('div')\r\n"
				  		+ "                        month.innerHTML = `<div data-month=\"${index}\">${e}</div>`\r\n"
				  		+ "                        month.querySelector('div').onclick = () => {\r\n"
				  		+ "                            month_list.classList.remove('show')\r\n"
				  		+ "                            curr_month.value = index\r\n"
				  		+ "                            generateCalendar(index, curr_year.value)\r\n"
				  		+ "                        }\r\n"
				  		+ "                        month_list.appendChild(month)\r\n"
				  		+ "                    })\r\n"
				  		+ "                    \r\n"
				  		+ "                    let month_picker = calendar.querySelector('#month-picker')\r\n"
				  		+ "                    \r\n"
				  		+ "                    month_picker.onclick = () => {\r\n"
				  		+ "                        month_list.classList.add('show')\r\n"
				  		+ "                    }\r\n"
				  		+ "                    \r\n"
				  		+ "                    let currDate = new Date()\r\n"
				  		+ "                    \r\n"
				  		+ "                    let curr_month = {value: currDate.getMonth()}\r\n"
				  		+ "                    let curr_year = {value: currDate.getFullYear()}\r\n"
				  		+ "                    \r\n"
				  		+ "                    generateCalendar(curr_month.value, curr_year.value)\r\n"
				  		+ "                    \r\n"
				  		+ "                    document.querySelector('#prev-year').onclick = () => {\r\n"
				  		+ "                        --curr_year.value\r\n"
				  		+ "                        generateCalendar(curr_month.value, curr_year.value)\r\n"
				  		+ "                    }\r\n"
				  		+ "                    \r\n"
				  		+ "                    document.querySelector('#next-year').onclick = () => {\r\n"
				  		+ "                        ++curr_year.value\r\n"
				  		+ "                        generateCalendar(curr_month.value, curr_year.value)\r\n"
				  		+ "                    }</script>\r\n"
				  		+ "           \r\n"
				  		+ "           \r\n"
				  		+ "              \r\n"
				  		+ "           \r\n"
				  		+ "       \r\n"
				  		+ "    </div>\r\n"
				  		+ "    \r\n"
				  		+ "</body>\r\n"
				  		+ "</html>");
			  }
			  
//			  PreparedStatement stmt2=con.prepareStatement("select s_id,s_name,s_branch from students where s_branch='"+br+"'");
//			  ResultSet rs1=stmt2.executeQuery();
//			  while(rs1.next())
//			  {
//				  out.println("<!DOCTYPE html>\r\n"
//					   		+ "<html lang=\"en\">\r\n"
//					   		+ "<head>\r\n"
//					   		+ "    <meta charset=\"UTF-8\">\r\n"
//					   		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
//					   		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
//					   		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
//					   		+ "\r\n"
//					   		+ "    <title>Show student</title>\r\n"
//					   		+ "    <style>\r\n"
//					   		+ "        .tab\r\n"
//					   		+ "        {\r\n"
//					   		+ "            width: 64%;\r\n"
//					   		+ "        position: absolute;\r\n"
//					   		+ "         left: 20%;\r\n"
//					   		+ "        top: 20%;\r\n"
//					   		+ "        }\r\n"
//					   		+ "\r\n"
//					   		+ "    </style>\r\n"
//					   		+ "</head>\r\n"
//					   		+ "<body>\r\n"
//					   		+ "    <table class=\"table table-striped tab\">\r\n"
//					   		+ "        <thead>\r\n"
//					   		+ "          <tr>\r\n"
//					   		+ "           \r\n"
//					   		+ "            <th scope=\"col\">ID</th>\r\n"
//					   		+ "            <th scope=\"col\">NAME</th>\r\n"
//					   		+ "            <th scope=\"col\">BRANCH</th>\r\n"
//					   		+ "           \r\n"
//					   		+ "          </tr>\r\n"
//					   		+ "        </thead>\r\n");
//					   while(rs1.next())
//					   {
//						   out.println(" <tbody>\r\n"
//						   		+ "                <tr>\r\n"
//						   		+ "\r\n"
//						   		+ "                  <td>"+rs1.getString("s_id")+"</td>\r\n"
//						   		+ "                  <td>"+rs1.getString("s_name")+"</td>\r\n"
//						   		+ "                  <td>"+rs1.getString("s_branch")+"</td>\r\n"
//						   		+ "  				 <td><a href='s_one?uname="+rs1.getString("s_id")+"'><button class=\"btn btn-success\">view</button></a></td>"		
//						   		+ "  				 <td><a href='Up_mark?uname="+rs1.getString("s_id")+"'><button class=\"btn btn-success\">Update</button></a></td>"				
//						   		+ "                  <td><a href='S_del?uname="+rs1.getString("s_id")+"'><button class=\"btn btn-danger\">Delete</button></td>\r\n"
//						   		+ "                </tr>\r\n"
//						   		+ "                </tbody>");
//					   }
//					   id=rs1.getString("s_id");
//			  }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
