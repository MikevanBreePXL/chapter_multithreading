package be.pxl.ja.oefening4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
ProductionLine

Create a ProductionLine class that will represent the production line.
On the production line, you can only add new products at the end and take them from the front.

Use a collection of your choice from the Collection framework.
Provide methods to add a Package to the end of the production line (addPackage()) and to take a Package from the front (getPackage()).
Remember to remove the taken packages from the production line. Ensure that no exceptions can occur if there are no packages left on the line.

Make sure that all operations on the production line are synchronized, so it is not possible for multiple threads to perform an operation on
the collection at the same time. (For this, you only need to make adjustments to the addPackage() and getPackage() methods of the ProductionLine class).
 */
public class ProductionLine {
    private final List<Object> line = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addPackage(Package packageToAdd) {
        line.add(packageToAdd);
    }

    public synchronized Package getPackage() {
        try {
            return (Package) line.remove(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String toString() {
        return line.stream()
                .map(p -> p.toString())
                .collect(Collectors.joining(", "));
    }
}
