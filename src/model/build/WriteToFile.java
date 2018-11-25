package model.build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter output = null;

    public WriteToFile()
    {
        try{
            file = new File("Output.txt");
            fileWriter = new FileWriter(file);
            output = new BufferedWriter(fileWriter);
        } catch (IOException e)
        { }
    }

    public void	writetofile(String str) {
        try {
            output.write(str);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            if (output != null)
                output.close();
        } catch (Exception ex) {
            System.out.println("Error in closing the file");
        }
    }
}