package ro.cni.course.deutschebank.prepared.reflection;

import java.time.LocalDateTime;

public class ShopClient {
    @SecretInfoAnnotation(isSecret = false)
    private String name;

    @SecretInfoAnnotation(isSecret = false)
    private Integer yearsExperience;

    @SecretInfoAnnotation(isSecret = false)
    private LocalDateTime dateOfBirth;

    @SecretInfoAnnotation()
    private Boolean isMarried;

    public ShopClient(final String name, final Integer yearsExperience, final LocalDateTime dateOfBirth, final Boolean isMarried) {
        this.name = name;
        this.yearsExperience = yearsExperience;
        this.dateOfBirth = dateOfBirth;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(final Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(final Boolean married) {
        isMarried = married;
    }
}
