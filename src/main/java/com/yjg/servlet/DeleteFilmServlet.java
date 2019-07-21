package com.yjg.servlet;

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
 *  @Description:删除对应的一条电影信息
 */
@WebServlet("/deleteFilm")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式，统一使用utf-8
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //转为int类型
        String filmId = req.getParameter("filmId");
        int filmId11 = 0;
        if(filmId!=null&&filmId!=""){
            filmId11 = Integer.parseInt(filmId);
        }
        if (filmId11>0){
            MovieRental movieRental = new MovieRentalImpl();
            //调用dao层的删除方法
            movieRental.deleteOneFilm(filmId11);

            req.getRequestDispatcher("FilmServlet?pageNo=1&pagesize=10").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
