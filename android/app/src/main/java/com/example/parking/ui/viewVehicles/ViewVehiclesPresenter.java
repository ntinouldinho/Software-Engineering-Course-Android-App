package com.example.parking.ui.viewVehicles;

import android.widget.Button;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;

import java.util.ArrayList;

public class ViewVehiclesPresenter {
    private ViewVehiclesView view;
    private ArrayList<Vehicle> vehicles;
    private User user;
    private UserDAO dao;

    ViewVehiclesPresenter(ViewVehiclesView view,UserDAO dao){
        this.view=view;
        user = dao.find(view.getUserName());
        vehicles = user.getVehicles();
        showVehicles();
    }

    void showVehicles(){
        ArrayList<Button> buttons = view.showVehicles(vehicles);
        view.setSongOnClickListener(buttons,vehicles);
    }

}