import java.io.*;
import java.util.Scanner;

/**
 * Java program to trim leading line numbers from file.
 */

public class Trimmer
{
    public static void main(String[] args)
    {
        String fileName;
        int trimNumber;
        Scanner console = new Scanner(System.in);
        System.out.print("Type in name of file: ");
        fileName = console.nextLine();
        File file = new File(fileName);

        try
        {
            Scanner scnr = new Scanner(file);

            while (scnr.hasNextLine())
            {
                String line = scnr.nextLine();
                try (FileWriter writer = new FileWriter("Trimmed" + fileName,true);
                     BufferedWriter bw = new BufferedWriter(writer))
                {
                    {
                        while (!(line.isEmpty()) && line.charAt(0) == ' ')
                        {
                            line = line.substring(1);
                        }
                        while (!(line.isEmpty()) && Character.isDigit(line.charAt(0)))
                        {
                            line = line.substring(1);
                        }
                        bw.write(line + "\n");
                    }
                }
            }
            scnr.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found!");
        }
        File oldfile = new File("Trimmed" + fileName);
        oldfile.renameTo(file);

    }
}
