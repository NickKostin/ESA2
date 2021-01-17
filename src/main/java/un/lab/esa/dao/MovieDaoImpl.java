package un.lab.esa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import un.lab.esa.model.Movie;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Movie> listMovies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Movie> movieList = session.createQuery("from Movie").list();
        return movieList;
    }
}
