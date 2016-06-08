package ee.ttu.idu0200.web.controller;

import ee.ttu.idu0200.web.dao.ArticleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article/s")
public class ArticleListController {

  private Logger LOG = LogManager.getLogger(ArticleController.class);


  @Autowired
  private ArticleDao articleDao;

  @RequestMapping
  public String findAll(Model model) {
    model.addAttribute("articleList", articleDao.findAll());

    LOG.info("Opening the list of articles");

    return "article/articleList";
  }
}
