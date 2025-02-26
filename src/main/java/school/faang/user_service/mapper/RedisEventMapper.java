package school.faang.user_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import school.faang.user_service.dto.ProfilePicEvent;
import school.faang.user_service.redis.event.ProfilePicRedisEvent;

@Mapper(componentModel = "spring")
public interface RedisEventMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "picKey", source = "profilePicUrl")
    ProfilePicRedisEvent toRedisEvent(ProfilePicEvent event);
}
