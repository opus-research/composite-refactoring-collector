package opus.inf.puc.rio.br.model.compositeref;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "refactorings",
        "type"
})
public class CompositeRefactoring {

    @JsonProperty("id")
    private String id;
    @JsonProperty("refactorings")
    private List<Refactoring> refactorings;

    @JsonProperty("refactoringIDs")
    private List<String> refactoringIDs;

    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("refactorings")
    public List<Refactoring> getRefactorings() {
        return refactorings;
    }

    @JsonProperty("refactorings")
    public void setRefactorings(List<Refactoring> refactorings) {
        this.refactorings = refactorings;
    }

    @JsonProperty("refactoringIDs")
    public List<String> getRefactoringIDs() {
        return refactoringIDs;
    }

    @JsonProperty("refactoringIDs")
    public void setRefactoringIDs(List<String> refactoringIDs) {
        this.refactoringIDs = refactoringIDs;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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