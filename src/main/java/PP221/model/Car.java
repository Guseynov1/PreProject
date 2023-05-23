package PP221.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    public Car (String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return String.format("%s %s", model, series);
    }
}
