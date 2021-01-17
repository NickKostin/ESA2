package un.lab.esa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import un.lab.esa.dao.MovieDao;
import un.lab.esa.model.Movie;

import java.util.List;

public class MovieServiceImpl implements MovieService{

    private MovieDao movieDao;

    @Autowired(required = true)
    @Qualifier(value = "movieDao")
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    @Transactional
    public List<Movie> listMovies() {
        return this.movieDao.listMovies();
    }
}
