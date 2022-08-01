package com.epicwin.prohub.model.project;

import java.util.Date;

/**
 * Entity class for holding updated Project information.
 */
public class UpdatedProject {
    private String teamName;
    private String projectDescription;
    private String projectType;
    private int storyPoints;
    private int totalSprints;
    private String startDate;
    private String endDate;

    public UpdatedProject() {

    }

    public UpdatedProject(String teamName, String projectDescription, String projectType, int storyPoints, int totalSprints, String startDate, String endDate) {
        this.teamName = teamName;
        this.projectDescription = projectDescription;
        this.projectType = projectType;
        this.storyPoints = storyPoints;
        this.totalSprints = totalSprints;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
