package com.ambulance.proj.myambulance;



public class PhoneTest {

    public String phone,id;


    public PhoneTest()
    {

    }


    public PhoneTest(String id, String phone)

    {
        this.id=id;
        this.phone=phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
