package inf.puc.rio.br.opus.minerator.smells.pmd;

import inf.puc.rio.br.opus.minerator.smells.organic.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmellPMD {


    ProcessBuilder pb;
    // java -jar organic-OPT.jar -src dubbo/ -sf output.json
    // java -cp composite-refactoring-collector-1.0.jar inf.puc.rio.br.opus.minerator.smells.organic.SmellMinerator "couchbasejavaclient" "master" "output-couchbasejavaclient" "couchbase-java-client" "organic-1.0.2.jar"
    public void colectSmells(String commit, String path) {
        // ATUALIZA PARA O COMMIT EM QUESTÃO
        String commandGitCheckout[] = {"git", "checkout", "-f", commit};
        executeCommand(commandGitCheckout, Constants.FOLDER_PROJECT);

        // EXECUTA A ORGANIC
        // java -jar organic-OPT.jar -src <CAMINHO_PRO_PROJETO> -sf <NOME_DO_ARQUIVO_DE_SAIDA>.json
        String comando6[] = {"cpd.bat --minimum-tokens 30 --files " + path};

        executeCommand(comando6, Constants.FOLDER_PROJECT);
    }


    public  void executeCommand(String[] command, String folder) {
        try {
            pb = new ProcessBuilder(command);
            pb.directory(new File(folder));
            pb.redirectErrorStream(true);
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String outString;
            while ((outString = br.readLine()) != null) {
                System.out.println(outString);
            }
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
