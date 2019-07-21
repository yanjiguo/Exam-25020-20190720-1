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

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 处理登录的业务逻辑
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

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
        //获取jsp页面的参数
        String firstName = req.getParameter("firstName");
        //创建一个Dao层的对象
        MovieRental movieRental = new MovieRentalImpl();
        //定义一个标识
        boolean customerName = false;
        if(firstName!=null&&firstName!=""){
            //通过访问dao层来判断用户是否存在
            customerName = movieRental.getCustomerName(firstName);
            if(customerName){
                //输入的姓名正确,将用户名存放在session中
                HttpSession session = req.getSession();
                session.setAttribute("firstName",firstName);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                //姓名不相同给页面提示
                String str = "你输入的姓名错误,请从新输入";
                req.setAttribute("str", str);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }else{
            //姓名为空时
            String str = "请你输入姓名后在点击提交";
            req.setAttribute("str", str);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
