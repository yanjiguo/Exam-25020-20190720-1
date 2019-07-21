package com.yjg.servlet;

import com.yjg.bean.Film;
import com.yjg.dao.MovieRental;
import com.yjg.dao.impl.MovieRentalImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 电影列表的处理业务层
 */
@WebServlet("/FilmServlet")
public class FilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式，统一使用utf-8
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取当前页和页大小 pageNo:1,pagesize:10
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        int pagesize = Integer.parseInt(req.getParameter("pagesize"));
        //获取session中的值
        HttpSession session = req.getSession();
        String firstName = (String)session.getAttribute("firstName");
        //创建一个访问dao层的对像
        MovieRental movieRental = new MovieRentalImpl();
        if(firstName!=null&&firstName!=""){
            //获取列表展示的电影信息
            List<Film> allFilm = movieRental.getAllFilm(pageNo,pagesize);
            req.setAttribute("allFilm",allFilm);
            req.setAttribute("pageNo",pageNo);
            req.getRequestDispatcher("film.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
