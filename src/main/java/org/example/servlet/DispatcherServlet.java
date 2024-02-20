package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Rq;
import org.example.article.ArticleController;
import org.example.member.MemberController;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    MemberController memberController = new MemberController();
    ArticleController articleController = new ArticleController();

    String url = req.getRequestURI();

    switch (url) {
      case "/usr/article/list/free":
        articleController.showList(rq);
        break;
      case "/usr/member/login":
        memberController.showLogin(rq);
        break;
    }
  }
}
