package com.example.nation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@Setter
@AllArgsConstructor
@Getter
@Entity
@Table(name="district")
public class DistrictEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;
    @Column(length =5,nullable = false,unique = true)
    private Integer districtCode;
    @Column(length=30,nullable = false,unique = true)
    private String districtName;


    @JsonBackReference("stateEntity")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private StateEntity stateEntity;

}
