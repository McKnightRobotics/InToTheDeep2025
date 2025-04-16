package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name="FirstTest")
public class FirstTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        //Init
        Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap);
        Climb climb = new Climb(hardwareMap);
        MecanumDrive drive = new MecanumDrive(hardwareMap);



        DcMotorEx linearSlide = hardwareMap.get(DcMotorEx.class,"linenerSlide");
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setTargetPosition(linearSlide.getCurrentPosition());
        linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearSlide.setPower(1);


        GamepadEvents controller = new GamepadEvents(gamepad1);


        waitForStart();
        //Start
        while(opModeIsActive()){
            double forward = gamepad1.left_stick_y;
            double rotate = -gamepad1.right_stick_x;
            double strafe = gamepad1.left_stick_x;

            // movement controls
            drive.drive(forward, rotate, strafe);

            // linear slide controls
            double linearSlideControl = gamepad1.left_trigger - gamepad1.right_trigger;
            linearSlide.setTargetPosition(linearSlide.getCurrentPosition() + (int) (100*linearSlideControl));


            // Arm input.
            if (gamepad1.left_bumper) {
                arm.moveArmUp();
            }
            else if (gamepad1.right_bumper) {
                arm.moveArmDown();
            }

            // Claw input.
            //if (gamepad1.dpad_up) {
                //claw.moveUp();
            //}
            //else if (gamepad1.dpad_down) {
                //claw.moveDown();
            //}
            if (controller.y.onPress()) {
                claw.toggle();
            }


            telemetry.addLine(arm.toString());
            telemetry.addLine(claw.toString());
            telemetry.addLine(climb.toString());
            telemetry.update();
            controller.update();
        }






    }
}
