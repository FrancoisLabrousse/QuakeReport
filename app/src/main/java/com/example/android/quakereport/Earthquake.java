package com.example.android.quakereport;

public class Earthquake {

    /** Magnitude of the earthquake */
    private Double mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Date of the earthquake */
    private String mDate;

    /** Time of the earthquake */
    private String mTime;

    private String mUrl;

    /** Constructs a new (@link Earthquake) object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param date is the date the earthquake happened
     */

    public Earthquake(Double magnitude, String location, String date, String time, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mTime = time;
        mUrl = url;
    }

    /** Returns the magnitude of the earthquake */

    public Double getMagnitude(){return mMagnitude;}

    /** Returns the location of the earthquake */

    public String getLocation(){return mLocation;}

    /** Returns the date of the earthquake */

    public String getDate(){return mDate;}

    /** Returns the time of the earthquake */

    public String getTime(){return mTime;}

    public String getUrl(){return mUrl;}

}
