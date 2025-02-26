package school.faang.user_service.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import school.faang.user_service.dto.ProfilePicEvent;

@Slf4j
@Service
public class ProfilePicEventHandler {

    @EventListener
    public void handleProfilePicUpload(ProfilePicEvent event) {
        log.info("Handling profile pic upload event");
    }
}
