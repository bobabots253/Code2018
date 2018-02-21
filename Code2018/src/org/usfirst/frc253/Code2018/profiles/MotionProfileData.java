package org.usfirst.frc253.Code2018.profiles;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Data structure containing the array of points for the MP and a method to fill the MP from a csv file
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class MotionProfileData {

    /**
     * Whether or not the profile is inverted because we're driving it backwards.
     */
    private final boolean inverted;

    /**
     * Whether or not to reset the talon position when this profile starts.
     */
    private final boolean resetPosition;

    /**
     * Whether to use position PID or not.
     */
    private final boolean velocityOnly;

    /**
     * A 2D array containing 4 values for each point- position, velocity, acceleration and delta time respectively, in
     * feet, feet per second, feet per (second^2), and milliseconds.
     */
    private double data[][];

    private int numLines;
    /**
     * Default constructor
     *
     * @param filename      The filename of the .csv with the motion profile data. The first line must be the number of
     *                      other lines.
     * @param inverted      Whether or not the profile is inverted (would be inverted if we're driving it backwards)
     * @param velocityOnly  Whether or not to only use velocity feed-forward. Used for tuning kV and kA. Defaults to
     *                      false.
     * @param resetPosition Whether or not to reset the talon position when this profile starts. Defaults to false.
     */
    @JsonCreator
    public MotionProfileData(@NotNull @JsonProperty(required = true) String filename,
                             @JsonProperty(required = true) boolean inverted,
                             boolean velocityOnly,
                             boolean resetPosition) {
        this.inverted = inverted;
        this.velocityOnly = velocityOnly;
        this.resetPosition = resetPosition;

        try {
            readFile("paths/" + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the profile from the given file and store it in data.
     *
     * @param filename The name of the .csv file containing the motion profile data.
     * @throws IOException if that file doesn't exist.
     */
    private void readFile(@NotNull String filename) throws IOException {
        //Instantiate the reader
        BufferedReader br = new BufferedReader(new FileReader(filename));
        numLines = Integer.parseInt(br.readLine().split(",")[0]);

        //Instantiate data
        data = new double[numLines][3];

        //Declare the arrays outside the loop to avoid garbage collection.
        String[] line;
        double[] tmp;

        //Iterate through each line of data.
        for (int i = 0; i < numLines; i++) {
            //split up the line
            line = br.readLine().split(",");
            //declare as a new double because we already put the old object it referenced in data.
            tmp = new double[3];

            tmp[0] = Double.parseDouble(line[0]);
            tmp[1] = Double.parseDouble(line[1]);
            tmp[2] = Double.parseDouble(line[2]);
            
            data[i] = tmp;
        }
        //Close the reader
        br.close();
    }

    /**
     * @return A 2D array containing 3 values for each point- position, velocity, and delta time respectively.
     */
    @NotNull
    public double[][] getData() {
        return data;
    }
    
    public int getNumLines(){
    	return numLines;
    }

    /**
     * @return Whether to use position PID or not.
     */
    public boolean isVelocityOnly() {
        return velocityOnly;
    }

    /**
     * @return Whether or not the profile is inverted because we're driving it backwards.
     */
    public boolean isInverted() {
        return inverted;
    }

    /**
     * @return Whether or not to reset the talon position when this profile starts.
     */
    public boolean resetPosition() {
        return resetPosition;
    }
}
