package com.example.mapdemo;

import com.google.android.gms.maps.model.LatLng;

 class NamedLocation implements Comparable<NamedLocation> {
    public final String name;
    public final LatLng location;
    public final String formatted_phone_number;
    public final String address;
    public final String office_image_url;
    public final String distance;

    NamedLocation(String name, LatLng location, String formatted_phone_number, String address, String office_image_url, String distance) {
        this.name = name;
        this.location = location;
        this.formatted_phone_number = formatted_phone_number;
        this.address = address;
        this.office_image_url = office_image_url;
        this.distance = distance;
    }
    
    public String getDistance(){
    	return this.distance;
    			
    }

	@Override
	public int compareTo(NamedLocation another) {
		// TODO Auto-generated method stub
	       // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        int last = this.distance.compareTo(another.distance);
        return last == 0 ? last : this.distance.compareTo(another.distance) ;
		
	}


}