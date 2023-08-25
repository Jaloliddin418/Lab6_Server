package database;

import data.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import static data.DragonID.getId;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class  CSVDataBase {
    private static CSVFormat format = CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader("id" , "name","age","color","character","Value X","Value Y","creation date","size","toothCount","weight").build();

    public  static void writePersonsToCsv(String filename, List <Dragon> dragons) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, format);


        for (Dragon d : dragons) {
            csvPrinter.printRecord(d.getId(),
                    d.getName(),
                    d.getAge(),
                    d.getColor(),
                    d.getCharacter(),
                    d.getCoordinates().getX() ,
                    d.getCoordinates().getY(),
                    d.getCreationDate(),
                    d.getHead().getSize() ,
                    d.getHead().getToothCount(),
                    d.getWeight());
        }

        csvPrinter.flush();
        csvPrinter.close();
    }

    public static List<Dragon> readCoordinates(String filename) {
        CSVFormat formatForRead = CSVFormat.Builder.create(CSVFormat.DEFAULT)
                .setSkipHeaderRecord(true)
                .setHeader("id" , "name","age","color","character","Value X","Value Y","creation date","size","toothCount","weight")
                .build();
        List<Dragon> dragonL = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new FileReader(filename), formatForRead)) {
            for (CSVRecord record : parser) {
                Integer id = Integer.valueOf(record.get("id"));
                String name = String.valueOf((record.get("name")));
                Integer age = Integer.parseInt(record.get("age"));
                Color color = Color.valueOf((record.get("color")));
                DragonCharacter character = DragonCharacter.valueOf((record.get("character")));
                int x = Integer.parseInt(record.get("Value X"));
                long y = Long.parseLong(record.get("Value Y"));
                String zdt = String.valueOf((record.get("creation date")));
                Integer size = Integer.parseInt(record.get("size"));
                float toothCount = Float.parseFloat(record.get("toothCount"));
                int weight = Integer.parseInt(record.get("weight"));
                dragonL.add(new Dragon(id,
                        name,
                        age,
                        weight ,
                        new Coordinates(x , y) ,
                        color,
                        character,
                        new DragonHead(size,toothCount),
                        ZonedDateTime.parse(zdt)
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error parsing enum value: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        return dragonL;
    }

}
