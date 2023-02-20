package inf.puc.rio.br.opus.minerator.smells.pmd;


import java.util.List;

public class DuplicatedCodePMD {

    private List<String> classNames;
    private List<String> methodNames;

    public void setMethodNames(List<String> methodNames) {
        this.methodNames = methodNames;
    }

    public List<String> getMethodNames() {
        return methodNames;
    }

    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }
}
