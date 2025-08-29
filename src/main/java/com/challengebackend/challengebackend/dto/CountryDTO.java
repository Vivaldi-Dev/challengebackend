package com.challengebackend.challengebackend.dto;

import jdk.jshell.Snippet;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDTO {
    private Long id;
    private String nome;
    private String capital;
    private String regiao;
    private String subRegiao;
    private Double area;


}
