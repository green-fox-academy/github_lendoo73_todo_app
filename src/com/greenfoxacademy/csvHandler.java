package com.greenfoxacademy;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class csvHandler {
    String filePath;
    String fileName;

    public csvHandler(String fileName) {
        this.fileName = fileName;
        this.filePath = "";
    }

    private String getPathName() {
        return this.filePath + this.fileName;
    }

    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();

        try {
            Path filePath = Paths.get(getPathName());
            lines = Files.readAllLines(filePath);
        } catch (NoSuchFileException error) {
            //System.out.println("File not found");
        } catch (Exception error) {
            System.out.println("An error occured, please try again...");
        }
        finally {
            return lines;
        }
    }

    public void append(String content) {

        List<String> lines = readAllLines();

        if (lines.size() == 0) {
            lines = new ArrayList<>();
        }

        lines.add(content);
        write(lines);
    }

    public void write( List<String> lines) {
        try {
            Path filePath = Paths.get(getPathName());
            Files.write(filePath, lines);
        }
        catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    public void printWithRowNumber() {
        printWithRowNumber(" - ");
    }

    public void printWithRowNumber(String prefix) {
        printWithRowNumber(1, "-1", prefix, prefix);
    }

    public void printWithRowNumber(int col, String equalsWith, String truePrefix, String falsePrefix) {
        col -= 1;
        List<String> lines = readAllLines();

        for (int row = 0; row < lines.size(); row++) {
            String[] parsedData = lines.get(row).split(",");
            String description = parsedData[0];
            String prefix = falsePrefix;
            if (parsedData[col].equals(equalsWith)) {
                prefix = truePrefix;
            }
            System.out.println(row + 1 + prefix + description);
        }
    }

    public boolean isExistsFile() {
        Path path = Paths.get(getPathName());
        return Files.exists(path);
    }

    public int numOfLines() {
        return readAllLines().size();
    }

    public boolean isEmpty() {
        return !notEmpty();
    }

    public boolean notEmpty() {
        return isExistsFile() && numOfLines() > 0;
    }

    public void changeCell(int row, int col, String data) {
        List<String> lines = readAllLines();
        String currentRow = getRow(row);
        String[] currentRowCells = currentRow.split(",");
        currentRowCells[col - 1] = data;
        String updatedRow = String.join(",", currentRowCells);
        lines.set(row - 1, updatedRow);
        write(lines);
    }

    public String getRow(int row) {
        List<String> lines = readAllLines();
        return lines.get(row - 1);
    }

    public void removeRow(int row) {
        List<String> lines = readAllLines();
        lines.remove(row - 1);
        write(lines);
    }
}
