
package opus.inf.puc.rio.br.model.smell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parametersTypes",
    "sourceFile",
    "metricsValues",
    "fullyQualifiedName",
    "smells"
})
public class Method {

    @JsonProperty("parametersTypes")
    private List<String> parametersTypes = null;
    @JsonProperty("sourceFile")
    private SourceFile sourceFile;
    @JsonProperty("metricsValues")
    private MetricsValues metricsValues;
    @JsonProperty("fullyQualifiedName")
    private String fullyQualifiedName;
    @JsonProperty("smells")
    private List<Object> smells = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("parametersTypes")
    public List<String> getParametersTypes() {
        return parametersTypes;
    }

    @JsonProperty("parametersTypes")
    public void setParametersTypes(List<String> parametersTypes) {
        this.parametersTypes = parametersTypes;
    }

    @JsonProperty("sourceFile")
    public SourceFile getSourceFile() {
        return sourceFile;
    }

    @JsonProperty("sourceFile")
    public void setSourceFile(SourceFile sourceFile) {
        this.sourceFile = sourceFile;
    }

    @JsonProperty("metricsValues")
    public MetricsValues getMetricsValues() {
        return metricsValues;
    }

    @JsonProperty("metricsValues")
    public void setMetricsValues(MetricsValues metricsValues) {
        this.metricsValues = metricsValues;
    }

    @JsonProperty("fullyQualifiedName")
    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    @JsonProperty("fullyQualifiedName")
    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    @JsonProperty("smells")
    public List<Object> getSmells() {
        return smells;
    }

    @JsonProperty("smells")
    public void setSmells(List<Object> smells) {
        this.smells = smells;
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
