package ee.ttu.idu0200.web.dao;

import ee.ttu.idu0200.web.domain.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends CrudRepository<Article, Long> {
}
