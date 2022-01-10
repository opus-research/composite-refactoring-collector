
package opus.inf.puc.rio.br.model.smell;

import java.util.HashMap;
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
    "ChangingClasses",
    "MaxNesting",
    "MaxCallChain",
    "CouplingDispersion",
    "MethodLinesOfCode",
    "CouplingIntensity",
    "NumberOfAccessedVariables",
    "ParameterCount",
    "ChangingMethods",
    "CyclomaticComplexity"
})
public class MetricsValues {

    @JsonProperty("ChangingClasses")
    private Double changingClasses;
    @JsonProperty("MaxNesting")
    private Double maxNesting;
    @JsonProperty("MaxCallChain")
    private Double maxCallChain;
    @JsonProperty("CouplingDispersion")
    private Double couplingDispersion;
    @JsonProperty("MethodLinesOfCode")
    private Double methodLinesOfCode;
    @JsonProperty("CouplingIntensity")
    private Double couplingIntensity;
    @JsonProperty("NumberOfAccessedVariables")
    private Double numberOfAccessedVariables;
    @JsonProperty("ParameterCount")
    private Double parameterCount;
    @JsonProperty("ChangingMethods")
    private Double changingMethods;
    @JsonProperty("CyclomaticComplexity")
    private Double cyclomaticComplexity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ChangingClasses")
    public Double getChangingClasses() {
        return changingClasses;
    }

    @JsonProperty("ChangingClasses")
    public void setChangingClasses(Double changingClasses) {
        this.changingClasses = changingClasses;
    }

    @JsonProperty("MaxNesting")
    public Double getMaxNesting() {
        return maxNesting;
    }

    @JsonProperty("MaxNesting")
    public void setMaxNesting(Double maxNesting) {
        this.maxNesting = maxNesting;
    }

    @JsonProperty("MaxCallChain")
    public Double getMaxCallChain() {
        return maxCallChain;
    }

    @JsonProperty("MaxCallChain")
    public void setMaxCallChain(Double maxCallChain) {
        this.maxCallChain = maxCallChain;
    }

    @JsonProperty("CouplingDispersion")
    public Double getCouplingDispersion() {
        return couplingDispersion;
    }

    @JsonProperty("CouplingDispersion")
    public void setCouplingDispersion(Double couplingDispersion) {
        this.couplingDispersion = couplingDispersion;
    }

    @JsonProperty("MethodLinesOfCode")
    public Double getMethodLinesOfCode() {
        return methodLinesOfCode;
    }

    @JsonProperty("MethodLinesOfCode")
    public void setMethodLinesOfCode(Double methodLinesOfCode) {
        this.methodLinesOfCode = methodLinesOfCode;
    }

    @JsonProperty("CouplingIntensity")
    public Double getCouplingIntensity() {
        return couplingIntensity;
    }

    @JsonProperty("CouplingIntensity")
    public void setCouplingIntensity(Double couplingIntensity) {
        this.couplingIntensity = couplingIntensity;
    }

    @JsonProperty("NumberOfAccessedVariables")
    public Double getNumberOfAccessedVariables() {
        return numberOfAccessedVariables;
    }

    @JsonProperty("NumberOfAccessedVariables")
    public void setNumberOfAccessedVariables(Double numberOfAccessedVariables) {
        this.numberOfAccessedVariables = numberOfAccessedVariables;
    }

    @JsonProperty("ParameterCount")
    public Double getParameterCount() {
        return parameterCount;
    }

    @JsonProperty("ParameterCount")
    public void setParameterCount(Double parameterCount) {
        this.parameterCount = parameterCount;
    }

    @JsonProperty("ChangingMethods")
    public Double getChangingMethods() {
        return changingMethods;
    }

    @JsonProperty("ChangingMethods")
    public void setChangingMethods(Double changingMethods) {
        this.changingMethods = changingMethods;
    }

    @JsonProperty("CyclomaticComplexity")
    public Double getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }

    @JsonProperty("CyclomaticComplexity")
    public void setCyclomaticComplexity(Double cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
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
