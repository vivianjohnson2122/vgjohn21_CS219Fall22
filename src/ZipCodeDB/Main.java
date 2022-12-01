package ZipCodeDB;


public class Main {

    public static void main(String[] args) {

        // z1 is a reference to a zipcode object
        Zipcode z1 = new Zipcode("13617", "NY", "Canton", 75.16, 44.59, 11781);
        Zipcode z2 = new Zipcode("94903", "CA", "Terra Linda", 122.54, 38.01, 25563);

        // could do z1.toString() but it isn't needed
        System.out.println(z1);
        System.out.println(z2);

        Database db = new Database();

        System.out.println(db.findByZip("12901"));
        System.out.println(db.findByZip("hello"));

        System.out.println(db.search("13617"));
        System.out.println(db.search("94901"));

        WeatherObservation wob = db.search("13617").getWeatherData();
        System.out.println(wob);
    }
}
