package com.example.parking.ui.notifications;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.User;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.util.Pin;

import java.util.ArrayList;
import java.util.List;

public class notificationsPresenter {
    notificationView view;
    ParkingRequestDAO dao;
    UserDAO users;
    @RequiresApi(api = Build.VERSION_CODES.O)
    notificationsPresenter(notificationView view, ParkingRequestDAO dao, UserDAO users){
        this.view=view;
        this.dao=dao;
        this.users=users;
        String username = view.getUserName();
        ArrayList<ParkingRequest> all = new ArrayList<>();




        for(ParkingRequest request:(ArrayList<ParkingRequest>) dao.findAll()){
            if(request.getRequestingUser().getUsername().equals(username) || request.getParkingSpace().getParkedUser().getUsername().equals(username) ){
                all.add(request);
            }
        }
        view.showNotifications(all,username);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    boolean validateParking(ParkingRequest request, Pin pin){
        Log.e("requesting credits befo",String.valueOf(users.find(request.getRequestingUser().getUsername()).getCredits().getPoints()));
        Log.e("parked credits befo",String.valueOf(users.find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints()));
        int results = dao.find(request).validateParking(pin);


       if(results==1){
            dao.delete(request);
           Log.e("requesting credits afte",String.valueOf(users.find(request.getRequestingUser().getUsername()).getCredits().getPoints()));
           Log.e("parked credits afte",String.valueOf(users.find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints()));

           view.makeToast("Transaction complete");
            return true;
       }else{
           view.makeToast("Wrong pin.");
           return false;
       }
    }

    void approveRequest(ParkingRequest request){
        request.setPin(new Pin(Pin.createPin()));
        Log.e("the new pin",String.valueOf(request.getPin().getPin()));
    }

    void denyRequest(ParkingRequest request){
        request.setDate(null);
    }
}
