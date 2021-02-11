package hiber.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "cars")
@Component
public class Car {
    private Long carid;
    String model;
    int series;
    private User user;

    @OneToOne
    @PrimaryKeyJoinColumn
    public User getUser() {return this.user;}

    public void setUser(User user) {this.user = user;}

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Id
    @Column(name = "carid", nullable = false, insertable = true, updatable = true)
    public Long getCarId() {return carid;}

    public void setCarId(Long carid) {this.carid = carid;}

    public int getSeries() {return series;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public void setSeries(int series) {this.series = series;}
}
