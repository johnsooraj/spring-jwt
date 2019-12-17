package com.sample.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String password;

    @UpdateTimestamp
    private Timestamp timestamp;

    @CreationTimestamp
    private LocalDateTime createDate;
    private byte status;

    @OneToOne(targetEntity = UserDetails.class, fetch = FetchType.EAGER)
    UserDetails userDetails;

    /*
     * Convert password String - Char []
     *
     * @param userName
     * @param password internally convert string to char array
     */

/*    public UserCredentials(String userName, String password) {
        this.userName = userName;
        setPassword(password);
    }

    public UserCredentials(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setPassword(String password) {
        char pass[] = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            pass[i] = password.charAt(i);
        }
        this.password = pass;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password=" + Arrays.toString(password) +
                ", timestamp=" + timestamp +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }*/
}
