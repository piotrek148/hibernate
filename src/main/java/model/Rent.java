package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "rents")
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rentId")
    private Long id;

    @Column
    private Long rentedMovieId;

    @Column
    private Long customer;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    double rentPricePerDay;

    @Column
    double totalPrice;

    @Column(nullable = false)
    LocalDate rentedDate;

    @Column
    LocalDate returnedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentedMovieId() {
        return rentedMovieId;
    }

    public void setRentedMovieId(Long rentedMovieId) {
        this.rentedMovieId = rentedMovieId;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRentPricePerDay() {
        return rentPricePerDay;
    }

    public void setRentPricePerDay(double rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(LocalDate rentedDate) {
        this.rentedDate = rentedDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
