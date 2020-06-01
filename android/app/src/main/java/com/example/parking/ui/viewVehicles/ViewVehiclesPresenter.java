package com.example.parking.ui.viewVehicles;

import android.util.Log;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;

import java.util.ArrayList;

public class ViewVehiclesPresenter {
    private ViewVehiclesView view;
    private ArrayList<Vehicle> vehicles;
    private User user;
    private UserDAO dao;


    /**
     * Αρχικοποεί τον Presenter.
     * @param view Ένα instance του view
     * @param dao Ένα instance του user
     */
    public ViewVehiclesPresenter(ViewVehiclesView view,UserDAO dao){
        this.view=view;
        this.user = dao.find(view.getUserName());////////intent
        showVehicles();
    }

    /**
     * Εμφανίζει τα vehicles ενος user.
     */
    public void showVehicles(){
        view.showVehicles(user.getVehicles());
    }

    /**
     * Εμφανίζει τα στοιχεία ενός vehicle.
     * @param vehicle Τα vehicles που επιλέχθηκε.
     */
    public void viewOneVehicle(Vehicle vehicle){
        Log.e("vehicle",vehicle.toString());
        view.viewOneVehicle(vehicle);
    }



}
