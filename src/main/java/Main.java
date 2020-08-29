import model.MovieCopy;
import model.MovieInfo;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import service.MovieCopyService;
import service.MovieInfoService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
//            Query<MovieInfo> query = session.createQuery("from moviesinfo mi where " +
//                    "mi.title='Greenbook'", MovieInfo.class);
//            MovieInfo movieInfo = (MovieInfo) query.getResultList();



//            MovieInfo newMovie = new MovieInfo();
//            newMovie.setTitle("Titanic");
//            newMovie.setGenre("Katastroficzny");
//            newMovie.setDescription("film o statku");
//            newMovie.setReleaseDate(LocalDate.of(1999, 3, 15));
//            session.save(newMovie);

            //MovieInfo movieInfo = new MovieInfoService().removeMovie(12, session);




//            MovieInfoService movieInfoService = new MovieInfoService();
            // movieInfoService.addMovie(newMovie, session, 10);

//            List<MovieInfo> movieInfos = movieInfoService.find(session, 4L, null,
//                    null, null, null);

//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<MovieInfo> criteriaQuery = criteriaBuilder.createQuery(MovieInfo.class);
//            Root<MovieInfo> root = criteriaQuery.from(MovieInfo.class);
//            criteriaQuery.select(root)
//                    .where(criteriaBuilder.equal(root.get("title"), "Leviathan"));


//            Query<MovieInfo> query1 = session.createQuery(criteriaQuery);
//            List<MovieInfo> movieInfos1 = query1.getResultList();



            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
