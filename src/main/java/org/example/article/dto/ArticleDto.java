package org.example.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ArticleDto {
  private long  id;
  private String title;
  private String body;

}
