package co.grappes.bakingnanodegree.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gunjit on 19/01/18.
 */

public class FoodItem implements Parcelable{

    public String name;
    public int id;
    public String description;
    public String imageLink;
    public String videoUrl;

    public FoodItem(String name, int id, String description, String imageLink, String videoUrl) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.imageLink = imageLink;
        this.videoUrl = videoUrl;
    }

    protected FoodItem(Parcel in) {
        name = in.readString();
        id = in.readInt();
        description = in.readString();
        imageLink = in.readString();
        videoUrl = in.readString();
    }

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(id);
        parcel.writeString(description);
        parcel.writeString(imageLink);
        parcel.writeString(videoUrl);
    }
}
