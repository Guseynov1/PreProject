package web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String series;
    private String model;
    private int release;
    @Override
    public String toString() {
        return String.format("%s %s, %d", series, model, release);
    }
}
