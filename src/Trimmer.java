import java.io.*;
import java.util.Scanner;

/**
 * Java program to trim leading line numbers from file. Create text file in main folder and run.
 */

public class Trimmer
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Type in name of file: ");
        File file = new File(console.nextLine());

        try (PrintWriter out = new PrintWriter("trimmed" + file); Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                    {
                        //Code block to parse leading blank space and numbers from line.
                        while (!(line.isEmpty()) && line.charAt(0) == ' ')
                        {
                            line = line.substring(1);
                        }
                        while (!(line.isEmpty()) && Character.isDigit(line.charAt(0)))
                        {
                            line = line.substring(1);
                        }
                        out.println(line);
                    }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}
