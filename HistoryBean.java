/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   Author     : Sherwin, Heemesh, Jas
 */
package a2;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Sherwin
 */
public class HistoryBean implements Serializable 
{
    private List articleHistoryYearList;
    private List articleHistoryCategoryList;
    private int searchedTimes;
    
    public HistoryBean()
    {
        articleHistoryYearList = null;
        articleHistoryCategoryList = null;
        searchedTimes = 0;
    }

    public List getArticleHistoryYearList() 
    {
        return articleHistoryYearList;
    }

    public void setArticleHistoryYearList(List articleHistoryYearList) 
    {
        this.articleHistoryYearList = articleHistoryYearList;
    }

    public List getArticleHistoryCategoryList()
    {
        return articleHistoryCategoryList;
    }

    public void setArticleHistoryCategoryList(List articleHistoryCategoryList)
    {
        this.articleHistoryCategoryList = articleHistoryCategoryList;
    }

    public int getSearchedTimes() 
    {
        return searchedTimes;
    }

    public void setSearchedTimes(int searchedTimes)
    {
        this.searchedTimes = searchedTimes;
    }
    
}
