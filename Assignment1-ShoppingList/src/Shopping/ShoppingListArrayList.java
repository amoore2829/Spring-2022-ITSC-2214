package Shopping;

import DataStructures.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class ShoppingListArrayList implements ShoppingListADT {
/**
* Declares an ArrayList of Grocery objects and names it shoppingList
**/
    private ArrayList<Grocery> shoppingList;

    /**
     * Default constructor of ShoppingArray object.
     */
    public ShoppingListArrayList() {
        this.shoppingList = new ArrayList<>();
    }

    /**
     * Constructor of ShoppingArray object that parses from a file.
     *
     * @param filename the name of the file to parse
     * @throws FileNotFoundException if an error occurs when parsing the file
     */
    public ShoppingListArrayList(String filename) throws FileNotFoundException, IOException {
        this.shoppingList = new ArrayList<>();
        scanFile(filename);
    }

    /**
     * Method to add a new entry. Only new entries can be added. Combines 
     * quantities if entry already exists.
     *
     * @param entry the entry to be added
     */
    @Override
    public void add(Grocery entry) {

        // TODO: Check if this item already exists
            // TODO: If it does Merge the quantity of new entry into existing entry
        if(shoppingList.contains(entry)) {
                shoppingList.set(shoppingList.indexOf(entry), entry);
            }else {
                shoppingList.add(entry);
            }
            // TODO: If it does not exist already add it as a new entry in our shopping list
    }

    /**
     * Method to remove an entry.
     *
     * @param ent to be removed
     * @return true when entry was removed
     */
    @Override
    public boolean remove(Grocery ent) {
        
        // the boolean found describes whether or not we find the
        // entry to remove
        
        boolean found = false;

        // search in the shoppingList, if find ent in the
        // list remove it, set the value of `found'
        if(shoppingList.contains(ent)) {
           shoppingList.remove(ent);
           found = true;
       }else {
           found = false;
       }
        // Return false if not found        
        return found;
    }

    /**
     * Method to find an entry.
     *
     * @param index to find
     * @return the entry if found
     * @throws EmptyCollectionException if no entry was found
     * @throws IndexOutOfBoundsException if index does exist 
     */
    @Override
    public Grocery find(int index) throws IndexOutOfBoundsException,
            EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("ECE - find");
        }
        
        // TODO:
        // check whether or not the input index number is legal
        // for example, < 0 or falls outside of the size
        if(index >  shoppingList.size() || index < 0) {
             throw new IndexOutOfBoundsException("ArrayList - find");
        }else {
            return shoppingList.get(index);
        }
        
        // TODO:
        // return the corresponding entry in the shoppingList
        // need to change the return value
        // return null;
    }

    /**
     * Method to locate the index of an entry.
     *
     * @param ent to find the index
     * @return the index of the entry
     * @throws ElementNotFoundException if no entry was found
     */
    @Override
    public int indexOf(Grocery ent) throws ElementNotFoundException {
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).compareTo(ent) == 0) {
                return i;
            }
        }

        throw new ElementNotFoundException("indexOf");
    }

    /**
     * Method to determine whether the object contains an entry.
     *
     * @param ent to find
     * @return true if and only if the entry is found
     */
    @Override
    public boolean contains(Grocery ent) {
        boolean hasItem = false;
        
        // TODO: 
        // go through the shoppingList in a loop and try to find the 
        // item in the list. If found, return true.

for(int i = 0; i < shoppingList.size(); i++) {
           if(shoppingList.get(i).compareTo(ent) == 0) {
               hasItem = true;
           }else {
               hasItem = false;
           }
       }

        // Note that using methods from ArrayList won't work,
        // You'll have to loop and search for grocery items using the
        // compareTo method from the Grocery class
        return hasItem;
    }

    /**
     * Gets the size of the collection.
     *
     * @return the size of the collection
     */
    @Override
    public int size() {
        return shoppingList.size();
    }

    /**
     * Gets whether the collection is empty.
     *
     * @return true if and only if the collection is empty
     */
    @Override
    public boolean isEmpty() {
        return shoppingList.isEmpty();
    }

    /**
     * Returns a string representing this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-25s", "NAME"));
        s.append(String.format("%-18s", "CATEGORY"));
        s.append(String.format("%-10s", "AISLE"));
        s.append(String.format("%-10s", "QUANTITY"));
        s.append(String.format("%-10s", "PRICE"));
        s.append('\n');
        s.append("------------------------------------------------------------"
                + "-------------");
        s.append('\n');
        for (int i = 0; i < shoppingList.size(); i++) {
            s.append(String.format("%-25s", shoppingList.get(i).getName()));
            s.append(String.format("%-18s", shoppingList.get(i).getCategory()));
            s.append(String.format("%-10s", shoppingList.get(i).getAisle()));
            s.append(String.format("%-10s", shoppingList.get(i).getQuantity()));
            s.append(String.format("%-10s", shoppingList.get(i).getPrice()));
            s.append('\n');
            s.append("--------------------------------------------------------"
                    + "-----------------");
            s.append('\n');
        }

        return s.toString();
    }

    /**
     * Add the quantity of a duplicate entry into the existing
     *
     * @param entry duplicate
     */
    private void combineQuantity(Grocery entry) {
        try {
            int index = this.indexOf(entry);
            shoppingList.get(index).setQuantity(
                    shoppingList.get(index).getQuantity()
                    + entry.getQuantity());
        } catch (ElementNotFoundException e) {
            System.out.println("combineQuantity - ECE");
        }

    }


    /**
     * Scans the specified file to add items to the collection.
     *
     * @param filename the name of the file to scan
     * @throws FileNotFoundException if the file is not found
     */
    private void scanFile(String filename) throws FileNotFoundException, IOException {
        Path cwd = Paths.get(filename);
        BufferedReader br = new BufferedReader(new FileReader(cwd.toFile()));

        Scanner scanner = new Scanner(br);
        String line = br.readLine();

        while (line != null) {
            String[] entries = line.split(",");
            Grocery entry = new Grocery(entries[0], entries[1],
                    Integer.parseInt(entries[2]),
                    Float.parseFloat(entries[3]),
                    Integer.parseInt(entries[4]));
            this.add(entry);
            line = br.readLine();
        }

        scanner.close();
    }
}
