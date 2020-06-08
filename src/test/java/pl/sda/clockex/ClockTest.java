package pl.sda.clockex;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClockTest {

    Clock c = new Clock();


    //--- create
    @Test
    public void create_and_initialize_to_00_00_00() {
        //given

        //when

        //then
        assertEquals(0, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(0, c.getSeconds());
    }

    @Test
    public void create_and_set_initial_time() {
        //given
        c = new Clock(10, 30);
        //when

        //then
        assertEquals(30, c.getMinutes());
        assertEquals(10, c.getHour());
        assertEquals(0, c.getSeconds());
    }
    //--- create

    //--- in range
    @Test
    public void set_hour_to_min_value() {
        //given
        c = new Clock(0, 59);
        //when
        c.setHour(0);
        //then
        assertEquals(0, c.getHour());
    }

    @Test
    public void set_hour_to_max_value() {
        //given

        //when
        c.setHour(23);
        //then
        assertEquals(23, c.getHour());
    }

    @Test
    public void set_minutes_to_min_value() {
        //given

        //when
        c.setMinutes(0);
        //then
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void set_minutes_to_max_value() {
        //when
        c.setMinutes(59);
        //then
        assertEquals(59, c.getMinutes());
    }

    //--- in range
    //--- out of range
    @Test
    public void set_hour_above_range() {
        //given

        //when
        c.setHour(50);
        //then
        assertEquals(23, c.getHour());
    }

    @Test
    public void set_hour_below_range() {
        //when
        c.setHour(-1);
        //then
        assertEquals(0, c.getHour());
    }

    @Test
    public void set_minutes_above_range() {
        //when
        c.setMinutes(60);
        //then
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void set_minutes_below_range() {
        //when
        c.setMinutes(-1);
        //then
        assertEquals(0, c.getMinutes());
    }
    //--- out of range

    //--- addHours(), addMinutes()
    @Test
    public void add_minutes_01_30_plus_29min_gives_01_59() {
        //given
        c = new Clock(1, 30);
        //when
        c.addMinutes(29);
        //then
        assertEquals(1, c.getHour());
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void add_minutes_01_30_plus_31min_gives_02_01() {
        //given
        c = new Clock(1, 30);
        //when
        c.addMinutes(31);
        //then
        assertEquals(2, c.getHour());
        assertEquals(1, c.getMinutes());
    }

    @Test
    public void add_minutes_01_30_plus_30min_gives_02_00() {
        //given
        c = new Clock(1, 30);
        //when
        c.addMinutes(30);
        //then
        assertEquals(2, c.getHour());
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void add_minutes_23_59_plus_1min_gives_00_00() {
        //given
        c = new Clock(23, 59);
        //when
        c.addMinutes(1);
        //then
        assertEquals(0, c.getHour());
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void add_minutes_22_22_plus_300min_gives_03_22() {
        //given
        c = new Clock(22, 22);
        //when
        c.addMinutes(300);
        //then
        assertEquals(3, c.getHour());
        assertEquals(22, c.getMinutes());
    }
    //--- addHours(), addMinutes()

    //--- addClock
    //@Ignore //ignoruje test
    @Test
    public void add_clock_01_30_plus_01_30_gives_03_00() {
        //given:
        c = new Clock(1, 30);
        Clock c2 = new Clock(1, 30);
        //when:
        c.addClock(c2);
        //then:
        assertEquals(3, c.getHour());
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void add_clock_01_30_plus_02_30_gives_04_00() {
        //given:
        c = new Clock(1, 30);
        Clock c2 = new Clock(2, 30);
        //when:
        c.addClock(c2);
        //then:
        assertEquals(4, c.getHour());
        assertEquals(0, c.getMinutes());
    }

    @Test
    public void add_clock_01_30_plus_04_29_gives_05_59() {
        //given:
        c = new Clock(1, 30);
        Clock c2 = new Clock(4, 29);
        //when:
        c.addClock(c2);
        //then:
        assertEquals(5, c.getHour());
        assertEquals(59, c.getMinutes());
    }

    @Test
    public void add_clock_23_30_plus_02_00_gives_01_30() {
        //given:
        c = new Clock(23, 30);
        Clock c2 = new Clock(2, 0);
        //when:
        c.addClock(c2);
        //then:
        assertEquals(1, c.getHour());
        assertEquals(30, c.getMinutes());
    }

    @Test
    public void add_clock_05_00_plus_null_gives_05_00() {
        //given:
        c = new Clock(5, 0);
        //when:
        c.addClock(null);
        //then:
        assertEquals(5, c.getHour());
        assertEquals(0, c.getMinutes());
    }
    //--- addClock

    //---refactoring - sekundy
    //create
    @Test
    public void create_and_set_initial_time_with_seconds() {
        //given
        c = new Clock(0, 0, 30);
        //when

        //then
        assertEquals(0, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(30, c.getSeconds());
    }

    //setSeconds
    @Test
    public void set_seconds_to_min_value() {
        //given
        c = new Clock(0, 0, 30);
        //when
        c.setSeconds(0);
        //then
        assertEquals(0, c.getSeconds());
    }

    @Test
    public void set_seconds_below_min_value() {
        //given

        //when
        c.setSeconds(-1);
        //then
        assertEquals(0, c.getSeconds());
    }

    @Test
    public void set_seconds_to_max_value() {
        //given

        //when
        c.setSeconds(59);
        //then
        assertEquals(59, c.getSeconds());
    }

    @Test
    public void set_seconds_above_max_value() {
        //given

        //when
        c.setSeconds(60);
        //then
        assertEquals(59, c.getSeconds());
    }

    //addSeconds
    @Test
    public void add_seconds_1_30_30_plus_10_gives_1_30_40() {
        //given
        c = new Clock(1, 30, 30);
        //when
        c.addSeconds(10);
        //then
        assertEquals(1, c.getHour());
        assertEquals(30, c.getMinutes());
        assertEquals(40, c.getSeconds());
    }

    @Test
    public void add_seconds_1_59_00_plus_100_gives_02_00_40() {
        //given
        c = new Clock(1, 59, 0);
        //when
        c.addSeconds(100);
        //then
        assertEquals(2, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(40, c.getSeconds());
    }

    @Test
    public void add_seconds_1_30_30_plus_31_gives_1_31_01() {
        //given
        c = new Clock(1, 30, 30);
        //when
        c.addSeconds(31);
        //then
        assertEquals(1, c.getHour());
        assertEquals(31, c.getMinutes());
        assertEquals(1, c.getSeconds());
    }

    @Test
    public void add_seconds_1_59_59_plus_10_gives_02_00_09() {
        //given
        c = new Clock(1, 59, 59);
        //when
        c.addSeconds(10);
        //then
        assertEquals(2, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(9, c.getSeconds());
    }

    @Test
    public void add_seconds_23_59_59_plus_1_gives_00_00_00() {
        //given
        c = new Clock(23, 59, 59);
        //when
        c.addSeconds(1);
        //then
        assertEquals(0, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(0, c.getSeconds());
    }

    //addClock
    @Test
    public void add_clock_1_30_30_plus_00_00_10_gives_1_30_40() {
        //given
        c = new Clock(1, 30, 30);
        Clock c2 = new Clock(0, 0, 10);
        //when
        c.addClock(c2);
        //then
        assertEquals(1, c.getHour());
        assertEquals(30, c.getMinutes());
        assertEquals(40, c.getSeconds());
    }

    @Test
    public void add_seconds_1_59_00_plus_00_01_40_gives_02_00_40() {
        //given
        c = new Clock(1, 59, 0);
        Clock c2 = new Clock(0, 1, 40);
        //when
        c.addClock(c2);
        //then
        assertEquals(2, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(40, c.getSeconds());
    }

    @Test
    public void add_seconds_1_30_30_plus_00_00_31_gives_1_31_01() {
        //given
        c = new Clock(1, 30, 30);
        Clock c2 = new Clock(0, 0, 31);
        //when
        c.addClock(c2);
        //then
        assertEquals(1, c.getHour());
        assertEquals(31, c.getMinutes());
        assertEquals(1, c.getSeconds());
    }

    @Test
    public void add_seconds_1_59_59_plus_00_00_10_gives_02_00_09() {
        //given
        c = new Clock(1, 59, 59);
        Clock c2 = new Clock(0, 0, 10);
        //when
        c.addClock(c2);
        //then
        assertEquals(2, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(9, c.getSeconds());
    }

    @Test
    public void add_seconds_23_59_59_plus_00_00_01_gives_00_00_00() {
        //given
        c = new Clock(23, 59, 59);
        Clock c2 = new Clock(0, 0, 1);
        //when
        c.addClock(c2);
        //then
        assertEquals(0, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(0, c.getSeconds());
    }


    @Test
    public void reduce_clock_12_30_45_minus_2_10_55() {
        //given
        c = new Clock(12, 30, 45);
        Clock c2 = new Clock(2, 10, 55);

        //when
        c.minusClock(c2);

        //then
        assertEquals(10, c.getHour());
        assertEquals(19, c.getMinutes());
        assertEquals(50, c.getSeconds());

    }

    @Test
    public void reduc_esecounds_12_35_30_minus_70_gives_12_34_20() {
        //given
        c = new Clock(12, 35, 30);


        //when
        c.minusSecounds(70);

        //then
        assertEquals(12,c.getHour());
        assertEquals(34,c.getMinutes());
        assertEquals(20, c.getSeconds());


        //then

    }

    @Test
    public void reduce_hours_12_00_20_minus_3h_given_9_00_20() {
        //given
        c = new Clock(12, 00, 20);


        //when
        c.minusHours(3);


        //then
        assertEquals(9, c.getHour());
        assertEquals(0, c.getMinutes());
        assertEquals(20, c.getSeconds());

    }

    @Test
    public void reduce_minutes_9_50_00_minus_15_minutes_given_9_35_00(){
        //given
        c = new Clock(9,50,00);

        //when
        c.minusMinutes(15);


        //then
        assertEquals(9,c.getHour());
        assertEquals(35,c.getMinutes());
        assertEquals(0, c.getSeconds());
    }


}
