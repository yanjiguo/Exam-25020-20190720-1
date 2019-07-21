package com.yjg.servlet;

import com.yjg.dao.MovieRental;
import com.yjg.dao.impl.MovieRentalImpl;
import com.yjg.vo.AddFilmVo;

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
@WebServlet("/updateFilm")
public class UpdateFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式，统一使用utf-8
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取参数
        int fileId = Integer.parseInt(req.getParameter("fileId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String language = req.getParameter("language");
        int language_id = 1;
        if(language.equals("English")){
            language_id = 1;
        }else if(language.equals("Italian")){
            language_id = 2;
        }else if(language.equals("Japanese")){
            language_id = 3;
        }else if(language.equals("Mandarin")){
            language_id = 4;
        }else if(language.equals("French")){
            language_id = 5;
        }else if(language.equals("German")){
            language_id = 6;
        }
        //创建一个AddFilmVo对象
        AddFilmVo addFilmVo = new AddFilmVo();
        addFilmVo.setTitle(title);
        addFilmVo.setDescription(description);
        addFilmVo.setLanguage_id(language_id);
        MovieRental movieRental = new MovieRentalImpl();
        int i = movieRental.updateOneFile(addFilmVo, fileId);
        if(i==1){
            String str = "修改成功";
            req.setAttribute("str", str);
            req.getRequestDispatcher("updateFilm.jsp").forward(req, resp);
        }else{
            String str = "修改失败";
            req.setAttribute("str", str);
            req.getRequestDispatcher("updateFilm.jsp").forward(req, resp);
        }
    }
}
