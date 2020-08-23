package service;

import model.MovieInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import java.util.List;

/**
 * ... comment class...
 *
 * @author ptrkukla148@gmail.com
 * @since 23.08.2020
 */


public class ServiceMovieInfo {

    public void addMovie(MovieInfo movieInfo, Session session, String title, String genere){
        Transaction transaction = session.beginTransaction();

        movieInfo.setTitle(title);
        movieInfo.setGenre(genere);

        session.save(movieInfo);
        transaction.commit();

    }


    public List<MovieInfo> find(MovieInfo movieInfo, Session session){
        Transaction transaction = session.beginTransaction();

            Query<MovieInfo> query = session.createQuery("from moviesinfo mi where " + "mi.title=:''Green Book''", MovieInfo.class);

        return null;
    }
}
