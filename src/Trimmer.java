import java.io.*;
import java.util.Scanner;

/**
 * Java program to trim leading line numbers from file.
 */

public class Trimmer
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Type in name of file: ");
        File file = new File(console.nextLine());

        try
        {
            Scanner scnr = new Scanner(file);

            while (scnr.hasNextLine())
            {
                String line = scnr.nextLine();
                try (FileWriter writer = new FileWriter("Trimmed" + file,true);
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
        File oldfile = new File("Trimmed" + file);
        oldfile.renameTo(file);

    }
}
