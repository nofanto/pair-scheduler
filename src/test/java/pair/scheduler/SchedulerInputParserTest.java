package pair.scheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class SchedulerInputParserTest {

    @Test
    public void shouldPassCase1() throws IOException {

        Reader input = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/inputCase1.txt")));
        Scanner expectedOutput = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/outputCase1.txt"))));
        Writer output = new StringWriter();

        SchedulerInputParser parser = new SchedulerInputParser(input, output);
        parser.process();
        
        Scanner actualOutput = new Scanner(new StringReader(output.toString()));
        while (actualOutput.hasNextLine()) {
            assertEquals(expectedOutput.nextLine(), actualOutput.nextLine());
        }
        
        input.close();
        expectedOutput.close();
        output.close();
        actualOutput.close();
    }

    @Test
    public void shouldPassCase2() throws IOException {
        Reader input = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/inputCase2.txt")));
        Scanner expectedOutput = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/outputCase2.txt"))));
        Writer output = new StringWriter();

        SchedulerInputParser parser = new SchedulerInputParser(input, output);
        parser.process();
        
        Scanner actualOutput = new Scanner(new StringReader(output.toString()));
        while (actualOutput.hasNextLine()) {
            assertEquals(expectedOutput.nextLine(), actualOutput.nextLine());
        }

        input.close();
        expectedOutput.close();
        output.close();
        actualOutput.close();
    }

    @Test
    public void shouldPassTheCase3() throws IOException {
        Reader input = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/inputCase2.txt")));
        Scanner expectedOutput = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/outputCase2.txt"))));
        Writer output = new StringWriter();

        SchedulerInputParser parser = new SchedulerInputParser(input, output);
        parser.process();
        
        Scanner actualOutput = new Scanner(new StringReader(output.toString()));
        while (actualOutput.hasNextLine()) {
            assertEquals(expectedOutput.nextLine(), actualOutput.nextLine());
        }

        input.close();
        expectedOutput.close();
        output.close();
        actualOutput.close();
    }
}