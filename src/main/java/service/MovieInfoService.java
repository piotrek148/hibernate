package service;

import model.MovieInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MovieInfoService {
    public void addMovie(MovieInfo movieInfo, Session session, int numberOfCopies) {
        Transaction transaction = session.beginTransaction();
        session.save(movieInfo);
        transaction.commit();
        // wywołać metodę z serwisu moviecopies przekazując id nowego filmu
        MovieCopyService movieCopyService = new MovieCopyService();
        for (int i = 0; i < numberOfCopies; i++) {
            movieCopyService.addCopy(movieInfo.getId(), session);
        }
    }
    public void removeMovie(Long id, Session session){
        Transaction transaction = session.beginTransaction();
        String findQuery = "from moviesinfo mi where mi.id= :id";
        Query<MovieInfo> query = session.createQuery(findQuery);
        query.setParameter("id", id);
        MovieInfo movieInfo = query.getSingleResult();

        MovieInfo movieInfo1 = session.find(MovieInfo.class, id);
        if (Objects.nonNull(movieInfo1)){
            session.delete(movieInfo1);
        }
        transaction.commit();



    }

    public List<MovieInfo> find(Session session, Long id, String title, String genre,
                                LocalDate releaseDate, String description) {
        String findQuery = "from moviesinfo m";
        Query<MovieInfo> query = session.createQuery(findQuery);

        if (id != null || title != null || genre != null || releaseDate != null || description != null ) {
            findQuery += " where";
        }

        boolean isAnd = false;

        if (id != null) {
            findQuery += " m.id = :id";
            isAnd = true;
            query = session.createQuery(findQuery);
            query.setParameter("id", id);
        }
        if (genre != null) {
            if (isAnd) {
                findQuery += " and";
            } else {
                isAnd = true;
            }
            findQuery += " m.genre = :genre";
            query = session.createQuery(findQuery);
            query.setParameter("genre", genre);
        }

        return query.getResultList();
    }
}
