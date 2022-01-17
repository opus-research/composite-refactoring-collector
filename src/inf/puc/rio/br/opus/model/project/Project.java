package inf.puc.rio.br.opus.model.project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

    @JsonProperty("name")
    private String name;

    public Project(String name){
        this.name = name;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
}
