package q7;

import java.util.HashMap;
import java.util.Map;

class Updater extends Thread {
    TrackerSafe trackerSafe;

    public Updater(TrackerSafe tra) {
        this.trackerSafe = tra;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            trackerSafe.setLocation(String.valueOf(i), Integer.parseInt(String.valueOf(currentThread().getId())),
                    Integer.parseInt(String.valueOf(currentThread().getId())));
        }
    }
}

class Viewer extends Thread {
    TrackerSafe trackerSafe;

    public Viewer(TrackerSafe tra) {
        this.trackerSafe = tra;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            TrackerSafe.MutablePoint loc = trackerSafe.getLocation(String.valueOf(i));
            loc.setX(-1212000);
            //System.out.println("id: " + i + ", location: " + loc.getX() + ", " + loc.getY());
        }
    }
}

class test {

    public static void main(String[] args) throws InterruptedException {
        Map<String, TrackerSafe.MutablePoint> locations = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            locations.put(Integer.toString(i), new TrackerSafe.MutablePoint(0,0));
        }

        TrackerSafe t = new TrackerSafe(locations);
        Updater u = new Updater(t);
        Viewer v = new Viewer(t);

        u.start();
        v.start();

        u.join();
        v.join();

        /*Map<String, TrackerSafe.MutablePoint> output = t.getLocations();
        for (Map.Entry<String, TrackerSafe.MutablePoint> entry : output.entrySet()){
            System.out.println("id: " + entry.getKey() + ", location: " + entry.getValue().getX() + ", " + entry.getValue().getY());

        }*/


    }
}

//is this class thread-safe?
public class TrackerSafe {
    //@guarded by ???
    private final Map<String, MutablePoint> locations;

    //the reference locations, is it going to be an escape?
    public TrackerSafe(Map<String, MutablePoint> locations) {
        this.locations = locations;
    }

    //is this an escape?
    public Map<String, MutablePoint> getLocations() {
        synchronized (locations){
            Map<String, MutablePoint> locations_copy = new HashMap<>();

            for (Map.Entry<String, MutablePoint> entry : locations.entrySet()){
                MutablePoint loc_copy = new MutablePoint(entry.getValue());
                locations_copy.put(entry.getKey(), loc_copy);
            }

            return locations_copy;
        }
    }

    //is this an escape?
    public MutablePoint getLocation(String id) {
        synchronized (locations){
            MutablePoint loc = locations.get(id);

            if (loc == null){
                throw new IllegalArgumentException("No such ID: " + id);
            }
            MutablePoint loc_copy = new MutablePoint(loc);
            return loc_copy;
        }
    }

    public void setLocation(String id, int x, int y) {
        synchronized (locations){
            MutablePoint loc = locations.get(id);

            if (loc == null) {
                throw new IllegalArgumentException("No such ID: " + id);
            }

            loc.setX(x);
            loc.setY(y);
        }
    }

    //this class is not thread-safe (why?)
    public static class MutablePoint {
        private int x, y;

        public MutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public MutablePoint(MutablePoint p) {
            this.x = p.x;
            this.y = p.y;
        }

        public void setX(int x){
            this.x = x;
        }

        public void setY(int y){
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

    }
}
