package ZipCodeDB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
    Stores information about all the zipcodes
 */
public class Database {

    private ArrayList<Zipcode> codes;

    public Database(){

        // allocate arraylist
        codes = new ArrayList<>();
        this.loadZips();
    }

    // fill the zipcode array list with real data
    private void loadZips(){

        // Connect to the web page of zipcodes
        URL url = null; // null is the "nothing value"
        Scanner s = null;

        try {
            url = new URL("http://10.60.15.25/~ehar/cs219/zips.txt"); // create a URL object for the path -url
            s = new Scanner(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read zipcode filld line by line
        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] parts = line.split(",");
            Zipcode z = new Zipcode(parts[1].substring(1,parts[1].length() -1),
                    parts[2].substring(1,parts[2].length() -1),
                    parts[3].substring(1,parts[3].length() -1),
                    Double.parseDouble(parts[4]),
                    Double.parseDouble(parts[5]),
                    Integer.parseInt(parts[6]));

            codes.add(z); // grows array by 1, puts z at the end of the array list
        }

        // sort the array by the zipcode (numerical order)
        Collections.sort(this.codes);
    } // loadZips

    // write a function to search for zipcode data by a zipcode
    // return reference to object if found
    // return null if not found
    public Zipcode findByZip1(String code){

        for(int i = 0; i < this.codes.size(); i++){
            if(code.equals(this.codes.get(i).getCode()))
                return this.codes.get(i);
        }
        return null; // returining nothing if the zipcode isn't found
    }

    // write a function to search for zipcode data by a zipcode
    // return reference to object if found
    // return null if not found
    public Zipcode findByZip(String code){

       // for each zipcode in the codes array list
        for (Zipcode zipcode : this.codes) {
            if (code.equals(zipcode.getCode()))
                return zipcode;
        }
        return null; // returining nothing if the zipcode isn't found
    }

    private Zipcode bsearch(String target, int low, int high){

        // when the word isn't found low and high will switch
        if(low > high)
            return null;

        int mid = (low + high) / 2;

        // checking if target is at mid
        if(this.codes.get(mid).getCode().equals(target))
            return this.codes.get(mid);
        else if(this.codes.get(mid).getCode().compareTo(target) < 0) // if mid is alphabetically less than the target
            return bsearch(target, mid+1, high);
        else // if mid is alphabetically greater than the target
            return bsearch(target, low, mid-1);
    }

    // provides a simpler interface for the bsearch method
    public Zipcode search(String code){

        // return bsearch(code, 0, codes.size() -1);
        int pos = Collections.binarySearch(this.codes, new Zipcode(code, "", "", 0, 0, 0));

        if(pos != -1)
            return this.codes.get(pos);
        else
            return null;
    }
}
