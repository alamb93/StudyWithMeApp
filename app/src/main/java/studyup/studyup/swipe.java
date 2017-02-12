package studyup.studyup;

/**
 * Created by Alyssa on 2/12/2017.
 */

public class swipe {

    public double lat;
    public double lng;
    public String comment;
    public String user;
    public String classid;

    public swipe() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public swipe(double lat, double lng, String classid, String comment, String user) {
        this.user = user;
        this.lat = lat;
        this.lng = lng;
        this.comment = comment;
        this.user = user;
        this.classid = classid;
    }
}
