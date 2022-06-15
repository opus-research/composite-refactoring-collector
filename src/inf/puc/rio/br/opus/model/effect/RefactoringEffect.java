package inf.puc.rio.br.opus.model.effect;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public class RefactoringEffect {

    @JsonProperty("id")
    private String id;

    @JsonProperty("refactoringId")
    private String refactoringId;

    @JsonProperty("smellsBefore")
    private List<String> smellsBefore;

    @JsonProperty("smellsAfter")
    private List<String> smellsAfter;


    public RefactoringEffect(String id, String refactoringId, List<String> smellsBefore, List<String> smellsAfter) {
        this.id = id;
        this.refactoringId = refactoringId;
        this.smellsBefore = smellsBefore;
        this.smellsAfter = smellsAfter;
    }



    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("smellsBefore")
    public List<String> getSmellsBefore() {
        return smellsBefore;
    }

    @JsonProperty("smellsBefore")
    public void setSmellsBefore(List<String> smellsBefore) {
        this.smellsBefore = smellsBefore;
    }

    @JsonProperty("smellsAfter")
    public List<String> getSmellsAfter() {
        return smellsAfter;
    }

    @JsonProperty("smellsAfter")
    public void setSmellsAfter(List<String> smellsAfter) {
        this.smellsAfter = smellsAfter;
    }



}
