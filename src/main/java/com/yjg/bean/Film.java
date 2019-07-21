package com.yjg.bean;
/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 封装film 表中相关的字段
 */
public class Film {
    /**
     * 电影id
     */
    private int filmId;
    /**
     * 电影标题
     */
    private String title;
    /**
     * 电影描述
     */
    private String description;
    /**
     * 语言名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
