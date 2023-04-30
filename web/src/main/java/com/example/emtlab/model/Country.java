package com.example.emtlab.model;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;
import java.util.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;
    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Country country = (Country) o;
        return id != null && Objects.equals(id, country.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}