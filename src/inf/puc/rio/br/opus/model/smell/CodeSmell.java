package inf.puc.rio.br.opus.model.smell;


public class CodeSmell {

    private String id;
    private String name;
    private String projectName;
    private String codeElement;
    private String detectorName;
    private String details;
    private String commit;

    public CodeSmell(String id, String name, String codeElement, String commit, String detectorName, String details) {
        this.id = id;
        this.name = name;
        this.codeElement = codeElement;
        this.commit = commit;
        this.detectorName = detectorName;
        this.details = details;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCodeElement() {
        return codeElement;
    }

    public void setCodeElement(String codeElement) {
        this.codeElement = codeElement;
    }

    public String getDetectorName() {
        return detectorName;
    }

    public void setDetectorName(String detectorName) {
        this.detectorName = detectorName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
