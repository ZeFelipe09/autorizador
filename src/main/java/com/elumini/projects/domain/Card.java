package com.elumini.projects.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Card {
    @JsonIgnore
    @Id
    private UUID id;

    @Column(name = "numeroCartao")
    @JsonProperty("numeroCartao")
    private String cardNumber;

    @Column(name = "senha")
    @JsonProperty("senha")
    private String password;

    @Column(name = "saldo")
    @JsonProperty("saldo")
    private Long balance;
}
