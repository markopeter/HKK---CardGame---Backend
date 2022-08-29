package com.cardgameproject.cardgame.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "original_card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OriginalCard {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picUrl;
    private String name;

}
