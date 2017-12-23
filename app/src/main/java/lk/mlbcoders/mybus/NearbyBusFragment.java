package lk.mlbcoders.mybus;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NearbyBusFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NearbyBusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NearbyBusFragment extends Fragment  {


    private GoogleMap mMap;

    public NearbyBusFragment() {
        // Required empty public constructor
    }

    public static NearbyBusFragment newInstance() {
        NearbyBusFragment fragment = new NearbyBusFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(getThisFragment());
    }
//
//    private OnMapReadyCallback getThisFragment() {
//        return this;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nearby_bus, container, false);
    }

    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng startLocation = new LatLng(6.9360717, 79.9809851);
//        mMap.addMarker(new MarkerOptions().position(startLocation).title("Kaduwela"));
//
//        LatLng endLocation = new LatLng(6.9236094, 79.8811531);
//        mMap.addMarker(new MarkerOptions().position(endLocation).title("Kollupitiya"));
//
//        LatLngBounds sri_Lanka = new LatLngBounds(new LatLng(5.87, 80.37), new LatLng(9.94, 80.90));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(sri_Lanka, 0));
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(sri_Lanka, 0));
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(startLocation));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(endLocation));
//
//        CameraUpdate cameraPosition = CameraUpdateFactory.newLatLngZoom(startLocation, 10);
//
//        googleMap.moveCamera(cameraPosition);
//        googleMap.animateCamera(cameraPosition);
//
//        PolylineOptions polylineOptions = new PolylineOptions()
//                .geodesic(true)
//                .color(Color.BLUE)
//                .width(10);
//
//        polylineOptions.add(startLocation);
//        polylineOptions.add(endLocation);
//    }
}
