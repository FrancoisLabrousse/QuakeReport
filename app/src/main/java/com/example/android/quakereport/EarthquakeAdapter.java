package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private String primaryLocation;
    private String locationOffSet;

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if ( listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.eathquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        /** Je récupère le lieu */
        String originalLocation = currentEarthquake.getLocation();

        /** je scinde le string en 2 avec le séparateur "of" */

        if ( originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffSet = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            primaryLocation = originalLocation;
        }


        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());

        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();


        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);

        primaryLocationView.setText(primaryLocation);

        TextView locationOffSetView = (TextView) listItemView.findViewById(R.id.location_off_set);

        locationOffSetView.setText(locationOffSet);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        dateView.setText(currentEarthquake.getDate());

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        timeView.setText(currentEarthquake.getTime());

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
