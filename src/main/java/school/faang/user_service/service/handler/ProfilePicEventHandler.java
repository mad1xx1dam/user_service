package school.faang.user_service.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import school.faang.user_service.dto.ProfilePicEvent;
import school.faang.user_service.mapper.RedisEventMapper;
import school.faang.user_service.properties.UserServiceProperties;
import school.faang.user_service.redis.MessagePublisher;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfilePicEventHandler {
    private final MessagePublisher publisher;
    private final RedisEventMapper mapper;
    private final UserServiceProperties properties;

    @EventListener
    @Async
    public void handleProfilePicUpload(ProfilePicEvent event) {
        log.info("Handling profile pic upload event");
        publisher.publish(mapper.toRedisEvent(event), properties.getRedis().getProfilePicChannel());
        log.info("Profile pic upload event sent to Redis");
    }
}
