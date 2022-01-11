
package inf.puc.rio.br.opus.model.smell.organic;

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
    "WeighOfClass",
    "LCOM3",
    "WeightedMethodCount",
    "PublicFieldCount",
    "NumberOfAccessorMethods",
    "ClassLinesOfCode",
    "TightClassCohesion",
    "IsAbstract",
    "LCOM2",
    "OverrideRatio"
})
public class MetricsValuesDTO {

    @JsonProperty("WeighOfClass")
    private Double weighOfClass;
    @JsonProperty("LCOM3")
    private Double lcom3;
    @JsonProperty("WeightedMethodCount")
    private Double weightedMethodCount;
    @JsonProperty("PublicFieldCount")
    private Double publicFieldCount;
    @JsonProperty("NumberOfAccessorMethods")
    private Double numberOfAccessorMethods;
    @JsonProperty("ClassLinesOfCode")
    private Double classLinesOfCode;
    @JsonProperty("TightClassCohesion")
    private Double tightClassCohesion;
    @JsonProperty("IsAbstract")
    private Double isAbstract;
    @JsonProperty("LCOM2")
    private Double lcom2;
    @JsonProperty("OverrideRatio")
    private Object overrideRatio;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("WeighOfClass")
    public Double getWeighOfClass() {
        return weighOfClass;
    }

    @JsonProperty("WeighOfClass")
    public void setWeighOfClass(Double weighOfClass) {
        this.weighOfClass = weighOfClass;
    }

    @JsonProperty("LCOM3")
    public Double getLcom3() {
        return lcom3;
    }

    @JsonProperty("LCOM3")
    public void setLcom3(Double lcom3) {
        this.lcom3 = lcom3;
    }

    @JsonProperty("WeightedMethodCount")
    public Double getWeightedMethodCount() {
        return weightedMethodCount;
    }

    @JsonProperty("WeightedMethodCount")
    public void setWeightedMethodCount(Double weightedMethodCount) {
        this.weightedMethodCount = weightedMethodCount;
    }

    @JsonProperty("PublicFieldCount")
    public Double getPublicFieldCount() {
        return publicFieldCount;
    }

    @JsonProperty("PublicFieldCount")
    public void setPublicFieldCount(Double publicFieldCount) {
        this.publicFieldCount = publicFieldCount;
    }

    @JsonProperty("NumberOfAccessorMethods")
    public Double getNumberOfAccessorMethods() {
        return numberOfAccessorMethods;
    }

    @JsonProperty("NumberOfAccessorMethods")
    public void setNumberOfAccessorMethods(Double numberOfAccessorMethods) {
        this.numberOfAccessorMethods = numberOfAccessorMethods;
    }

    @JsonProperty("ClassLinesOfCode")
    public Double getClassLinesOfCode() {
        return classLinesOfCode;
    }

    @JsonProperty("ClassLinesOfCode")
    public void setClassLinesOfCode(Double classLinesOfCode) {
        this.classLinesOfCode = classLinesOfCode;
    }

    @JsonProperty("TightClassCohesion")
    public Double getTightClassCohesion() {
        return tightClassCohesion;
    }

    @JsonProperty("TightClassCohesion")
    public void setTightClassCohesion(Double tightClassCohesion) {
        this.tightClassCohesion = tightClassCohesion;
    }

    @JsonProperty("IsAbstract")
    public Double getIsAbstract() {
        return isAbstract;
    }

    @JsonProperty("IsAbstract")
    public void setIsAbstract(Double isAbstract) {
        this.isAbstract = isAbstract;
    }

    @JsonProperty("LCOM2")
    public Double getLcom2() {
        return lcom2;
    }

    @JsonProperty("LCOM2")
    public void setLcom2(Double lcom2) {
        this.lcom2 = lcom2;
    }

    @JsonProperty("OverrideRatio")
    public Object getOverrideRatio() {
        return overrideRatio;
    }

    @JsonProperty("OverrideRatio")
    public void setOverrideRatio(Object overrideRatio) {
        this.overrideRatio = overrideRatio;
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
