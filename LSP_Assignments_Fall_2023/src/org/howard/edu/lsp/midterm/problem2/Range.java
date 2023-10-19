package org.howard.edu.lsp.midterm.problem2;

public class Range {
	private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isInRange(int value) {
        return value >= start && value <= end;
    }

    public boolean overlaps(Range otherRange) {
        return (start <= otherRange.end && end >= otherRange.start);
    }

    public int size() {
        return Math.abs(end - start) + 1;
    }
}
//