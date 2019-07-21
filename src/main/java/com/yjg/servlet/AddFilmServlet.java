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
 *  @Description:处理新增的电影
 */
@WebServlet("/addFilm")
public class AddFilmServlet extends HttpServlet {
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
        //获取页面传过来的值
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String language1 = req.getParameter("language");
        System.out.println(language1);
        //创建一个访问dao层的对像
        MovieRental movieRental = new MovieRentalImpl();
        //定义language_id
        int language_id = 1;
        /**
         * 1	English
         * 2	Italian
         * 3	Japanese
         * 4	Mandarin
         * 5	French
         * 6	German
         */
        if(language1.equals("English")){
            language_id = 1;
        }else if(language1.equals("Italian")){
            language_id = 2;
        }else if(language1.equals("Japanese")){
            language_id = 3;
        }else if(language1.equals("Mandarin")){
            language_id = 4;
        }else if(language1.equals("French")){
            language_id = 5;
        }else if(language1.equals("German")){
            language_id = 6;
        }
        System.out.println(title+"--"+description+"--"+language_id);
        //创建一个AddFilmVo对象
        AddFilmVo addFilmVo = new AddFilmVo();
        addFilmVo.setTitle(title);
        addFilmVo.setDescription(description);
        addFilmVo.setLanguage_id(language_id);
        int i = movieRental.addOneFilm(addFilmVo);
        if(i==1){
            String str = "添加成功";
            req.setAttribute("str", str);
            req.getRequestDispatcher("addFilm.jsp").forward(req, resp);
        }else{
            String str = "添加失败";
            req.setAttribute("str", str);
            req.getRequestDispatcher("addFilm.jsp").forward(req, resp);
        }
    }
}
