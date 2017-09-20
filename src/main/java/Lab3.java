
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Lab3 {

    public static void main(final String[] args) {

        System.out.print("Enter URL: ");
        String website = TextIO.getlnString();
        String content = urlToString(website);
        content = content.toLowerCase();
        System.out.print("Search for: ");
        String inputWord = TextIO.getlnString();
        String searchWord = inputWord.toLowerCase();
        int searchResults = 0;
        int wordCount = 0;
        for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == ' ' && content.charAt(i + 1) != ' ') {
                    wordCount++;
                }
        }
        int indexValue = 0;
        while (indexValue != -1) {
            indexValue = content.indexOf(searchWord, indexValue + 1);
            if (indexValue != -1) {
                searchResults++;
            }
        }
        System.out.println("Word Count = " + wordCount);
        System.out.println("Times " + "\"" + inputWord + "\"" + " appeared: " + searchResults);


    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
