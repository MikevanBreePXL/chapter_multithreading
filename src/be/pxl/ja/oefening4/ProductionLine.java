package be.pxl.ja.oefening4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductionLine {
    private final List<Object> line = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addPackage(Package packageToAdd) {
        line.add(packageToAdd);
    }

    public synchronized Optional<Package> getPackage() {
        try {
            return Optional.of((Package) line.remove(0));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public String toString() {
        return line.stream()
                .map(p -> p.toString())
                .collect(Collectors.joining(", "));
    }
}
