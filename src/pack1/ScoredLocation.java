package pack1;

import tully.Location;
import tully.LocationInt;

/**
 * Description
 *
 * @author Noah Morton Date created: Feb 3, 2017 Part of project: TicTacToeAI
 */
public class ScoredLocation extends Location
        implements LocationInt, Comparable<ScoredLocation> {

    private int scoreOfLocation;

    /**
     * Creates a new scored location.
     *
     * @param l The location
     * @param score The score of the mentioned location.
     */
    public ScoredLocation(LocationInt l, int score) {
        super(l);
        this.scoreOfLocation = score;
    }

    public int getScoreOfLocation() {
        return scoreOfLocation;
    }

    public void setScoreOfLocation(int scoreOfLocation) {
        this.scoreOfLocation = scoreOfLocation;
    }

    /**
     * Returns a new location. Can be used to change the class back into a
     * regular location, so it interfaces with the AI dispatcher.
     *
     * @return A new Location with the sheet,row, and col of the current
     * location.
     * @see tully.Location
     */
    public Location getLocation() {
        return new Location(getSheet(), getRow(), getCol());
    }

    /**
     * Compare two scored locations, works similarly to a standard compareTo.
     *
     * @param o A ScoredLocation to compare to 'this'
     * @return -1, 0, or 1 depending on if the provided object's score is
     * greater or smaller.
     */
    @Override
    public int compareTo(ScoredLocation o) {
        if (o.getScoreOfLocation() < scoreOfLocation) {
            return -1;
        } else if (o.getScoreOfLocation() == scoreOfLocation) {
            return 0;
        } else if (o.getScoreOfLocation() > scoreOfLocation) {
            return 1;
        } else {
            throw new UnsupportedOperationException("Cannot compare values.");
        }
    }

    /**
     * Compares 'this' and the provided Object for their scores and location.
     * They are considered equal if they have the same memory address, or the
     * same score and location.
     *
     * @param o Object to check for equivalency.
     * @return True if they are both ScoredLocations and the scores/locations
     * match.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { //they are the same memory address
            return true;
        } else if (o instanceof ScoredLocation) {
            ScoredLocation temp = (ScoredLocation) o;
            if (temp.getScoreOfLocation() == this.scoreOfLocation && temp.getCol() == getCol()
                    && temp.getRow() == getRow() && temp.getSheet() == getSheet()) {
                return true;
            }
        } else if (o instanceof Location) {
            Location temp = (Location) o;
            if (temp.getCol() == getCol() && temp.getRow() == getRow() && temp.getSheet() == getSheet()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return '{' + "Loc=" + getLocation() + "Score=" + scoreOfLocation + '}';
    }

}
