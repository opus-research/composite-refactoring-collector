package inf.puc.rio.br.opus.model.smell.organic;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodeSmellOrganic {

    @JsonProperty("name")
    private String name;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("startingLine")
    private int startingLine;

    @JsonProperty("endingLine")
    private int endingLine;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("startingLine")
    public int getStartingLine() {
        return startingLine;
    }

    @JsonProperty("startingLine")
    public void setStartingLine(int startingLine) {
        this.startingLine = startingLine;
    }

    @JsonProperty("endingLine")
    public int getEndingLine() {
        return endingLine;
    }

    @JsonProperty("endingLine")
    public void setEndingLine(int endingLine) {
        this.endingLine = endingLine;
    }

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
