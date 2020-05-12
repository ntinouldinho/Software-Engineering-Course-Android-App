package com.example.parking.ui.newParking;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.Address;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.util.Credits;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;

import java.util.ArrayList;
import java.util.Date;

public class NewParkingPresenter {
    NewParkingView view;
    UserDAO userDAO;
    ParkingSpaceDAO parkingDAO;
    User u;

    public NewParkingPresenter(NewParkingView view, UserDAO userDAO, ParkingSpaceDAO parkingDAO) {
        this.view = view;
        this.userDAO = userDAO;
        this.parkingDAO = parkingDAO;
        u = userDAO.find(view.getUsername());
        setPlate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void add() {
        ParkingSpace p = new ParkingSpace(new Address(view.getStreet(), view.getStreetNumber(), new ZipCode(Integer.valueOf(view.getZipCode()))), false, new Credits(Integer.valueOf(view.getCredits())), new TimeRange(60), new Date(), u, view.getPlate());
        if (parkingDAO.find(p) == null) {
            parkingDAO.save(p);
            view.makeToast("Parking space added!");
        }else{
            view.makeToast("Parking space already exists!");
        }
    }

    void setPlate(){
        ArrayList<String> pl = new ArrayList<>();
        for(Vehicle v: u.getVehicles()){
            pl.add(v.getPlate());
        }
        view.setSpinner(pl);
    }
}