package com.example.nation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
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

    @JsonBackReference("countryEntity")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CountryEntity countryEntity;

    @JsonManagedReference("stateEntity")
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "stateEntity")
    private List<DistrictEntity> districtEntity;
}
