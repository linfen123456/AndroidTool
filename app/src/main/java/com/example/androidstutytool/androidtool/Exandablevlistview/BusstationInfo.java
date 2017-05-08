package com.example.androidstutytool.androidtool.Exandablevlistview;

/**
 * Created by chenhao on 2017/4/24.
 */

public class BusstationInfo {
    //站台ID
    private int BusStationId;
    //巴士ID
    private int id;
    //离站台的距离
    private int Distance;

    public BusstationInfo() {
    }

    public int getBusStationId() {
        return BusStationId;
    }

    public void setBusStationId(int busStationId) {
        BusStationId = busStationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    @Override
    public String toString() {
        return "\n巴士{" +
                "BusStationId=" + BusStationId +
                ", id=" + id +
                ", Distance=" + Distance +
                '}';
    }
}
