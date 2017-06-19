package com.veena.transportapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.veena.transportapp.client.TravelClient;
import com.veena.transportapp.model.Destination;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String LATITUDE = "Latitude";
    public static final String LONGITUDE = "Longitude";

    Travel travelApi;
    List<String> destinations = new ArrayList<String>();

    private Spinner destinationSpinner;
    private TextView mode;
    private TextView car;
    private TextView train;
    private Button navigate;
    private Double latitude;
    private Double longitude;
    private String buildFlavor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinationSpinner = (Spinner) findViewById(R.id.spinner);
        mode = (TextView)findViewById(R.id.mode);
        car = (TextView)findViewById(R.id.car);
        train = (TextView)findViewById(R.id.train);

        buildFlavor = BuildConfig.FLAVOR;
        Log.d(TAG,"Build Flavor: " + buildFlavor);

        travelApi = TravelClient.getClient().create(Travel.class);

        Call<List<Destination>> call = travelApi.getDestinationList();
        call.enqueue(new Callback<List<Destination>>() {
            @Override
            public void onResponse(Call<List<Destination>> call, Response<List<Destination>> response) {
                if (response.isSuccessful()) {
                    final List<Destination> destinationList = response.body();
                    for (Destination destination : destinationList) {
                        Log.d(TAG, destination.toString());
                        destinations.add(destination.getName());
                    }

                    destinationSpinner.setAdapter(new ArrayAdapter<String>(
                            MainActivity.this,android.R.layout.simple_spinner_dropdown_item,destinations));
                    destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Destination selectedDest = destinationList.get(position);
                            mode.setText("Mode Of Transport:");
                            if (selectedDest.getFromCentral().getByCar() != null) {
                                car.setText("Car - " + selectedDest.getFromCentral().getByCar());
                            } else {
                                car.setText("");
                            }
                            if (selectedDest.getFromCentral().getByTrain() != null) {
                                train.setText("Train - " + selectedDest.getFromCentral().getByTrain());
                            } else {
                                train.setText("");
                            }

                           latitude = selectedDest.getLocation().getLatitude();
                           longitude = selectedDest.getLocation().getLongitude();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
            }

            @Override
            public void onFailure(Call<List<Destination>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        if ("full".equals(buildFlavor)) {
            navigate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), MapActivity.class);
                    intent.putExtra(LATITUDE, latitude);
                    intent.putExtra(LONGITUDE, longitude);
                    Log.d(TAG, "Latitude: " + latitude.toString());
                    Log.d(TAG, "Longitude: " + longitude.toString());
                    startActivity(intent);
                }
            });
        }

    }
}
