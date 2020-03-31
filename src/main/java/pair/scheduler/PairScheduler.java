package pair.scheduler;

import java.util.ArrayList;
import java.util.List;

public class PairScheduler {

    private final List<String> names;
    private final List<Schedule> schedules;
    private final int personCount;
    private final int maxPairPerIteration;
    
    public PairScheduler(List<String> names) {
        this.names = names;
        this.schedules = new ArrayList<>();
        this.personCount = this.names.size();
        this.maxPairPerIteration = personCount /2;
    }

    private List<String> getPossiblePairs() {
        List<String> result = new ArrayList<>();
        this.names.forEach((pair1) -> {
            this.names.forEach((pair2) -> {
                if(!pair1.equals(pair2)) {
                    String currentPair = pair1 + "-" +  pair2;
                    String reversePair =  pair2 + "-" + pair1;
                    if(!result.contains(currentPair) && !result.contains(reversePair)) {
                        result.add(currentPair);
                    }
                }
            });
        });
        return result;
    }

    private Schedule getSchedule(List<String> possiblePairs, List<String> previousPairs, int iterationNumber) {
        final List<String> registeredNames = new ArrayList<>();
        final List<String> currentPairs = new ArrayList<>();
        
        int iterateCount = 1;
        int size = possiblePairs.size();
        
        while (iterateCount < maxPairPerIteration && currentPairs.size() < maxPairPerIteration) {
            currentPairs.clear();
            registeredNames.clear();
            fillSchedule(possiblePairs, previousPairs, registeredNames, currentPairs, iterateCount, size);
            iterateCount++;
        }
        
        if(currentPairs.size() < maxPairPerIteration){
            final List<String> availablePairs = getPossiblePairs();
            for (int i = 0; i < availablePairs.size(); i++) {
                String pair = availablePairs.get(i);
                fillWithPair(previousPairs, registeredNames, currentPairs, pair);
            }
        }

        possiblePairs.removeAll(currentPairs);

        return new Schedule(currentPairs, iterationNumber);
    }

    private void fillSchedule(List<String> possiblePairs, List<String> previousPairs, final List<String> registeredNames,
            final List<String> currentPairs, int iterateCount, int size) {
        for (int i = 0; i < size; i++) {
            int firstPersonIndex = i + iterateCount;
            if(firstPersonIndex >= size){
                firstPersonIndex = firstPersonIndex % size;
            }
            String pair = possiblePairs.get(firstPersonIndex);
            fillWithPair(previousPairs, registeredNames, currentPairs, pair);
        }
    }

    private void fillWithPair(List<String> previousPairs, final List<String> registeredNames,
            final List<String> currentPairs, String pair) {
        String[] pairingSplit = pair.split("-");
        String navigator = pairingSplit[0];
        String driver = pairingSplit[1];
        if(!registeredNames.contains(navigator) && !registeredNames.contains(driver)) {
            String currentPair = navigator + "-" +  driver;
            String reversePair =  driver + "-" + navigator;
            
            if(!previousPairs.contains(currentPair) && !previousPairs.contains(reversePair)) {
                registeredNames.add(navigator);
                registeredNames.add(driver);
                currentPairs.add(pair);
            }
        }
    }

    public String schedule() {
        StringBuilder result = new StringBuilder();
        final List<String> possiblePairs = getPossiblePairs();
        final List<String> previousPairs = new ArrayList<>();

        int iteration = 0;
        while (possiblePairs.size() > 0) {
            Schedule schedule = getSchedule(possiblePairs, previousPairs, iteration);
            this.schedules.add(schedule);
            previousPairs.clear();
            previousPairs.addAll(schedule.pairs());
            iteration++;
        }

        for (int i = 0; i < this.schedules.size(); i++) {
            Schedule schedule = this.schedules.get(i);
            result.append("Iteration " + i + ":\n");
            result.append(schedule.printPairs());
        }

        return result.toString();
    }
}