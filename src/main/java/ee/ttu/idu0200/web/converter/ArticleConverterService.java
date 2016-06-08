package ee.ttu.idu0200.web.converter;


import ee.ttu.idu0200.web.domain.Article;
import ee.ttu.idu0200.web.form.ArticleForm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

//import static org.apache.commons.lang3.time.DateUtils.parseDate;

@Service
public class ArticleConverterService {

//  public ArticleForm toArticleForm(HttpServletRequest request) {
//    ArticleForm articleForm = new ArticleForm();
//    articleForm.setId(request.getParameter("id"));
//    articleForm.setTitle(request.getParameter("title"));
//    articleForm.setPublishedDate(request.getParameter("publishedDate"));
//    articleForm.setContent(request.getParameter("content"));
//
//    return articleForm;
//  }

  public ArticleForm toArticleForm(Article article) {
    ArticleForm articleForm = new ArticleForm();
    articleForm.setId(article.getId());
    articleForm.setTitle(article.getTitle());
    articleForm.setPublishedDate(article.getPublishedDate());
    articleForm.setContent(article.getContent());
    return articleForm;
  }

  public Article toArticle(ArticleForm articleForm) {
    Article article = new Article();
    article.setId(articleForm.getId());
    article.setTitle(articleForm.getTitle());
    article.setPublishedDate(articleForm.getPublishedDate());
    article.setContent(articleForm.getContent());

    return article;
  }
}
