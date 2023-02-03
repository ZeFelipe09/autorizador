package com.elumini.projects.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class Card {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "numeroCartao")
    @JsonProperty("numeroCartao")
    private String cardNumber;

    @Column(name = "senha")
    @JsonProperty("senha")
    private String password;

    @Column(name = "saldo")
    @JsonProperty("saldo")
    private BigDecimal balance;
}
