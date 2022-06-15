CompositeRefactoringCollector is a minerator tool for composite refactoring data. 
This tool can collect the following data. 
--> Single refactorings from detection tools such as RefactoringMiner 
--> Composite refactorings using the Range-Based Heuristic (Cedrim, 2018 and Sousa et al. MSR'20)
--> Code smells from detection tools such as Organic 

CompositeRefactoringCollector collects those data, executes a parser to a simple model, and saves the data in a local MongoDB database. 

Command do RefMiner used to collect refactorings 
RefactoringMiner -a <git-repo-folder> <branch> -json <path-to-json-file>
Detect refactorings between <start-commit-sha1> and <end-commit-sha1> for project <git-repo-folder>	

This tool collects the refactoring types supported by RefactoringMiner 1.0 & 2.0

Extract Method  - OK 
Inline Method  - OK
Rename Method  - OK 
Move Method   - OK 
Move Attribute   - OK 
Pull Up Method  - OK 
Pull Up Attribute - OK
Push Down Method  - OK
Push Down Attribute - OK
Extract Superclass - OK 
Extract Interface  - OK 
Move Class  - OK 
Rename Class  - OK 
Change Package (Move, Rename, Split, Merge)


Supported by RefactoringMiner 2.0
Extract Class - Ok
Extract Subclass - Ok
Extract Variable - Ok
Inline Variable - Ok
Parameterize Variable - OK
Rename Variable - Ok
Rename Parameter  - OK
Rename Attribute - OK
Move and Rename Attribute
Replace Variable with Attribute - Ok
Replace Attribute (with Attribute) - OK
Merge Variable - Ok
Merge Parameter - Ok
Merge Attribute - OK
Split Variable - OK
Split Parameter - Ok
Split Attribute - OK
Change Variable Type - Ok
Change Parameter Type - OK
Change Return Type - OK
Change Attribute Type - Ok
Extract Attribute - Ok
