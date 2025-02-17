package ru.eventlink.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.eventlink.dto.user.UserDto;
import ru.eventlink.utility.Constants;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDto {
    @NotBlank
    String id;
    @NotNull
    Long eventId;
    @NotNull
    Long authorId;
    @NotBlank
    String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
    @NotNull
    LocalDateTime creationDate;
    @NotNull
    LocalDateTime updateDate;
    Long likes;
    List<UserDto> usersLiked;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CommentDto that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
