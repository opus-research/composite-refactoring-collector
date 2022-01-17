
package inf.puc.rio.br.opus.model.project.miner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "commits"
})
public class ProjectMiner {

    @JsonProperty("name")
    private String name;
    @JsonProperty("commits")
    private List<CommitMiner> commits = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProjectMiner() {
    }

    /**
     * 
     * @param name
     * @param commits
     */
    public ProjectMiner(String name, List<CommitMiner> commits) {
        super();
        this.name = name;
        this.commits = commits;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("commits")
    public List<CommitMiner> getCommits() {
        return commits;
    }

    @JsonProperty("commits")
    public void setCommits(List<CommitMiner> commits) {
        this.commits = commits;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
