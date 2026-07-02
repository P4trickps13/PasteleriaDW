package com.pasteleria.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "benefits")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String icon;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(name = "bg_class", nullable = false, length = 120)
    private String bgClass;

    @Column(name = "icon_color_class", nullable = false, length = 120)
    private String iconColorClass;

    @Column(name = "accent_class", nullable = false, length = 120)
    private String accentClass;

    @Column(nullable = false)
    private boolean active = true;

    @Column(name = "sort_order", nullable = false)
    private int sortOrder;

    public Benefit() {}

    public Benefit(String icon, String title, String description, String bgClass, String iconColorClass, String accentClass, boolean active, int sortOrder) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.bgClass = bgClass;
        this.iconColorClass = iconColorClass;
        this.accentClass = accentClass;
        this.active = active;
        this.sortOrder = sortOrder;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getBgClass() { return bgClass; }
    public void setBgClass(String bgClass) { this.bgClass = bgClass; }
    public String getIconColorClass() { return iconColorClass; }
    public void setIconColorClass(String iconColorClass) { this.iconColorClass = iconColorClass; }
    public String getAccentClass() { return accentClass; }
    public void setAccentClass(String accentClass) { this.accentClass = accentClass; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public int getSortOrder() { return sortOrder; }
    public void setSortOrder(int sortOrder) { this.sortOrder = sortOrder; }
}
