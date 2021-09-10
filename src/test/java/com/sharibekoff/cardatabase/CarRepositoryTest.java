package com.sharibekoff.cardatabase;

import com.sharibekoff.cardatabase.domain.Car;
import com.sharibekoff.cardatabase.domain.CarRepository;
import com.sharibekoff.cardatabase.domain.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository repository;

    @Test
    public void saveCar() {
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, new Owner("Elon", "Musk"));
        entityManager.persistAndFlush(car);
        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars() {
        entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86_000, new Owner("Elon", "Musk")));
        entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500, new Owner("Tracey", "De Santa")));

        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
