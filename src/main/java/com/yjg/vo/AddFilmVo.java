package com.yjg.vo;
/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 用于封装前端要新增的字段
 */
public class AddFilmVo {
    /**
     * 电影标题
     */
    private String title;
    /**
     * 电影描述
     */
    private String description;
    /**
     * 语言id
     */
    private int language_id;

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

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
