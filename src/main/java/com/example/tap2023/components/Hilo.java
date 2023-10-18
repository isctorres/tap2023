package com.example.tap2023.components;

import javafx.scene.control.ProgressBar;

import java.util.Random;

public class Hilo extends Thread {
    private ProgressBar pgbCorredor;
    public Hilo(String nombre, ProgressBar pgb){
        this.setName(nombre);
        this.pgbCorredor = pgb;
    }

    @Override
    public void run() {
        super.run();
        try {
            double avance = 0;
            while ( avance <= 1 ){
                sleep((long) (Math.random() * 1500));
                avance += Math.random()/10;
                pgbCorredor.setProgress(avance);
                //System.out.println("Corredor "+this.getName() + " llegó al KM " + i);
            }

            //System.out.println("Corredor "+this.getName()+" llegó a la meta");
        }catch (Exception e){

        }
    }
}
