/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   Author: Sherwin, Heemesh, Jas
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
public class ServletOne extends HttpServlet
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
    private String dbRating;
    private String dbReason;
    private String dbUsername;
    private String dbResearchLevel;
    private String dbResult;
    public static String year;
    public static String category;
    private final String SELECT = "select";
    private final String NULL= "null";
    
     public ServletOne() throws SQLException, ClassNotFoundException, IOException
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
        dbRating = properties.get("dbRating").toString();
        dbReason = properties.getProperty("dbReason").toString();
        dbUsername = properties.getProperty("dbUsername").toString();
        dbResearchLevel = properties.getProperty("dbResearchlevel").toString();
        dbResult = properties.getProperty("dbResult").toString();
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
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletOne</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletOne at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

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
        year = request.getParameter("year");
        category = request.getParameter("category");
        if(year == null || category ==  null)
        {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Search.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            
            articlesBean = new ArticlesBean();
            
            List articleYearList = new ArrayList();
            List articleCategoryList = new ArrayList();
            List articleNameList = new ArrayList();
            List articleAuthorList = new ArrayList();
            List articleJournalList = new ArrayList();
            List articleRatingList = new ArrayList();
            List articleReasonList = new ArrayList();
            List articleRatedList = new ArrayList();
            List articleResearchLevelList = new ArrayList();
            List articleResultList = new ArrayList();
            
            
            conn = null;
            ResultSet rsArticles;
            
            response.setContentType("text/html");
            
            try
            {
                Class.forName(dbDriver);
                conn = (Connection) DriverManager.getConnection(dbUrl, userName, passWord);
                
                //String sqlArticles = "select * from " +dbTable+ " WHERE " +dbYearPublished+ " = '" +year+ "' AND " +dbCategory+ " = " +category;
                //String sqlArticles = "SELECT " +dbArticleName+ ", " +dbAuthor+  " FROM " +dbTable+ " WHERE " +dbYearPublished+ " = " + "'"+year+"'" + " AND " +dbCategory+ " = " + "'"+category+"'";  
                String sqlArticles = "SELECT " +dbJournal+ ", " +dbArticleName+ ", " +dbAuthor+ ", " +dbYearPublished+ ", " + dbCategory+ ", " +dbRating+ ", " +dbReason+ ", " +dbUsername+ ", " +dbResearchLevel+ ", " +dbResult+ " FROM " +dbTable+ " WHERE " +dbYearPublished+ " = " + "'"+year+"'" + " AND " +dbCategory+ " = " + "'"+category+"'";
                Statement stArticles = (Statement) conn.createStatement();
                
                stArticles.executeQuery(sqlArticles);
                
                rsArticles = stArticles.getResultSet();
                
                while(rsArticles.next())
                {
                    Logger.getLogger("ServletOne").log(Level.INFO, "ResultSet ="+rsArticles.getString(dbJournal) + rsArticles.getString(dbArticleName) + rsArticles.getString(dbAuthor) + rsArticles.getString(dbYearPublished) + rsArticles.getString(dbCategory) + rsArticles.getString(dbRating) + rsArticles.getString(dbReason) + rsArticles.getString(dbUsername) + rsArticles.getString(dbResearchLevel) + rsArticles.getString(dbResult));
                    //Logger.getLogger("ServletOne").log(Level.INFO, "ResultSet ="+rsArticles.getString(dbYearPublished) + rsArticles.getString(dbCategory));
                    
                    articleJournalList.add(rsArticles.getString(dbJournal));
                    articleNameList.add(rsArticles.getString(dbArticleName));
                    articleAuthorList.add(rsArticles.getString(dbAuthor));
                    articleYearList.add(rsArticles.getString(dbYearPublished));
                    articleCategoryList.add(rsArticles.getString(dbCategory));
                    articleRatingList.add(rsArticles.getString(dbRating));
                    articleReasonList.add(rsArticles.getString(dbReason));
                    articleRatedList.add(rsArticles.getString(dbUsername));
                    articleResearchLevelList.add(rsArticles.getString(dbResearchLevel));
                    articleResultList.add(rsArticles.getString(dbResult));
                }
                
                articlesBean.setArticleJournalList(articleJournalList);
                articlesBean.setArticleNameList(articleNameList);
                articlesBean.setArticleAuthorList(articleAuthorList);
                articlesBean.setArticleYearList(articleYearList);
                articlesBean.setArticleCategoryList(articleCategoryList);
                articlesBean.setArticleCredibilityList(articleRatingList);
                articlesBean.setArticleReasonList(articleReasonList);
                articlesBean.setArticleRatedList(articleRatedList);
                articlesBean.setArticleResearchLevelList(articleResearchLevelList);
                articlesBean.setArticleResultList(articleResultList);
                
                rsArticles.close();
                stArticles.close();
            }
            catch(Exception e)
            {
                System.out.println("Exception is : " + e);
                e.getStackTrace();
            }
            
            HttpSession session = request.getSession();
            session.setAttribute("articlesBeanAttributes", articlesBean);
            
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/SearchResults.jsp");
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
    
    /*public ArticlesBean getArticlesBeanProperties(String year, String category, HttpServletResponse response)
            throws ServletException, IOException 
    {
            articlesBean = new ArticlesBean();
            
            List articleYearList = new ArrayList();
            List articleCategoryList = new ArrayList();            
            
            conn = null;
            ResultSet rsArticles;
            
            response.setContentType("text/html");
            
            try
            {
                Class.forName(dbDriver);
                conn = (Connection) DriverManager.getConnection(dbUrl, userName, passWord);
                
                String sqlArticles = "select * from " +dbTable;
                Statement stArticles = (Statement) conn.createStatement();
                
                stArticles.executeQuery(sqlArticles);
                
                rsArticles = stArticles.getResultSet();
                
                while(rsArticles.next())
                {
                    Logger.getLogger("ServletOne").log(Level.INFO, "ResultSet ="+rsArticles.getString(dbYearPublished) + rsArticles.getString(dbCategory));
                
                    articleYearList.add(rsArticles.getString(dbYearPublished));
                    articleCategoryList.add(rsArticles.getDouble(dbCategory));
                }
                
                articlesBean.setArticleYearList(articleYearList);
                articlesBean.setArticleCategoryList(articleCategoryList);
                
                rsArticles.close();
                stArticles.close();
            }
            catch(Exception e)
            {
                System.out.println("Exception is : " + e);
                e.getStackTrace();
            }
            
            return articlesBean;
    }*/
    
    public void destroy()
    {
        super.destroy();
        try
        {
            if(conn != null)
                conn.close();
        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
    }

}
