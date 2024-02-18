package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");  // 들어오는 데이터를 UTF-8로 해석
    resp.setCharacterEncoding("UTF-8"); // HTML의 인코을 UTF-8로 해석
    resp.setContentType("text/html; charset=utf-8");  // 브라우저에게 결과물이 UTF-8이라고 말하는 의미

    int dan = Integer.parseInt(req.getParameter("dan"));  // ?dan=9

    resp.getWriter().append("<h>%d단</h1>\n".formatted(dan));

    for (int i = 1; i <= 9; i++) {
      resp.getWriter().append("<div>%d * %d = %d</div>\n".formatted(dan, i, dan * i));
    }
  }
}
