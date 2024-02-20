package org.example.article;

import org.example.Rq;
import org.example.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
  public void showList(Rq rq) {
    List<ArticleDto> articleDtos = new ArrayList<>();

    for (int i = 5; i >= 1; i--) {
      articleDtos.add(new ArticleDto(i, "제목" + i, "내용" + i));
    }

    rq.setAttr("articles", articleDtos);
    rq.view("usr/article/list");
  }
}
