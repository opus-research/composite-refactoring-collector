package inf.puc.rio.br.opus.minerator.smells.pmd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PMDMinerator {


    public void findDuplicatedMethod(String path){


        String regex = "\\s*(public|private|protected)?\\s+\\w+\\s+\\w+\\(.*\\)\\s*(throws\\s+\\w+)?\\s*\\{?\\s*";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(".java")) {
                    System.out.println(line);
                }

                if (line.matches(regex)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
}
