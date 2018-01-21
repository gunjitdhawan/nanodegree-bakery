package co.grappes.bakingnanodegree.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gunjit on 21/01/18.
 */

public class Step implements Parcelable{
    public int id;
    public String description;
    public String shortDescription;
    public String videoURL;
    public String thumbnailURL;

    protected Step(Parcel in) {
        id = in.readInt();
        description = in.readString();
        shortDescription = in.readString();
        videoURL = in.readString();
        thumbnailURL = in.readString();
    }

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(description);
        parcel.writeString(shortDescription);
        parcel.writeString(videoURL);
        parcel.writeString(thumbnailURL);
    }
}
