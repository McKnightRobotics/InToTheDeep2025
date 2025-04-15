package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    boolean isOpen;
    Servo claw;
    double openPos = 1;
    double closedPos = 0;
    public Claw(HardwareMap HW) {
        claw = HW.get(Servo.class,"claw");
    }

    public void openClaw() {
        claw.setPosition(openPos);
        isOpen = true;
    }

    public void closeClaw() {
        claw.setPosition(closedPos);
        isOpen = false;
    }

    public void toggle() {
        if (isOpen) {
            closeClaw();
        }
        else {
            openClaw();
        }
    }

    public void moveUp() {
        claw.setPosition(claw.getPosition() + 0.005);
    }

    public void moveDown() {
        claw.setPosition(claw.getPosition() - 0.005);
    }

    public String toString(){
        return "claw pos:" + claw.getPosition();
    }

}
