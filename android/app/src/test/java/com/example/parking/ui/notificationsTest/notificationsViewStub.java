package com.example.parking.ui.notificationsTest;
import android.widget.Button;

import com.example.parking.domain.ParkingRequest;
import com.example.parking.ui.notifications.notificationView;

import java.util.ArrayList;

public class notificationsViewStub implements notificationView {
    private String username,result;
    private ArrayList<ParkingRequest> toApprove = new ArrayList<>();
    private ArrayList<ParkingRequest> toEnterPin = new ArrayList<>();

    public notificationsViewStub(){
        username="";
    }

    @Override
    public void showNotifications(ArrayList<ParkingRequest> DaoParkingSpace, String notif) {
        for(ParkingRequest request:DaoParkingSpace){
             if(request.getParkingSpace().getParkedUser().getUsername().equals(username)){
                if(request.getPin()!=null) {
                    toEnterPin.add(request);
                }else{
                    if(request.getDate()!=null){
                        toApprove.add(request);
                    }

                }
            }
        }
    }

    public ArrayList<ParkingRequest> getPinReq(){
        return toEnterPin;
    }

    public ArrayList<ParkingRequest> getToApprove(){
        return toApprove;
    }
    @Override
    public void enterPinListener(Button myButtons, ParkingRequest reqs) {

    }

    @Override
    public String getUserName() {
        return username;
    }

    public void setUsername(String user){
        this.username=user;
    }

    @Override
    public void makeToast(String s) {
        result=s;
    }

    public String getToast(){
        return result;
    }
}
