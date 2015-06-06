/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   Author     : Sherwin, Heemesh, Jas
 */
package a2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sherwin
 */
public class AddServlet extends HttpServlet 
{
    private Connection conn;
    //private Statement stmt;
    private ArticlesBean articlesBean;
    private String dbDriver;
    private String dbUrl;
    private String dbTable;
    private String dbArticleName;
    private String dbAuthor;
    private String dbJournal;
    private String dbYearPublished;
    private String dbCategory;
    private String userName;
    private String passWord;
    public static String year;
    public static String category;
    
    public AddServlet() throws SQLException, ClassNotFoundException, IOException
    {
        Properties properties = new Properties();
        properties.loadFromXML(getClass().getResourceAsStream("ArticlesServletConfig.xml"));
        dbDriver = properties.get("dbDriver").toString();
        dbUrl = properties.get("dbUrl").toString();
        dbTable = properties.get("dbTable").toString();
        dbArticleName = properties.get("dbArticleName").toString();
        dbAuthor = properties.get("dbAuthor").toString();
        dbJournal = properties.get("dbJournal").toString();
        dbYearPublished = properties.get("dbYearPublished").toString();
        dbCategory = properties.get("dbCategory").toString();
        userName = properties.get("user").toString();
        passWord = properties.get("password").toString();
        //Class.forName(dbDriver);
        //conn = DriverManager.getConnection(dbUrl, userName, passWord);
        //stmt = conn.prepareStatement("SELECT * FROM " + dbTable + " WHERE " + dbFries + " = ? AND " +
                    //dbOil +" = ?"); 
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //processRequest(request, response);
      String articleName = request.getParameter("ArticleName");
      String articleAuthor = request.getParameter("ArticleAuthor");
      String journal = request.getParameter("Journal");
      String category = request.getParameter("category");
      String yearPublished = request.getParameter("YearPublished");
      String researchLevel = request.getParameter("ResearchLevel");
      String credibilityRating = request.getParameter("first");
      String usersName = request.getParameter("UsersName");
      String commentReason = request.getParameter("CommentReason");
      String result = request.getParameter("Result");
      
      if(articleName == null || articleAuthor == null || category == null || yearPublished == null)
      {
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Addjsp.jsp");
          dispatcher.forward(request, response);
      }
      else
      {
          conn = null;
          
          response.setContentType("text/html");
          
          try
          {
              Class.forName(dbDriver);
              conn = (Connection) DriverManager.getConnection(dbUrl, userName, passWord);
              
              String sqlArticles = "INSERT INTO " +dbTable+ " VALUES ('" +journal+ "', '" +articleName+ "',  '" +articleAuthor+ "',  '" +yearPublished+ "',  '" +category+ "',  '" +credibilityRating+ "',  '"
                      +commentReason+ "', '" +usersName+ "', '" +researchLevel+ "', '" +result+ "')";
              Statement stArticles = (Statement) conn.createStatement();
                
              stArticles.executeUpdate(sqlArticles);
              
              stArticles.close();
              
          }
          catch(Exception e)
          {
              System.out.println("Exception is : " + e);
              e.getStackTrace();
          }
          
          RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Search.jsp");
            if(dispatcher != null)
                dispatcher.forward(request, response);
      }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doGet(request, response);
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
