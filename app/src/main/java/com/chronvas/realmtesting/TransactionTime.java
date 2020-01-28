package com.chronvas.realmtesting;


public class TransactionTime {
    private long start;
    private long end;

    TransactionTime(long start) {
        this.start = start;
    }

    void setEnd(long end) {
        this.end = end;
    }

    long getDuration() {
        if (this.start > 0 && this.end > 0) {
            return this.end - this.start;
        } else {
            return 0;
        }
    }
}
