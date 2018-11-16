package me.grimlock257.unidayschallenge.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static String loadFileAsString(String file) {
        StringBuilder fileSource = new StringBuilder();

        // Try open the file, if failure, print error and exit
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            // Runs until it runs out of lines to read (must have reached the end of the file)
            while ((line = reader.readLine()) != null) {
                fileSource.append(line);
                fileSource.append("\n");
            }

            reader.close();
        } catch (IOException e) {
            // Display error messages to the console
            System.err.println("[FileUtils] Could not read file: " + file);
            e.printStackTrace();
            System.exit(1);
        }

        return fileSource.toString();
    }
}