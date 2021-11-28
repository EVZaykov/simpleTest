
package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    private String avatarUrl;
    private String eventsUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String gravatarId;
    private String htmlUrl;
    private long id;
    private String login;
    private String nodeId;
    private String organizationsUrl;
    private String receivedEventsUrl;
    private String reposUrl;
    private Boolean siteAdmin;
    private String starredUrl;
    private String subscriptionsUrl;
    private String type;
    private String url;

}
