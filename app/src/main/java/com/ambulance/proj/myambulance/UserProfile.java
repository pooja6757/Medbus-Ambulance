package com.ambulance.proj.myambulance;

public class UserProfile {
    public String userid;
    public String userPhone;
    public String userEmail;
    public String userName;
    public String userAmbNo;



    public UserProfile() {

    }




    public UserProfile(String userPhone, String userEmail, String userName, String userAmbNo) {

        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAmbNo=userAmbNo;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserEmail() {

        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserAmbNo() {

        return userAmbNo;
    }
    public void setUserAmbNo(String userAmbNo) {
        this.userAmbNo = userAmbNo;
    }
}