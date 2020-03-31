# Pair Scheduler

## Overview

Generate schedule for Pair Programming.

## Prerequisite

- JDK >= 1.8
- Gradle

## Usage

1. Clone or download
2. Run ```gradle build```
3. Run ```java -jar build/libs/pair.scheduler.jar <input-file> <output-file>``` or run ```gradle run --args="<input-file> <output-file>"```

### Rules:

- format of input file is list of name separated by new line (see ```sampleInput.txt```)

### Examples:

- input file with content like this :

```
John
Alice
Bob
Bill
```

- will produce output

```
Iteration 0:
pair-0 : John-Bob
pair-1 : Alice-Bill
Iteration 1:
pair-0 : John-Bill
pair-1 : Alice-Bob
Iteration 2:
pair-0 : Bob-Bill
pair-1 : John-Alice
```