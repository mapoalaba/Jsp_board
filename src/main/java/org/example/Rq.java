package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.article.dto.ArticleDto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Rq {

  private final HttpServletRequest req;

  private final HttpServletResponse resp;
  public Rq(HttpServletRequest req, HttpServletResponse resp) {

    this.req = req;
    this.resp = resp;

    try {
      req.setCharacterEncoding("UTF-8");  // 들어오는 데이터를 UTF-8로 해석
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    resp.setCharacterEncoding("UTF-8"); // HTML의 인코을 UTF-8로 해석
    resp.setContentType("text/html; charset=utf-8");  // 브라우저에게 결과물이 UTF-8이라고 말하는 의미
  }

  public int getIntparam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(value);
    }
    catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getIntparam(String paramName, String defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null) {
      return defaultValue;
    }
    return value;
  }

  public void appendBody(String str) {
    try {
      resp.getWriter().append(str);
    }
    catch (IOException e) {
      throw new RuntimeException(e);  // 문제가 생기면 중지
    }
  }

  public void setAttr(String name, Object value) {
    req.setAttribute(name, value);
  }

  public void view(String path) {
    // 서블릿에서 JSP에 작업을 토스
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");

    try {
      requestDispatcher.forward(req, resp);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
