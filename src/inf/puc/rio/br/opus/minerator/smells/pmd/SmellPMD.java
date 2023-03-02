package inf.puc.rio.br.opus.minerator.smells.pmd;

import inf.puc.rio.br.opus.minerator.smells.organic.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmellPMD {


    ProcessBuilder pb;

    public void collectSmells(String commit, String path, String outputFileName) {
        // ATUALIZA PARA O COMMIT EM QUESTÃO

        String commandGitCheckout[] = {"git", "checkout", "-f", commit};
        executeCommand(commandGitCheckout, path);

        String PMDPath = "C:\\Users\\anaca\\Documents\\pmd-bin-6.54.0\\bin\\";
        // EXECUTA O PMD
        String commandToRunPMD[] = {"cmd.exe", "/C",  PMDPath + "cpd.bat", "--minimum-tokens", "30", "--files", path, ">>", outputFileName};

        executeCommand(commandToRunPMD, PMDPath);
    }


    public  void executeCommand(String[] command, String path) {
        try {
            pb = new ProcessBuilder(command);
            pb.directory(new File(path));
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
