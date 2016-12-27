# levelmoney
                                                Level Money Transactions
    ## Requirements
	* Load transactions from the GetAllTransactions endpoint
	* Display Income and Spend(Expenses) aggregated by month for entire data set
	* Display Monthly Average Income and Expenses
	* Filter to ignore spending on Donuts

    Steps:
        1. Download the project or Clone the project from GitHub
            git clone "https://github.com/abiuyshub/levelmoney"
        2. Go to Dircetory "levelmoney" from command line or  Linux Terminal
        3. Build the project by executing "mvn package" (i.e. please make sure that maven is installed on your machine),
           this will produce assembled zipped files that contains a *.jar file with every dependency needed to run the project
        4. When build successful, go to "target" directory (i.e CMD "cd target" will do fine)
        5. Inhere you'll see three zipped folder of type LevelMoney.zip, LevelMoney.tar, and LevelMoney.tar.gz,
           which can be extracted on Windows, Linux or Mac OS
        6. Choose the zip file you want and extract it here or to any director of your choice (i.e. Please know the directory)
        7. Go to(or cd in to) the directory you extracted the "LevelMoney" and once you are in "levelmoney" directory,
            insert this command "java -jar LevelMoney.jar" and execute it
                This will produce summary of total that the user makes and spends in each month with average from the total months.
        8. Also if you want to skip donut transaction from the report
             insert command "java -jar LevelMoney.jar ignore-donuts"


