package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Mecanum;
import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;
@Autonomous(name="McknightTestAuto")
public class Auto2526 extends LinearOpMode{

    MecanumDrive mecanumDrive;

    @Override
    public void runOpMode() throws InterruptedException {
        //  Starting position
        Pose2d startPosition = new Pose2d(0,0,Math.toRadians(0));
        mecanumDrive = new MecanumDrive(hardwareMap, startPosition);
            waitForStart();


        Actions.runBlocking(
                mecanumDrive.actionBuilder(startPosition)
                         // example code
                        .strafeTo(new Vector2d(0, 5))
                        .build());
        sleep(1000);

        Actions.runBlocking(
                mecanumDrive.actionBuilder(startPosition)
                        // example code
                        .lineToY(3)
                        .build());
        sleep(1000);

        while(opModeIsActive())
        {
            System.out.println("Auto active");
        }

    }




}
