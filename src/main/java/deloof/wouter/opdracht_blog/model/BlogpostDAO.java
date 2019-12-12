package deloof.wouter.opdracht_blog.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import static org.hibernate.loader.Loader.SELECT;

public interface BlogpostDAO extends CrudRepository<Blogpost, Integer> {

    @Query("SELECT b FROM Blogpost b ORDER BY b.date DESC")
    Iterable<Blogpost> findChronological();

}
