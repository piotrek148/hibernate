
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@Setter
@Builder
/**
 * ... comment class...
 *
 * @author ptrkukla148@gmail.com
 * @since 23.08.2020
 */
public class Movie {
    Long id;
    String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
