
package com.piotrklukowski.weatherservice.service.provider.weatherbit.data.currentweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("state_code")
    @Expose
    private String stateCode;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("lat")
    @Expose
    private Float lat;
    @SerializedName("lon")
    @Expose
    private Float lon;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("vis")
    @Expose
    private Float vis;
    @SerializedName("rh")
    @Expose
    private Integer rh;
    @SerializedName("dewpt")
    @Expose
    private Float dewpt;
    @SerializedName("wind_dir")
    @Expose
    private Integer windDir;
    @SerializedName("wind_cdir")
    @Expose
    private String windCdir;
    @SerializedName("wind_cdir_full")
    @Expose
    private String windCdirFull;
    @SerializedName("wind_speed")
    @Expose
    private Float windSpeed;
    @SerializedName("temp")
    @Expose
    private Float temp;
    @SerializedName("app_temp")
    @Expose
    private Float appTemp;
    @SerializedName("clouds")
    @Expose
    private Integer clouds;
    @SerializedName("weather")
    @Expose
    private Weather weather;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("ob_time")
    @Expose
    private String obTime;
    @SerializedName("ts")
    @Expose
    private Float ts;
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;
    @SerializedName("slp")
    @Expose
    private Float slp;
    @SerializedName("pres")
    @Expose
    private Float pres;
    @SerializedName("aqi")
    @Expose
    private Float aqi;
    @SerializedName("uv")
    @Expose
    private Float uv;
    @SerializedName("solar_rad")
    @Expose
    private Float solarRad;
    @SerializedName("ghi")
    @Expose
    private Float ghi;
    @SerializedName("dni")
    @Expose
    private Float dni;
    @SerializedName("dhi")
    @Expose
    private Float dhi;
    @SerializedName("elev_angle")
    @Expose
    private Float elevAngle;
    @SerializedName("hour_angle")
    @Expose
    private Float hourAngle;
    @SerializedName("pod")
    @Expose
    private String pod;
    @SerializedName("precip")
    @Expose
    private Float precip;
    @SerializedName("snow")
    @Expose
    private Float snow;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Float getVis() {
        return vis;
    }

    public void setVis(Float vis) {
        this.vis = vis;
    }

    public Integer getRh() {
        return rh;
    }

    public void setRh(Integer rh) {
        this.rh = rh;
    }

    public Float getDewpt() {
        return dewpt;
    }

    public void setDewpt(Float dewpt) {
        this.dewpt = dewpt;
    }

    public Integer getWindDir() {
        return windDir;
    }

    public void setWindDir(Integer windDir) {
        this.windDir = windDir;
    }

    public String getWindCdir() {
        return windCdir;
    }

    public void setWindCdir(String windCdir) {
        this.windCdir = windCdir;
    }

    public String getWindCdirFull() {
        return windCdirFull;
    }

    public void setWindCdirFull(String windCdirFull) {
        this.windCdirFull = windCdirFull;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getAppTemp() {
        return appTemp;
    }

    public void setAppTemp(Float appTemp) {
        this.appTemp = appTemp;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getObTime() {
        return obTime;
    }

    public void setObTime(String obTime) {
        this.obTime = obTime;
    }

    public Float getTs() {
        return ts;
    }

    public void setTs(Float ts) {
        this.ts = ts;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Float getSlp() {
        return slp;
    }

    public void setSlp(Float slp) {
        this.slp = slp;
    }

    public Float getPres() {
        return pres;
    }

    public void setPres(Float pres) {
        this.pres = pres;
    }

    public Float getAqi() {
        return aqi;
    }

    public void setAqi(Float aqi) {
        this.aqi = aqi;
    }

    public Float getUv() {
        return uv;
    }

    public void setUv(Float uv) {
        this.uv = uv;
    }

    public Float getSolarRad() {
        return solarRad;
    }

    public void setSolarRad(Float solarRad) {
        this.solarRad = solarRad;
    }

    public Float getGhi() {
        return ghi;
    }

    public void setGhi(Float ghi) {
        this.ghi = ghi;
    }

    public Float getDni() {
        return dni;
    }

    public void setDni(Float dni) {
        this.dni = dni;
    }

    public Float getDhi() {
        return dhi;
    }

    public void setDhi(Float dhi) {
        this.dhi = dhi;
    }

    public Float getElevAngle() {
        return elevAngle;
    }

    public void setElevAngle(Float elevAngle) {
        this.elevAngle = elevAngle;
    }

    public Float getHourAngle() {
        return hourAngle;
    }

    public void setHourAngle(Float hourAngle) {
        this.hourAngle = hourAngle;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public Float getPrecip() {
        return precip;
    }

    public void setPrecip(Float precip) {
        this.precip = precip;
    }

    public Float getSnow() {
        return snow;
    }

    public void setSnow(Float snow) {
        this.snow = snow;
    }

}
