package org.firstinspires.ftc.teamcode.TeleOps;

//import com.qualcomm.robotcore.eventloop.opmode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

//@TeleOp
public class MotorTest extends LinearOpMode {
    //Teleop bob = new Teleop();
    private DcMotor motor1;
    private Servo servo1;
    private ColorSensor color1;

    public void runOpMode() throws InterruptedException{
        // "frontLeft" is a placeholder until I find the actual motor name
        motor1=hardwareMap.get(DcMotor.class,"frontLeft");
        servo1=hardwareMap.get(Servo.class,"thing");
        color1=hardwareMap.get(ColorSensor.class,"???");

        waitForStart();
        while(opModeIsActive()){
            // setPower() can be from -1 to 1
            motor1.setPower(1);

            // setVelocity() sets the RPM (I think)
            // setVelocity() is only available for DcMotorEx
            //motor1.setVelocity(200);

            // setPosition() (for servos) can be from 0 to 1
            servo1.setPosition(1);
            servo1.getPosition();

            // returns the amount of blue color detected
            double num1 = color1.blue();
        }
    }

    /* DcMotorEx version:
    private DcMotorEx motor1;
    public void runOpMode() throws InterruptedException{
        // "frontLeft" is a placeholder until I find the actual motor name
        motor1.hardwareMap.get(DcMotorEx.class,"frontLeft");
        waitForStart();
        while(opModeIsActive()){
            motor1.setPower(1);
        }
    }
    */

    //@Override
    //public void loop(){
    //bob.setMotorSpeed(0.5);
    //telemetry.addData("Motor Power", 0.5);
    //telemetry.update();
    //}
}
