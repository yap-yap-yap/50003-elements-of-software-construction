package q1;

public class Train {
    Track currentTrack;
    Junction destinationJunction;
    boolean JourneyComplete = false;
    String gaugeType;

    public void EnteringTrack(Track current_track){
        currentTrack = current_track;
        currentTrack.isOccupied = true;
    }

    public void EnteringJunction(Junction junction){
        currentTrack.isOccupied = false;
        if (junction == destinationJunction){
            JourneyComplete = true;
            break;
        }
        junction.RouteTrain(this);
        
    }

    public void ChangeEngine(String gauge){
        gaugeType = gauge;
    }

}

public class Junction {
    Track[] connectedTracks;

    public boolean CheckTrack(Track track){
        return track.isOccupied;
    }

    public void RouteTrain(Train train){
        //iterate through connectedTracks and find the next track that will lead to the destination
        Track track = connectedTracks[0]; // value from 0 to n-1 at a junction with n connected tracks
        if(train.gaugeType != track.gaugeType){
            train.ChangeEngine(track.gaugeType);
        }
        train.EnteringTrack(track);
    }
    
}

public class Track {
    Junction[] connectedJunctions;
    boolean isOccupied;
    String gaugeType;




}

