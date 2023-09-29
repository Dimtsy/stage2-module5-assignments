package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String name;
    private static final Long PERIOD = 10_000_000_000_000L;
    private String version;
    private Integer cheap;
    private List<String> stringList = new LinkedList<>();

    public LocalProcessor() {
    }

    public LocalProcessor(String name, String version, Integer cheap, List<String> stringList) {
        this.name = name;
        this.version = version;
        this.cheap = cheap;
        this.stringList = stringList;
    }

    @ListIteratorAnnotation
    public void ListIterator(List<String> stringList) {
        for (int i = 0; i < PERIOD; i++) {
            if (stringList.get(i) != null) {
                System.out.println(stringList.get(i).hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String FullNameProcessorGenerator(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringList) {
            stringBuilder.append(str).append(" ");
        }
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void ReadFullProcessorName(File file) throws FileNotFoundException {
        Scanner scanner = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            version = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
