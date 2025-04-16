package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Climb {

    DcMotor climb;
    public Climb(HardwareMap HW) {
        climb = HW.get(DcMotor.class, "climb");
        climb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        climb.setTargetPosition(climb.getCurrentPosition());
        climb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        climb.setPower(1);
    }

    public void climbUp() {

    }

    public void climbDown() {

    }

    public String toString() {
        return  "Climb pos" + climb.getCurrentPosition();
    }
}
