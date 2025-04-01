package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    Servo arm;
    public Arm(HardwareMap HW) {
        arm = HW.get(Servo.class, "arm");
    }

    public void moveArmUp() {
        arm.setPosition(arm.getPosition() + 0.005);
    }

    public void moveArmDown() {
        arm.setPosition(arm.getPosition() - 0.005);
    }

    public String toString(){
        return "arm pos:" + arm.getPosition();
    }


}
