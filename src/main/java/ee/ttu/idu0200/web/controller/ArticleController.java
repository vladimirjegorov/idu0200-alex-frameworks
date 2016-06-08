package ee.ttu.idu0200.web.controller;

import ee.ttu.idu0200.web.converter.ArticleConverterService;
import ee.ttu.idu0200.web.dao.ArticleDao;
import ee.ttu.idu0200.web.domain.Article;
import ee.ttu.idu0200.web.form.ArticleForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

import static java.lang.String.format;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/article/s")
public class ArticleController {

  private Logger LOG = LogManager.getLogger(ArticleController.class);

  @Autowired
  private ArticleDao articleDao;
  @Autowired
  private ArticleConverterService articleConverterService;

  @RequestMapping(method = GET, params = "id")
  public String findArticle(@RequestParam long id, Model model) {
    ArticleForm articleForm;
    if (model.containsAttribute("articleForm")) {
      articleForm = (ArticleForm) model.asMap().get("articleForm");
    } else {
      Article article = articleDao.findOne(id);

      if (article == null) {
        return "article/articleNotFound";
      }
      LOG.info(format("Opening form for article with id: %s", article.getId()));
      articleForm = articleConverterService.toArticleForm(article);
    }

    model.addAttribute("article", articleForm);

    return "article/article";
  }

  @RequestMapping(method = POST, params = "action=save")
  public RedirectView updateArticle(RedirectAttributes ra, @Valid ArticleForm articleForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      ra.addFlashAttribute("org.springframework.validation.BindingResult.article", bindingResult);
      ra.addFlashAttribute("articleForm", articleForm);
    } else {
      Article article = articleConverterService.toArticle(articleForm);
      LOG.info(format("Updating article with id: %s", article.getId()));
      articleDao.save(article);

      ra.addFlashAttribute("successMessage", "success");
    }

    // will redirect to findArticle()
    RedirectView redirectView = new RedirectView("/article/s", true);
    // will keep the 'id' parameter in url after redirect
    ra.addAttribute("id", articleForm.getId());

    return redirectView;
  }
}
