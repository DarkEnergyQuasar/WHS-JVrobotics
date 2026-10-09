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
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    // motor4 doesn't exist yet, it's for the intake system.
    // servo1 and color1 also don't exist right now.
    private DcMotor motor4;
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
        motor1=hardwareMap.get(DcMotor.class,"bottom left");
        motor2=hardwareMap.get(DcMotor.class,"top right");
        motor3=hardwareMap.get(DcMotor.class,"bottom right");
        //servo1=hardwareMap.get(Servo.class,"thing");
        //color1=hardwareMap.get(ColorSensor.class,"???");

        boolean intakeIsOn = false;

        telemetry.addData("Status","Initialized");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Status","Running");
            telemetry.update();

            // setPower() can be from -1 to 1
            //motor0.setPower(0.25);

            // setPosition() for a servo can be from 0 to 1 for most servos,
            // with 0 being 0 degrees and 1 being 180 degrees.

            ////// controller stuff
            // left stick controls forewards/backwards movement, and strafing
            // right stick controls turning
            // for y values, -1 = top position, and 1 = bottom position
            // for x values, -1 = left position, and 1 = right position


            double tgtPower0 = -0.3*(-this.gamepad1.left_stick_y+this.gamepad1.left_stick_x)-0.3*this.gamepad1.right_stick_x;
            // remember to change tgtPower1 back to normal after the motor is fixed!
            double tgtPower1 = -0*(-this.gamepad1.left_stick_y-this.gamepad1.left_stick_x)-0.3*this.gamepad1.right_stick_x;
            double tgtPower2 = -0.3*(this.gamepad1.left_stick_y+this.gamepad1.left_stick_x)-0.3*this.gamepad1.right_stick_x;
            double tgtPower3 = -0.3*(this.gamepad1.left_stick_y-this.gamepad1.left_stick_x)-0.3*this.gamepad1.right_stick_x;

            motor0.setPower(tgtPower0);
            // motor1 (the back left motor) has been disabled because the motor isn't properly attatched
            //motor1.setPower(tgtPower1);
            motor2.setPower(tgtPower2);
            motor3.setPower(tgtPower3);

            // toggles the intake motor on and off when the X button is pressed
            if(this.gamepad1.xWasReleased()){
                if(intakeIsOn){
                    intakeIsOn=false;
                    //motor4.setPower(0);
                }else{
                    intakeIsOn=true;
                    //motor4.setPower(0.5);
                }
            }

            telemetry.addData("M0 Target Power",tgtPower0);
            telemetry.addData("Motor0 Power",motor0.getPower());

            telemetry.addData("M1 Target Power",tgtPower1);
            telemetry.addData("Motor1 Power",motor1.getPower());

            telemetry.addData("M2 Target Power",tgtPower2);
            telemetry.addData("Motor2 Power",motor2.getPower());

            telemetry.addData("M3 Target Power",tgtPower3);
            telemetry.addData("Motor3 Power",motor3.getPower());

            telemetry.addData("intake is on",intakeIsOn);

            // setVelocity() sets the RPM (I think)
            // setVelocity() is only available for DcMotorEx
            //motor0.setVelocity(200);

            // setPosition() (for servos) can be from 0 to 1
            //servo1.setPosition(1);
            //servo1.getPosition();

            // returns the amount of blue color detected
            // this also works for other colors
            //double num1 = color1.blue();
        }
    }
}
