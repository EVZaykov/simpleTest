
package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    private Boolean allowForking;
    private String archiveUrl;
    private Boolean archived;
    private String assigneesUrl;
    private String blobsUrl;
    private String branchesUrl;
    private String cloneUrl;
    private String collaboratorsUrl;
    private String commentsUrl;
    private String commitsUrl;
    private String compareUrl;
    private String contentsUrl;
    private String contributorsUrl;
    private String createdAt;
    private String defaultBranch;
    private String deploymentsUrl;
    private String description;
    private Boolean disabled;
    private String downloadsUrl;
    private String eventsUrl;
    private Boolean fork;
    private long forks;
    private long forksCount;
    private String forksUrl;
    private String fullName;
    private String gitCommitsUrl;
    private String gitRefsUrl;
    private String gitTagsUrl;
    private String gitUrl;
    private Boolean hasDownloads;
    private Boolean hasIssues;
    private Boolean hasPages;
    private Boolean hasProjects;
    private Boolean hasWiki;
    private Object homepage;
    private String hooksUrl;
    private String htmlUrl;
    private long id;
    private Boolean isTemplate;
    private String issueCommentUrl;
    private String issueEventsUrl;
    private String issuesUrl;
    private String keysUrl;
    private String labelsUrl;
    private String language;
    private String languagesUrl;
    private Object license;
    private String mergesUrl;
    private String milestonesUrl;
    private Object mirrorUrl;
    private String name;
    private String nodeId;
    private String notificationsUrl;
    private long openIssues;
    private long openIssuesCount;
    private Owner owner;
    private Permissions permissions;
    private Boolean private1;
    private String pullsUrl;
    private String pushedAt;
    private String releasesUrl;
    private long size;
    private String sshUrl;
    private long stargazersCount;
    private String stargazersUrl;
    private String statusesUrl;
    private String subscribersUrl;
    private String subscriptionUrl;
    private String svnUrl;
    private String tagsUrl;
    private String teamsUrl;
    private List<Object> topics;
    private String treesUrl;
    private String updatedAt;
    private String url;
    private String visibility;
    private long watchers;
    private long watchersCount;

}
