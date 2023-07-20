package com.example.nation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="state")
public class StateEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;
    @Column(length =5,nullable = false,unique = true)
    private Integer stateCode;
    @Column(length=30,nullable = false,unique = true)
    private String stateName;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CountryEntity countryEntity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "stateEntity")
    private List<DistrictEntity> districtEntity;
}
