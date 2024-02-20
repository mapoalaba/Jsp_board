package org.example.article;

import org.example.Rq;

public class ArticleController {
  public void showList(Rq rq) {
    rq.appendBody("게시물 리스트");
  }

  public void showLogin(Rq rq) {
    rq.appendBody("로그인");
  }
}
