package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class FileReader {

    static final Logger logger = Logger.getLogger(FileReader.class);

    private static FileReader instance;
    private FileReader() {}

    public static FileReader getInstance() {
        if(instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    public List<String> read(final String fileName) throws FileNotFoundException {
        List<String> fileLine = new ArrayList<String>();

        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileLine.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            logger.error("impossible de trouver le fichier !");
            throw e;
        }
        return fileLine;
    }

}
