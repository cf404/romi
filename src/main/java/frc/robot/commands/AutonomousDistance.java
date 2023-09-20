// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain) {
    double straightSpeed = 0.5;
    double turnSpeed = 0.5;
    double turnDegrees = 65;
    double driveDistance = 10;
    double triangleTurnDegrees = 90;
    double hexagonTurnDegrees = 40;
    double hexagonInfinityDrivingDistance = 5;
    double InfinityTurnDegrees = 60;
    addCommands(

    // Square 
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, turnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, turnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, turnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, turnDegrees, drivetrain),

    // Triangle
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, triangleTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, triangleTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        new TurnDegrees(turnSpeed, triangleTurnDegrees, drivetrain),

    // Hexagon
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain));
/*    
    // Infinity (NOT YET COMPLETED, NOT SURE IF POSSIBLE WITH CURRENT EQUIPMENT)
        new TurnDegrees(turnSpeed, InfinityTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        new TurnDegrees(turnSpeed, InfinityTurnDegrees, drivetrain),
        new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain));
*/
  }
}