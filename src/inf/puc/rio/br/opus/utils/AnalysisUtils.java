package inf.puc.rio.br.opus.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.database.smells.SmellCollector;
import inf.puc.rio.br.opus.model.project.miner.CommitMiner;
import inf.puc.rio.br.opus.model.project.miner.ProjectMiner;

import inf.puc.rio.br.opus.model.refactoring.historic.collect.commit.CommitCollector;
import inf.puc.rio.br.opus.model.smell.CodeSmell;

public class AnalysisUtils {

	
	public static void main(String[] args) {
		
		AnalysisUtils.collectOrderFromCommitList();
	}

	public static List<String> getCommitsFromLongMethods(String project){

		List<CodeSmell> longMethods = SmellCollector.readSmellsFromJson("smells-" + project + ".json");

		List<String> commits = new ArrayList<>();

		for (CodeSmell longMethod : longMethods) {
			commits.add(longMethod.getCommit());
		}

		return commits;
	}

	public static String getLastNameFromURL(String projectURL){

		String lastName = "";
		int indexLastName = projectURL.lastIndexOf("/") + 1;
		lastName = projectURL.substring(indexLastName);

		return lastName;

	}

	/**
	 * @method 'getAllFileNames' generates a list of all files from a path
	 * @param pathFiles path
	 * @return a list of all files from a path
	 * */
	public static List<String> getAllFileNames(String pathFiles, String extension) {

		List<String> fileNames = new ArrayList<String>();

		try (Stream<Path> paths = Files.walk(Paths.get(pathFiles))) {
			paths.forEach(filePath -> {

				if (Files.isRegularFile(filePath) && hasExtension(filePath.toString(), extension)) {
					fileNames.add(filePath.toString());
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileNames;
	}

	public static String getOnlyFileNameFromPath(String path, String extension){

		String fileName;
		int indexSeparator = path.lastIndexOf("\\");
		int indexExtension = path.indexOf(extension);

		fileName = path.substring(indexSeparator+1, indexExtension);

		return fileName;
	}


	private void divideProjects(ProjectMiner project){
		List[] lists = AnalysisUtils.split(project.getCommits());
		List<CommitMiner> commits1 = new ArrayList<>(lists[0]);
		List<CommitMiner> commits2 = new ArrayList<>(lists[1]);
		ProjectMiner projectAux = project;
		project.setCommits(commits1);
		projectAux.setCommits(commits2);
	}
	// Method 1
	// To split a list into two sublists in Java
	//Source code from: https://www.geeksforgeeks.org/split-a-list-into-two-halves-in-java/
	public static List[] split(List<CommitMiner> list)
	{

		// Finding the size of the list using List.size()
		// and putting in a variable
		int size = list.size();

		// Creating new list and inserting values which is
		// returned by List.subList() method
		List<CommitMiner> first
				= new ArrayList<>(list.subList(0, (size) / 2));
		List<CommitMiner> second = new ArrayList<>(
				list.subList((size) / 2, size));

		// Returning an List of array
		return new List[] { first, second };
	}

	public static String getMethodName(String methodSignature){

		int accessIndex = 0;
		String methodName = "";

		if(methodSignature.contains("public ")){
			accessIndex = "public ".length();
		}
		else
			if(methodSignature.contains("private ")){
				accessIndex = "private ".length();
			}
		else
			if(methodSignature.contains("protected ")){
				accessIndex = "protected ".length();
			}

		int separatorIndex = methodSignature.indexOf("(");
		methodName = methodSignature.substring(accessIndex-1, separatorIndex);

		return methodName;
	}




	public static boolean isSameCodeElementName(List<String> codeElements){
       Set<String> elementSet = new HashSet<>(codeElements);

	   return elementSet.size() == 1;
	}

	public static String parserToMethodNameSmellFormat(String methodSignature) {

		String methodName = getMethodName(methodSignature);
		List<String> parameterTypes = getParametersAsAList(methodSignature);

		String methodNameParser = methodName + "(" + parameterTypes.toString() + ")";

		return methodNameParser;
	}

	public static List<String> getParametersAsAList(String methodSignature){
		List<String> parameterTypes = new ArrayList<>();


		int separatorOpenIndex = methodSignature.indexOf("(");
		int separatorCloseIndex = methodSignature.indexOf(")");

		String parameterTypesAsText = methodSignature.substring(separatorOpenIndex+1, separatorCloseIndex);
		parameterTypes = new ArrayList<>(Arrays.asList(parameterTypesAsText.split(",")));

		for (int i = 0; i < parameterTypes.size(); i++) {
			String parameterType = parameterTypes.get(i).trim();
			int spaceIndex = parameterType.indexOf(" ");
			parameterType = parameterType.substring(spaceIndex+1);

			parameterTypes.set(i, parameterType);

		}

		return parameterTypes;
	}

	private static boolean hasExtension(String filePath, String extension){
		return filePath.contains(extension);
	}

	public static void collectOrderFromCommitList() {
		CommitCollector commitCollector = new CommitCollector("elasticsearch", "C:\\Users\\anaca\\elasticsearch", "");
		
	    String commits = "b3804c47f7e8ffdf2a98a34ac34dd48b8e97e39a\r\n"
	    		+ "5cdba0383b08b24e6d829975b308e60bc81fc459\r\n"
	    		+ "64479a11c338f350def6fa8a5f8c7456e9e6d50e\r\n"
	    		+ "ad392bb11e82043259967305456d2a0c9886d02f\r\n"
	    		+ "b7ff23ff93006ed894d663cf9e97a3fbda151522\r\n"
	    		+ "a1c62759c90dc5cd52349f17888431632a606850\r\n"
	    		+ "fe6fb7135b7a0d74b179789838feae8bc1d3c71f\r\n"
	    		+ "30d7faeba29362e0116532e6f71c34342c717709\r\n"
	    		+ "2d523ace87617b25918dba13c4dd64c12a909f75\r\n"
	    		+ "6e1a04b3706e131ebac1a4be25d665d3c23f159f\r\n"
	    		+ "65c4282bb93989f2416e4351fa4fec36c8faf370\r\n"
	    		+ "541059a4d13042819fcdf3e563b2ea60ba0bb604\r\n"
	    		+ "7f271fd37aff3ad4c03a0d1cc418ed3dca592cbb\r\n"
	    		+ "be14968c44f09a0ae988c9768afeeddd114aac3e\r\n"
	    		+ "f48096950324ead67e28c53f31321bf6ca53178f\r\n"
	    		+ "4da407a869c9ce9f23aec7492d9650ec532a8d98\r\n"
	    		+ "9362ba200d13f4424fc8c9908a7eafc908bc1510\r\n"
	    		+ "3063f06fc7506a9be7331553bf77614d9ca2dd35\r\n"
	    		+ "114d10e5a96b071121ac7862e176b1e15112aadb\r\n"
	    		+ "68307aa9f3636bdccd1f1ca90f1d0fd640a019a5\r\n"
	    		+ "d2507c4ac0477f28b441f83eeac07786fb8f42b4\r\n"
	    		+ "1ff49eb8de157bb5eb6a43859ff7fcdf167d866d\r\n"
	    		+ "7eedd84dc38edd097ee8b43ad71859f11bc52501\r\n"
	    		+ "2b31f4fff7ef8e79e398a82981de485e78d22bc0\r\n"
	    		+ "f17f9a5f360a0266d0fcc9bf2ff445b28baaa3df\r\n"
	    		+ "592f5499cdf725a633022d2bc2a66e4e5f703e89\r\n"
	    		+ "da96b6e41d1b44eec8bfa170d8d0d8647e57dfef\r\n"
	    		+ "91dd9b330136028f34dadda552a468a0009d87e9\r\n"
	    		+ "96bcb47fc9260d46bed5aeeecbdd7e71cf0b5c6b\r\n";
	    
	    List<String> commitList = new ArrayList<String>(Arrays.asList(commits.split("\r\n")));
	    
	    commitList.forEach( commit -> {
	    	int order = commitCollector.getOrderCommit(commit);
	    	System.out.println(order);
	    });
	    
	}

	
	public static void countRefactoringFromList() {
		String refactorings = "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ " \"Extract Interface\"\r\n"
				+ " \"Extract Interface\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ " \"Move Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ " \"Inline Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ "\"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Move Attribute\"\r\n"
				+ " \"Extract Method\"\r\n"
				+ " \"Extract Method\"";
	    
	    List<String> refsList = new ArrayList<String>(Arrays.asList(refactorings.split("\r\n")));
	}
	
}
