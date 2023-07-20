package com.example.nation.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="country")
public class CountryEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;
    @Column(length =5,nullable = false,unique = true)
    private String countryCode;
    @Column(length=30,nullable = false,unique = true)
    private String countryName;
    @Column(length = 30,nullable = false,unique = true)
    private String capital;
    @Column(length = 30,nullable = false)
    private String continent;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<StateEntity> stateEntity;
}
