package com.projecty.projectyweb.notifications;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projecty.projectyweb.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    private NotificationType notificationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @ElementCollection
    @MapKeyColumn(name = "object_class")
    @Column(name = "id")
    private Map<NotificationObjectType, Long> ids;

    @Transient
    private String stringValue;
}
