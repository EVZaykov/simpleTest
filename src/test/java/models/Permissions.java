
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions {

    private Boolean admin;
    private Boolean maintain;
    private Boolean pull;
    private Boolean push;
    private Boolean triage;

}
