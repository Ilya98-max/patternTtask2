package org.example.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelFileReader {
    private static final Logger logger = LogManager.getLogger(HotelFileReader.class.getName());

    public static List<Integer> readBookingData(String filePath) {
        List<Integer> roomNumbers = new ArrayList<>();
        try (InputStream inputStream = HotelFileReader.class.getClassLoader().getResourceAsStream(filePath);
             Scanner scanner = new Scanner(inputStream)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                try {
                    int roomNumber = Integer.parseInt(line);
                    roomNumbers.add(roomNumber);
                } catch (NumberFormatException e) {
                    logger.error("Error parsing room number from line: " + line);
                }
            }
        } catch (IOException | NullPointerException e) {
            logger.error("Error reading file: " + filePath, e);
        }
        return roomNumbers;
    }
}


