package com.yjg.dao.impl;

import com.yjg.bean.Film;
import com.yjg.dao.MovieRental;
import com.yjg.utils.BaseDao;
import com.yjg.vo.AddFilmVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 电影租赁操作数据库的接口的实现
 */

public class MovieRentalImpl extends BaseDao implements MovieRental{
    @Override
    public boolean getCustomerName(String name) {
        boolean falg = false;
        try{
            //获取链接
            super.getConnection();
            String sql = "select first_name from customer where first_name = '"+name+"'";
            //执行sql指令---不带参数的 SQL 语句通常使用 Statement 对象执行。---创建一个 Statement
            stmt = con.createStatement();
            //处理执行结果--- 执行给定的 SQL 语句，该语句返回单个 ResultSet 对象。
            ResultSet resultSet = rs = stmt.executeQuery(sql);
            String firstName = null;
            while (resultSet.next()){
                firstName = resultSet.getString("first_name");
            }
            if(firstName!=null && firstName!=""){
                falg = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        return falg;
    }

    @Override
    public List<Film> getAllFilm(int pageNo,int pagesize) {
        List<Film> allFilm = new ArrayList<>();
        try{
            //获取链接
            Connection connections = super.getConnections();
            //定义执行的SQL体
            String sql = "SELECT\n" +
                    "\tfilm_id,\n" +
                    "\ttitle,\n" +
                    "\tdescription,\n" +
                    "\tNAME\n" +
                    "FROM\n" +
                    "\tfilm f,\n" +
                    "\tLANGUAGE l\n" +
                    "WHERE\n" +
                    "\tl .language_id = f.language_id  limit ?,?";
            //执行sql指令---不带参数的 SQL 语句通常使用 Statement 对象执行。---创建一个 Statement
            PreparedStatement ps = connections.prepareStatement(sql);
            // 对SQL语句中的第1个参数赋值
            ps.setInt(1, (pageNo - 1) * pagesize);
            // 对SQL语句中的第2个参数赋值
            ps.setInt(2, pagesize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setDescription(rs.getString("description"));
                film.setTitle(rs.getString("title"));
                film.setName(rs.getString("NAME"));
                allFilm.add(film);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        System.out.println(allFilm.get(0).getTitle());
        return allFilm;
    }

    @Override
    public Film selectOneFilm(int filmId) {
        Film film = new Film();
        try{
            //获取链接
            super.getConnection();
            //定义执行的SQL体
            String sql = "SELECT\n" +
                    "\tfilm_id,\n" +
                    "\ttitle,\n" +
                    "\tdescription,\n" +
                    "\tNAME\n" +
                    "FROM\n" +
                    "\tfilm f,\n" +
                    "\tLANGUAGE l\n" +
                    "WHERE\n" +
                    "\tl .language_id = f.language_id and  film_id="+filmId+"";
            //执行sql指令---不带参数的 SQL 语句通常使用 Statement 对象执行。---创建一个 Statement
            stmt = con.createStatement();
            //处理执行结果--- 执行给定的 SQL 语句，该语句返回单个 ResultSet 对象。
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                film.setFilmId(rs.getInt("film_id"));
                film.setDescription(rs.getString("description"));
                film.setTitle(rs.getString("title"));
                film.setName(rs.getString("NAME"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        return film;
    }

    @Override
    public int addOneFilm(AddFilmVo addFilmVo) {
        //定义一个标识
        int num = 0;
        //获取链接
        super.getConnection();
        //定义sql执行体title,description,language
        String sql = "insert into  film(title,description,language_id)  values('"+ addFilmVo.getTitle()+"','"+addFilmVo.getDescription()+"','"+addFilmVo.getLanguage_id()+"')";
        return executeSql(sql);
    }

    @Override
    public int deleteOneFilm(int filmId) {
        //定义一个标识
        int num = 0;
        try{
            super.getConnection();
            stmt = con.createStatement();
            String sql3 = "delete from inventory where film_id = '"+filmId+"'";
            stmt.executeUpdate(sql3);
            String sql2 = "delete from film_category where film_id = '"+filmId+"'";
            stmt.executeUpdate(sql2);
            String sql1 = "delete from film_actor where film_id = '"+filmId+"'";
            stmt.executeUpdate(sql1);
            String sql = "delete from film where film_id = '"+filmId+"'";
            num = stmt.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        return num;
    }

    @Override
    public int updateOneFile(AddFilmVo addFilmVo,int filmId) {
        //获取链接
        super.getConnection();
        //创建sql执行体编辑界面需要有 title,description,language字段
        String sql = "update film set title = '"+addFilmVo.getTitle()+"' , " +
                "description = '"+addFilmVo.getDescription()+"'," +
                "language_id = '"+addFilmVo.getLanguage_id()+"' " +
                "where film_id = '"+filmId+"'";
        return executeSql(sql);
    }

    @Override
    public List<String> getLanguage() {
        //获取链接
        super.getConnection();
        //创建sql执行体编辑界面需要有 title,description,language字段
        String sql="select name from language";
        List<String> list = new ArrayList<>();
        try {
            //执行sql指令---不带参数的 SQL 语句通常使用 Statement 对象执行。---创建一个 Statement
            stmt = con.createStatement();
            //处理执行结果--- 执行给定的 SQL 语句，该语句返回单个 ResultSet 对象。
            rs = stmt.executeQuery(sql);
            String name = null;
            while (rs.next()){
                name = rs.getString("name");
                list.add(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        return list;
    }
    /**
     *
     * @param sql
     * @return
     */
    public int executeSql( String sql){
        //定义一个标识
        int num =0;
        try{
            //执行sql指令---不带参数的 SQL 语句通常使用 Statement 对象执行
            stmt = con.createStatement();
            //执行给定 SQL 语句，该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）。
            num = stmt.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        return num;
    }
}
