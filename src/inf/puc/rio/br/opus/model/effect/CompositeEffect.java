package inf.puc.rio.br.opus.model.effect;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CompositeEffect {

    @JsonProperty("id")
    private String id;

    @JsonProperty("compositeId")
    private String compositeId;

    @JsonProperty("smellsBefore")
    private List<String> smellsBefore;

    @JsonProperty("smellsAfter")
    private List<String> smellsAfter;


    public CompositeEffect(String id,
                           String refactoringId,
                           List<String> smellsBefore,
                           List<String> smellsAfter) {
        this.id = id;
        this.compositeId = refactoringId;
        this.smellsBefore = smellsBefore;
        this.smellsAfter = smellsAfter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompositeId() {
        return compositeId;
    }

    public void setCompositeId(String compositeId) {
        this.compositeId = compositeId;
    }

    public List<String> getSmellsBefore() {
        return smellsBefore;
    }

    public void setSmellsBefore(List<String> smellsBefore) {
        this.smellsBefore = smellsBefore;
    }

    public List<String> getSmellsAfter() {
        return smellsAfter;
    }

    public void setSmellsAfter(List<String> smellsAfter) {
        this.smellsAfter = smellsAfter;
    }
}
