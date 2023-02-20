package inf.puc.rio.br.opus.minerator.smells.pmd;


import java.util.List;

public class DuplicatedCodePMD {

    private List<String> classNames;
    private List<String> methodNames;

    private String commit;

    private String projectName;

    public void setMethodNames(List<String> methodNames) {
        this.methodNames = methodNames;
    }

    public List<String> getMethodNames() {
        return methodNames;
    }

    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

    public List<String> getClassNames() {
        return classNames;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
