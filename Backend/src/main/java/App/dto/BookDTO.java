package App.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Информация о книгах")
public class BookDTO {

    private long id;
    @NotBlank
    @Schema(description = "Название книги")
    private String title;
    @Schema(description = "Автор")
    @NotBlank
    private String author;
    @Schema(description = "Обложка")
    private String cover;
    @Schema(description = "Рейтинг")
    private Integer rating;
    @Schema(description = "Рецензия")
    private String review;

}
