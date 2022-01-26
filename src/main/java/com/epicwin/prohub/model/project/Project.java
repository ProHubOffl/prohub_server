package com.epicwin.prohub.model.project;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for holding Project information.
 */
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "project_name")
    private String projectName;

    @Column(name = "team_name")
    private String teamName;
    @Column(name = "description")
    private String projectDescription;
    @Column(name = "project_type")
    private String projectType;
    @Column(name = "story_points")
    private int storyPoints;
    @Column(name = "total_sprints")
    private int totalSprints;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public Project() {
    }

    public Project(String projectName, String teamName, String projectDescription, String projectType, int storyPoints, int totalSprints, Date startDate, Date endDate) {
        this.projectName = projectName;
        this.teamName = teamName;
        this.projectDescription = projectDescription;
        this.projectType = projectType;
        this.storyPoints = storyPoints;
        this.totalSprints = totalSprints;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public int getTotalSprints() {
        return totalSprints;
    }

    public void setTotalSprints(int totalSprints) {
        this.totalSprints = totalSprints;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
