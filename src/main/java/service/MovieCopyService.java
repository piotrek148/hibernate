package service;

import model.MovieCopy;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ... comment class...
 *
 * @author ptrkukla148@gmail.com
 * @since 23.08.2020
 */
public class MovieCopyService {
    public void addCopy(Long movieId, Session session) {

        Transaction transaction = session.beginTransaction();
        MovieCopy movieCopy = new MovieCopy();

        movieCopy.setRented(false);
        movieCopy.setMovieInfoId(movieId);
        movieCopy.setRentedTimes(0);
        movieCopy.setCustomerId(null);

        session.save(movieCopy);
        transaction.commit();

    }
}
