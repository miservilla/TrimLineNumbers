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
        System.out.print("Type in digit size to trim: ");
        trimNumber = console.nextInt();
        File file = new File(fileName);

        try
        {
            Scanner scnr = new Scanner(file);

            while (scnr.hasNextLine())
            {
                String line = scnr.nextLine();
                System.out.println(line.substring(trimNumber));
                try (FileWriter writer = new FileWriter("Trimmed" + fileName,true);
                     BufferedWriter bw = new BufferedWriter(writer))
                {
                    {
                        bw.write(line.substring(trimNumber) + "\n");
                    }
                }
            }
            scnr.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found!");
        }
        File oldfile = new  File("Trimmed" + fileName);
        oldfile.renameTo(file);

    }
}
