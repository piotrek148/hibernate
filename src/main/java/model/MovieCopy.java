package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "moviescopies")
public class MovieCopy {

    @Id
    @GeneratedValue
    @Column(name = "copyId")
    private Long id;

    @Column(nullable = false)
    private boolean isRented;

    @Column(nullable = false)
    private int rentedTimes;

    @Column
    private Long movieInfoId;

    public MovieCopy() {

    }

    public void setMovieInfoId(Long movieInfoId) {
        this.movieInfoId = movieInfoId;
    }

    public MovieCopy(Long movieInfoId) {
        this.movieInfoId = movieInfoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public int getRentedTimes() {
        return rentedTimes;
    }

    public void setRentedTimes(int rentedTimes) {
        this.rentedTimes = rentedTimes;
    }

    public void setCustomerId(Long id) {
        this.id = id;
    }
}
