package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@TeleOp(name="FirstTest")
public class FirstTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        //Init
        DcMotorEx frontLeft = hardwareMap.get(DcMotorEx.class,"frontLeft");
        DcMotorEx backLeft = hardwareMap.get(DcMotorEx.class,"backLeft");
        DcMotorEx frontRight = hardwareMap.get(DcMotorEx.class,"frontRight");
        DcMotorEx backRight = hardwareMap.get(DcMotorEx.class,"backRight");
        waitForStart();
        //Start
        while(opModeIsActive()){
            double forward = gamepad1.left_stick_y;
            double rotate = gamepad1.right_stick_x;
            double strafe = gamepad1.left_stick_x;
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
        }

    }
}
