package com.sample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;

    @OneToMany(fetch = FetchType.EAGER)
    Set<UserRoles> userRoles;

    @JsonIgnoreProperties("userDetails")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    UserCredentials userCredentials;

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
