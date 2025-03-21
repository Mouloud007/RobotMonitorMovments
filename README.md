# RobotMonitorMovments

## What is This Project?
`RobotMonitorMovments` is a robot navigation system I built as part of my studies at the University of East London for the CN6008 - Advanced Topics in Computer Science module. It’s a blend of formal design and practical coding: I first modeled the robot’s behavior using VDM-SL (a formal specification language), then brought it to life with Java and JavaFX. The robot moves on a 6x6 grid, starting at position `(1,1)`, and can shift in four directions—left, right, up, or down—while tracking its spot and resetting to the start when it hits `(6,6)`.

## How Was It Created?
I kicked things off with VDM-SL in `RobotMonitor.rtf`, sketching out the robot’s world: its position (row and column), last move, and rules like staying within the grid and only resetting from the exit point `(6,6)`. I set up test cases in `TestRM.rtf`—like checking if the robot’s at `(6,6)` before exiting—and ran them in VDMTools to make sure the design held up.

Next, I turned that model into a working program using Java and JavaFX. The Java files handle the logic: one class defines the robot’s state and movements, another manages custom exceptions inspired by VDM’s precision, and others tie it all together. JavaFX steps in to give it a visual twist—a simple GUI where you can see the robot move on the grid and click to control it, alongside a text-based version for console fans.

## What’s Inside?
- **`RobotMonitor.rtf`**: The VDM-SL blueprint of the robot’s behavior.
- **`TestRM.rtf`**: Test scenarios to prove the model works.
- **`src/Move.java`**: Defines the robot’s movement directions.
- **`src/RobotMonitor.java`**: The core class managing the robot’s position and actions.
- **`src/RobotGUI.java`**: Sets up the JavaFX interface to visualize the grid and robot.
- **`src/RunRobotGUI.java`**: Launches the graphical version.
- **`src/RunRobotText.java`**: Runs a text-based version in the console.
- **`src/VDMExceptions.java`**: Custom exceptions to enforce VDM-like rules.
- **`.gitignore`**: Keeps IDE clutter out of the repo.

## How to Try It
- **VDM-SL**: Grab VDMTools from [Overture Tool](http://overturetool.org/), load the `.rtf` files, and run the tests to see the formal side.
- **Java/JavaFX**: You’ll need a Java JDK (17+ recommended) and JavaFX installed. From the `src/` folder:
  - Compile: `javac *.java` (add JavaFX’s `--module-path` and `--add-modules` if needed).
  - Run the GUI: `java RunRobotGUI` for the visual experience.
  - Run the text version: `java RunRobotText` for a command-line take.

## Why It’s Cool
This project mixes theory with practice. VDM-SL let me plan every detail upfront, catching mistakes before they happened, while Java and JavaFX made it real—letting you watch the robot roam the grid or steer it via text commands. It’s a neat showcase of turning a formal idea into something you can play with.
