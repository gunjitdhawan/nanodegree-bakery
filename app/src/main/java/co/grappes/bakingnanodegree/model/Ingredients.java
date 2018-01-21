package co.grappes.bakingnanodegree.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gunjit on 21/01/18.
 */

public class Ingredients implements Parcelable{
    public float quantity;
    public String measure;
    public String ingredient;

    protected Ingredients(Parcel in) {
        quantity = in.readFloat();
        measure = in.readString();
        ingredient = in.readString();
    }

    public static final Creator<Ingredients> CREATOR = new Creator<Ingredients>() {
        @Override
        public Ingredients createFromParcel(Parcel in) {
            return new Ingredients(in);
        }

        @Override
        public Ingredients[] newArray(int size) {
            return new Ingredients[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(quantity);
        parcel.writeString(measure);
        parcel.writeString(ingredient);
    }

    @Override
    public String toString() {
        return quantity+" "+measure+" "+ingredient;
    }
}
