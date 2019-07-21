package com.yjg.dao;

import com.yjg.bean.Film;
import com.yjg.vo.AddFilmVo;

import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 电影租赁操作数据库的接口
 */
public interface MovieRental {
    /**
     * 获取customer中的姓名
     * @param name
     * @return 客户的姓名
     */
    boolean getCustomerName(String name);

    /**
     *
     * @param pageNo
     * 获取Film表中的字段
     * @return 返回查询到的Film表中的数据
     */
    List<Film> getAllFilm(int pageNo,int pagesize);

    /**
     * 根据Film对象添加一个film
     * @param addFilmVo
     * @return 返回一个int的数如果返回1插入成功如果返回0失败
     */
    int addOneFilm(AddFilmVo addFilmVo);

    /**
     * 根据filmId删除一条Film记录
     * @param filmId
     * @return 返回一个int的数如果返回1删除成功如果返回0删除失败
     */
    int deleteOneFilm(int filmId);
    /**
     * 更新film中的内容
     * @param addFilmVo
     * @return
     */
    int updateOneFile(AddFilmVo addFilmVo, int filmId);

    /**
     * 获取language表中的name
     * @return
     */
    List<String> getLanguage();

    /**
     * 根据film查询电影信息
     * @param filmId
     * @return
     */
    Film selectOneFilm(int filmId);
}
