package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="FirstTest")
public class FirstTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        //Init
        DcMotorEx frontLeft = hardwareMap.get(DcMotorEx.class,"frontLeft");
        DcMotorEx backLeft = hardwareMap.get(DcMotorEx.class,"backLeft");
        DcMotorEx frontRight = hardwareMap.get(DcMotorEx.class,"frontRight");
        DcMotorEx backRight = hardwareMap.get(DcMotorEx.class,"backRight");


        DcMotorEx linearSlide = hardwareMap.get(DcMotorEx.class,"linenerSlide");
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setTargetPosition(linearSlide.getCurrentPosition());
        linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearSlide.setPower(0.5);




        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        //Start
        while(opModeIsActive()){
            double forward = gamepad1.left_stick_y;
            double rotate = -gamepad1.right_stick_x;
            double strafe = gamepad1.left_stick_x;


            frontLeft.setPower(forward + rotate - strafe);
            frontRight.setPower(forward - rotate - strafe);
            backLeft.setPower(forward + rotate + strafe);
            backRight.setPower(forward - rotate + strafe);

            double linearSlideControl = gamepad1.left_trigger - gamepad1.right_trigger;
            linearSlide.setTargetPosition(linearSlide.getCurrentPosition() + (int) linearSlideControl);
        }

    }
}
