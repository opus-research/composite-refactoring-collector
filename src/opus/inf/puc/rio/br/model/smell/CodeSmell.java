
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
    "methods",
    "sourceFile",
    "metricsValues",
    "fullyQualifiedName",
    "smells"
})
public class CodeSmell {

    @JsonProperty("methods")
    private List<Method> methods = null;
    @JsonProperty("sourceFile")
    private SourceFileDTO sourceFile;
    @JsonProperty("metricsValues")
    private MetricsValuesDTO metricsValues;
    @JsonProperty("fullyQualifiedName")
    private String fullyQualifiedName;
    @JsonProperty("smells")
    private List<Object> smells = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("methods")
    public List<Method> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    @JsonProperty("sourceFile")
    public SourceFileDTO getSourceFile() {
        return sourceFile;
    }

    @JsonProperty("sourceFile")
    public void setSourceFile(SourceFileDTO sourceFile) {
        this.sourceFile = sourceFile;
    }

    @JsonProperty("metricsValues")
    public MetricsValuesDTO getMetricsValues() {
        return metricsValues;
    }

    @JsonProperty("metricsValues")
    public void setMetricsValues(MetricsValuesDTO metricsValues) {
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
