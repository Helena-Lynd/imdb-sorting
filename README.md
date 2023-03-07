# imdb-sorting<br>
A Java program that reads in data pulled from imdb and sorts movies according to a set of queries.

![ProgramResults](https://github.com/Helena-Lynd/imdb-sorting/blob/main/program-output.png?raw=true)

## Description<br>
Many web services store an incredibly large amount of data that users are able to access and narrow down through searching for particular aspects of what they
would like. This program takes a subset of data from imdb (stored in .tsv files) and allows users to search for movies. There is functionality for five queries:
- "CONTAINS MOVIE <i>keyword</i>" : Find all movies containing <i>keyword</i> in the title
- "LOOKUP <i>id</i>" : Find a movie by its unique id
- "YEAR_AND_GENRE MOVIE <i> year genre </i>" : Find all movies released in a <i>year</i> with <i>genre</i>
- "RUNTIME MOVIE <i> low_bound high_bound</i>" : Find all movies with a runtime between the two given numbers
- "MOST VOTES <i>number</i> MOVIE" : Find the top <i>number</i> movies with the most amount of votes

## Getting Started<br>
### Dependencies
- Java 18+
- IntelliJ IDE
### Installing
- Download the source files provided to your directory of choice
```
git clone git@github.com:Helena-Lynd/imdb-sorting.git
```
### Executing
- Open the project in IntelliJ
- Play any of the given run configurations
## Modifying
- If you would like to read in different data, replace the information in "data/small.basics.tsv" or "data/small.ratings.tsv" with your preferred data set. Do not
change the order of the columns, it is essential that the .tsv files are in this format for the program to run. Be careful using large data sets, as these can take
quite some time to run.
- If you would like to run different queries than the ones provided, replace the information in "input/small-1.txt". Ensure your queries are written in the same format
as the provided queries, the program will not run with improper syntax.
## Common Errors
"Imports could not be resolved"
- Ensure that your JDK is configured for the project
- Right-click on the "src" folder and <i>Mark as Sources Root</i>
## Authors<br>
Helena Lynd
