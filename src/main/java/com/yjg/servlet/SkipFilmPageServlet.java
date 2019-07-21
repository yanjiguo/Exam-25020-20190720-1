package com.yjg.servlet;

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
@WebServlet("/skipFilmPage")
public class SkipFilmPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式，统一使用utf-8
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取session中的值
        HttpSession session = req.getSession();
        String firstName = (String)session.getAttribute("firstName");
        //创建一个访问dao层的对像
        MovieRental movieRental = new MovieRentalImpl();
        if(firstName!=null&&firstName!=""){
            //获取语言列表
            List<String> language = movieRental.getLanguage();
            req.setAttribute("language",language);
            req.getRequestDispatcher("addFilm.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
