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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "mySeqGen", allocationSize = 10, initialValue = 100, sequenceName = "mySeqGen1")
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
    private Long id;

    @Column(name = "role_text", unique = true)
    private String roleText;

    @Column(name = "role_text_UC")
    private String roleTextUC;

    @UpdateTimestamp
    private Timestamp timestamp;
    @CreationTimestamp
    private LocalDateTime createDate;
    private byte status = 1;

    public UserRoles(String roleText) {
        this.roleText = roleText;
        this.roleTextUC = roleText.toUpperCase();
    }

    public String getRole_text() {
        return roleText;
    }

    public void setRole_text(String role_text) {
        this.roleText = role_text;
        this.roleTextUC = role_text.toUpperCase();
    }

    public String getRole_text_UC() {
        return roleTextUC;
    }

    public void setRole_text_UC(String roleTextUC) {
        this.roleTextUC = roleTextUC.toUpperCase();
    }
}
