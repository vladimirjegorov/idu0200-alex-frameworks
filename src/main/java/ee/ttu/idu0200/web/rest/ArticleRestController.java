package ee.ttu.idu0200.web.rest;

import ee.ttu.idu0200.web.dao.ArticleDao;
import ee.ttu.idu0200.web.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/article/articleservice")
public class ArticleRestController {

  @Autowired
  private ArticleDao articleDao;

  @RequestMapping
  public Article findArticle(@RequestParam long id) {
    return articleDao.findOne(id);
  }
}
