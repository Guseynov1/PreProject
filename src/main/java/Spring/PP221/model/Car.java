package Spring.PP221.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Getter @Setter
@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
public class Car {

    private String model;
    private int series;
}
