package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");  // 들어오는 데이터를 UTF-8로 해석
    resp.setCharacterEncoding("UTF-8"); // HTML의 인코을 UTF-8로 해석
    resp.setContentType("text/html; charset=utf");  // 브라우저에게 결과물이 UTF-8이라고 말하는 의미
    resp.getWriter().append("HI");
  }
}
