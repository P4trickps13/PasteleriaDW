package com.pasteleria.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "business_hours")
public class BusinessHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_index", nullable = false)
    private int dayIndex;

    @Column(name = "day_name", nullable = false, length = 30)
    private String dayName;

    @Column(name = "open_time", length = 10)
    private String openTime;

    @Column(name = "close_time", length = 10)
    private String closeTime;

    @Column(nullable = false)
    private boolean closed = false;

    @Column(nullable = false)
    private boolean active = true;

    public BusinessHour() {}

    public BusinessHour(int dayIndex, String dayName, String openTime, String closeTime, boolean closed, boolean active) {
        this.dayIndex = dayIndex;
        this.dayName = dayName;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.closed = closed;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getDayIndex() { return dayIndex; }
    public void setDayIndex(int dayIndex) { this.dayIndex = dayIndex; }
    public String getDayName() { return dayName; }
    public void setDayName(String dayName) { this.dayName = dayName; }
    public String getOpenTime() { return openTime; }
    public void setOpenTime(String openTime) { this.openTime = openTime; }
    public String getCloseTime() { return closeTime; }
    public void setCloseTime(String closeTime) { this.closeTime = closeTime; }
    public boolean isClosed() { return closed; }
    public void setClosed(boolean closed) { this.closed = closed; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
