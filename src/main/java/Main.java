import model.MovieInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import service.MovieCopyService;

import java.time.LocalDate;

/**
 * ... comment class...
 *
 * @author ptrkukla148@gmail.com
 * @since 22.08.2020
 */
public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();


        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Query<MovieInfo> query = session.createQuery("from moviesinfo mi where " + "mi.title=:Green Book", MovieInfo.class);
            MovieInfo movieInfo = query.uniqueResult();
//            System.out.println(movieInfo);

            Transaction transaction = session.beginTransaction();

            MovieInfo newMovie = new MovieInfo();
            newMovie.setTitle("Toy Story");
            newMovie.setGenre("anime");
            newMovie.setDescription("o zabawkach");
            newMovie.setReleaseDate(LocalDate.of(2015,6,20));

            MovieCopyService movieCopyService = new MovieCopyService();

            session.save(newMovie);

            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
