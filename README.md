# Tour-Rail-Android-App
A prototype Android application that has been developed under Smart India Hackathon 2017 for Indian Railways.

## Application Concept 
This project was developed under 32 hours of continuous coding so you may find some things are not written properly. There is also, a Web App that was built on this concept during that time period. 
It is the project based on the problem statement Virtual tour of railways station proposed by Indian Railways in the Smart India Hackathon(SIH). It contains the constellation of panorama and navigation to guide the user from one location to other location in the platform for various different purposes eg: Tea, Water etc. 
![img1](https://user-images.githubusercontent.com/24585799/30000873-b8a428ae-9098-11e7-85af-48bd41e4f6e9.PNG)

## Technology Stack
Application was built for two different platform. 
![img2](https://user-images.githubusercontent.com/24585799/30000886-5f27d4f0-9099-11e7-98bd-202208a3089c.PNG)

## Prerequisites 
- [Java 1.8](https://java.com/en/download/manual.jsp)
- [Android Studio](https://developer.android.com/studio/index.html)
- [Google street view API key](https://developers.google.com/maps/documentation/javascript/get-api-key)
- Working Backend that is on at this Link  

## Screenshots of Application
![img3](https://user-images.githubusercontent.com/24585799/30000890-7403212c-9099-11e7-82d1-9a172d8fd3c8.PNG)
![img4](https://user-images.githubusercontent.com/24585799/30000891-74076c8c-9099-11e7-80df-6fb1937e7885.PNG)
![img5](https://user-images.githubusercontent.com/24585799/30000892-740eabfa-9099-11e7-97db-3a4a71745bd3.PNG)

## Working 
there are two main fragments in with street view works both are responsible for providing different functionality in the project. 
```
1. SupportStreetViewPanoramaFragment
2. SupportMapFragment
```
There XML code for the interface of both fragment 

## For SupportStreetViewPanoramaFragment
```
<fragment
    android:id="@+id/streetviewpanorama"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_weight="0.5"
    class="com.google.android.gms.maps.SupportStreetViewPanoramaFragment" />
```

## For SupportMapFragment
```
<fragment
    android:id="@+id/map"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_weight="0.5"
    class="com.google.android.gms.maps.SupportMapFragment"
    map:cameraTargetLat="-33.87365"
    map:cameraTargetLng="151.20689"
    map:cameraZoom="15" />
```


the first view is responsible for street view panorama shows the normal street view and the second 
fragment is responsible for showing the map having the current location and the pegman which show where panorama is used by the user and the both fragment are connected in such a manner that if the panorama moves it will automatically update the location in the map.





## Interfaces need to implemented for the street view.

- GoogleMap.OnMarkerDragListener
- StreetViewPanorama
- OnStreetViewPanoramaChangeListener

## methods are need to be Override from the interfaces that are mentioned above    
            
-	onSaveInstanceState
-	onStreetViewPanoramaChange
-	onMarkerDragStart
-	onMarkerDragEnd
-	onMarkerDrag



Interfaces need to be implemented for pointing the markers 
  
**1.OnMapReadyCallback**

 methods need to be Override from the interface mentioned above

        a.  onMapReady

by creating the object of the SupportMapFragment we can call an MapAsync task by the instance of its object.
```
SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
mapFragment.getMapAsync(this);
```
getMapAsync call an override method onMapReady   

```
@Override
public void onMapReady(GoogleMap googleMap) {
mMap = googleMap;
LatLng pointer1 = new LatLng(lat_cord,log_cord);
mMap.addMarker(new MarkerOptions().position(pointer1).title("Marker Title"));
}
```




## Customization functionality in street view 
user-controlled functionality is available to the user when viewing the Street View panorama: panning, zooming, and traveling to adjacent panoramas. You can enable and disable user-controlled gestures through methods on StreetViewPanorama. Programmatic changes are still possible when the gesture is disabled.

mSvp is StreetviewPanorama Object of the panorama fragment 

By default, everything is True listed below we can change it by using these commands 

**setPanningGesturesEnabled()**
```
Determines whether the user will be able to re-orient the camera by dragging.
mSvp.setPanningGesturesEnabled(false);
```
**setUserNavigationEnabled()**
```
Determines whether the user will be able to move to a different panorama. Users can use a single tap on navigation links, or double tap the view, to move to a new panorama.
mSvp.setUserNavigationEnabled(false);
```

**setZoomGesturesEnabled()**
Determines whether the user will be able to pinch to zoom.
```
mSvp.setZoomGesturesEnabled(false);
```
*In addition, you can determine whether users will see street names.*
```
setStreetNamesEnabled()
```
*Determines whether the user is able to see street names displayed on the ground.*
```
mSvp.setStreetNamesEnabled(false);
```



 
 
 
 
 
 
  
  
 
