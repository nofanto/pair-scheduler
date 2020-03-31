package pair.scheduler;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchedulerInputParser {
    private Reader input;
    private Writer output;

    public SchedulerInputParser(Reader input, Writer output) {
        this.input = input;
        this.output = output;
    }

    public void process() throws IOException {
        List<String> names = new ArrayList<>();
        try (Scanner scanner = new Scanner(this.input)) {
            while (scanner.hasNextLine()) {
               names.add(scanner.nextLine());
            }
            
        } catch (Exception e) {
            output.write(e.getMessage());
        }

        if(names.size() % 2 != 0) {
            names.add("N/A");
        }

        PairScheduler scheduler = new PairScheduler(names);
        output.write(scheduler.schedule());
    }
}