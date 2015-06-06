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
public class ArticlesBean implements Serializable 
{
    private List articleYearList;
    private List articleCategoryList;
    private List articleNameList;
    private List articleAuthorList;
    private List articleJournalList;
    private List articleCredibilityList;
    private List articleReasonList;
    private List articleRatedList;
    private List articleResearchLevelList;
    private List articleResultList;

    public ArticlesBean()
    {
        articleYearList = null;
        articleCategoryList = null;
        articleNameList = null;
        articleAuthorList = null;
        articleJournalList = null;
        articleCredibilityList = null;
        articleReasonList = null;
        articleRatedList = null;
    }
    
    public List getArticleYearList()
    {
        return articleYearList;
    }
    
    public void setArticleYearList(List articleYearList)
    {
        this.articleYearList = articleYearList;
    }
    
    public List getArticleCategoryList(){
        return articleCategoryList;
    }
    
    public void setArticleCategoryList(List articleCategoryList)
    {
        this.articleCategoryList = articleCategoryList;
    }
    
    public List getArticleNameList()
    {
        return articleNameList;
    }

    public void setArticleNameList(List articleNameList)
    {
        this.articleNameList = articleNameList;
    }

    public List getArticleAuthorList()
    {
        return articleAuthorList;
    }

    public void setArticleAuthorList(List articleAuthorList)
    {
        this.articleAuthorList = articleAuthorList;
    }

    public List getArticleJournalList()
    {
        return articleJournalList;
    }

    public void setArticleJournalList(List articleJournalList) 
    {
        this.articleJournalList = articleJournalList;
    }

    public List getArticleCredibilityList() 
    {
        return articleCredibilityList;
    }

    public void setArticleCredibilityList(List articleCredibilityList) 
    {
        this.articleCredibilityList = articleCredibilityList;
    }

    public List getArticleReasonList() 
    {
        return articleReasonList;
    }

    public void setArticleReasonList(List articleReasonList) 
    {
        this.articleReasonList = articleReasonList;
    }

    public List getArticleRatedList()
    {
        return articleRatedList;
    }

    public void setArticleRatedList(List articleRatedList)
    {
        this.articleRatedList = articleRatedList;
    }

    public List getArticleResearchLevelList() 
    {
        return articleResearchLevelList;
    }

    public void setArticleResearchLevelList(List articleResearchLevelList) 
    {
        this.articleResearchLevelList = articleResearchLevelList;
    }

    public List getArticleResultList() 
    {
        return articleResultList;
    }

    public void setArticleResultList(List articleResultList) 
    {
        this.articleResultList = articleResultList;
    }
}

    
