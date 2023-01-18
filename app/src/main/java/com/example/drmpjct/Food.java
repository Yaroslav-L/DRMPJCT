package com.example.drmpjct;

import android.graphics.Bitmap;

public class Food {

    private String foodname;
    private String kcal;
    private int foto;

    public Food(String foodname, String kcal, int foto){

        this.foodname=foodname;
        this.kcal=kcal;
        this.foto=foto;
    }

    public String getFoodname() {
        return foodname;
    }

    public String getKcal() {
        return kcal;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
