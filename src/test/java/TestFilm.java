import com.yjg.bean.Film;
import com.yjg.dao.impl.MovieRentalImpl;
import com.yjg.vo.AddFilmVo;

import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 对操作数据库方法的测试
 */
public class TestFilm {
    public static void main(String[] args){
       MovieRentalImpl movieRental = new MovieRentalImpl();
        /* //movieRental.getAllFilm();
        AddFilmVo addFilmVo = new AddFilmVo();
        addFilmVo.setTitle("123");
        addFilmVo.setDescription("yanjiguo23");
        addFilmVo.setLanguage_id(1);
        movieRental.addOneFilm(addFilmVo);*/
        List<Film> allFilm = movieRental.getAllFilm(1, 10);
        for (Film film:allFilm) {
            System.out.println(film.getTitle());
        }


    }
}
