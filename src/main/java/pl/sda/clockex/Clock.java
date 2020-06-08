package pl.sda.clockex;

public class Clock {

    private int hour, minutes, seconds; //0

    public Clock() {
    }

    public Clock(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public Clock(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() { return seconds; }


    public void setHour(int hour) {
        this.hour = hour;

        if (hour > 23)
            this.hour = 23;
        if (hour < 0)
            this.hour = 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;

        if (minutes > 59)
            this.minutes = 59;
        if (minutes < 0)
            this.minutes = 0;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;

        if (seconds > 59)
            this.seconds = 59;
        if (seconds < 0)
            this.seconds = 0;
    }
    //1:30
    //+30min

    //60min
    public void addMinutes(int minutes) {
        int summedMinutes = this.minutes + minutes;
        if (summedMinutes > 59) {
            int hoursFromMinutes = summedMinutes / 60;    //61/60 = 1; 30/60 = 0
            addHours(hoursFromMinutes);

            this.minutes = summedMinutes - hoursFromMinutes * 60;
        } else {
            this.minutes += minutes;
        }
    }
    //23:00
    //+2h
    //25h % 24 = 1

    //-> 1:00

    public void addHours(int hours) {
        int summedHours = this.hour + hours;
        if (summedHours > 23) {
            this.hour = summedHours % 24;
        } else {
            this.hour += hours;
        }
    }

    public void addClock(Clock another) {
        if (another != null) {
            int secondsFromHours = 3600 * another.getHour();
            int secondsFromMinutes = 60 * another.getMinutes();
            this.addSeconds(secondsFromHours + secondsFromMinutes + another.getSeconds());
        }
        //this.addSeconds(60 * (another.getHour() * 60 + another.getMinutes()) + another.getSeconds());
    }

    public void addSeconds(int seconds) {
        int summedSeconds = this.seconds + seconds;
        if (summedSeconds > 59) {
            int minutesFromSeconds = summedSeconds / 60;    //61/60 = 1; 30/60 = 0
            addMinutes(minutesFromSeconds);

            this.seconds = summedSeconds - minutesFromSeconds * 60;
        } else {
            this.seconds += seconds;
        }
    }


    public void minusClock(Clock another) {
        if (another != null) {
            int secondsFromHours = 3600 * another.getHour();
            int secondsFromMinutes = 60 * another.getMinutes();
            this.minusSecounds(secondsFromHours + secondsFromMinutes + another.getSeconds());
        }
        //this.addSeconds(60 * (another.getHour() * 60 + another.getMinutes()) + another.getSeconds());
    }


    public void minusSecounds(int seconds) {
        int subtractedSecounds = this.seconds - seconds;
        if (subtractedSecounds < 0) {
            int minutesFromsecounds = Math.abs(subtractedSecounds - 59) / 60;
            minusMinutes(minutesFromsecounds);
            this.seconds = subtractedSecounds + (minutesFromsecounds * 60);
        }else {
            this.seconds -= seconds;
        }

    }


    public void minusHours(int hours) {
        int reduceHours = this.hour - hours;
        if (reduceHours < 0) {
            this.hour = (reduceHours % 24) + 24;
        } else {
            this.hour -= hours;
        }


    }

    public void minusMinutes(int minutes) {
        int reduceMinutes = this.minutes - minutes;
        if (reduceMinutes < 0) {
            int hoursFromMinutes = Math.abs(reduceMinutes - 59) / 60;
            minusHours(hoursFromMinutes);
            this.minutes = reduceMinutes + (hoursFromMinutes * 60);

        } else {
            this.minutes -= minutes;
        }


    }

    @Override
    public String toString() {
        return "Clock{" +
                "hour=" + hour +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
