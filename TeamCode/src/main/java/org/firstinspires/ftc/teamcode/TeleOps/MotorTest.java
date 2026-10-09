package org.firstinspires.ftc.teamcode.TeleOps;

//import com.qualcomm.robotcore.eventloop.opmode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MotorTest extends LinearOpMode {
    //Teleop bob = new Teleop();
    private DcMotor motor0;
    private Servo servo1;
    private ColorSensor color1;

    @Override
    public void runOpMode() throws InterruptedException{
        // motor names:
            // motor0 = "top left"
            // motor1 = "bottom left"
            // motor2 = "top right"
            // motor3 = "bottom right"
        motor0=hardwareMap.get(DcMotor.class,"top left");
        //servo1=hardwareMap.get(Servo.class,"thing");
        //color1=hardwareMap.get(ColorSensor.class,"???");

        telemetry.addData("Status","Initialized");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Status","Running");
            telemetry.update();

            // setPower() can be from -1 to 1
            motor0.setPower(1);

            // setVelocity() sets the RPM (I think)
            // setVelocity() is only available for DcMotorEx
            //motor0.setVelocity(200);

            // setPosition() (for servos) can be from 0 to 1
            //servo1.setPosition(1);
            //servo1.getPosition();

            // returns the amount of blue color detected
            //double num1 = color1.blue();
        }
    }
}
