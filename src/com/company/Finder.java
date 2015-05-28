package com.company;


        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.util.ArrayList;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Finder {

    private String mPath;

    public Finder(String pathToCountryDir) {
        mPath = pathToCountryDir;
    }

    private Boolean isMatchPattern(String word, String searchWord) {
        String pattern = searchWord + ".*";
        Pattern negativePattern = Pattern.compile(pattern);
        Matcher matcher = negativePattern.matcher(word);
        if (matcher.find()) {
            return true;
        }
        return false;
    }



}

