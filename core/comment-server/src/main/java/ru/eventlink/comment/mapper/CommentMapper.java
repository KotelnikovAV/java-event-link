package ru.eventlink.comment.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.eventlink.comment.model.Comment;
import ru.eventlink.dto.comment.CommentDto;
import ru.eventlink.dto.comment.CommentUserDto;
import ru.eventlink.dto.comment.RequestCommentDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    @Mapping(target = "countResponse", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "likedUsersId", ignore = true)
    @Mapping(target = "parentCommentId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "likes", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    Comment requestCommentDtoToComment(RequestCommentDto requestCommentDto);

    @Mapping(target = "usersLiked", ignore = true)
    @Mapping(target = "id", expression = "java(getStringId(comment.getId()))")
    CommentDto commentToCommentDto(Comment comment);

    CommentUserDto commentToCommentUserDto(Comment comment);

    List<CommentUserDto> commentsToCommentsUserDto(List<Comment> comment);

    default String getStringId(ObjectId objectId) {
        return objectId.toString();
    }
}
