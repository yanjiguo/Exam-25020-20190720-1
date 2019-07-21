package com.yjg.servlet;

import com.yjg.bean.Film;
import com.yjg.dao.MovieRental;
import com.yjg.dao.impl.MovieRentalImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description:跳转到修改页面，并且把电影信息带过去
 */
@WebServlet("/skipUpdateFilmPage")
public class SkipUpdateFilmPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式，统一使用utf-8
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //转为int类型
        int filmId = Integer.parseInt(req.getParameter("filmId"));
        //通过电影id获取电影的信息
        MovieRental movieRental = new MovieRentalImpl();
        Film film = movieRental.selectOneFilm(filmId);
        req.setAttribute("film", film);
        req.getRequestDispatcher("updateFilm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
