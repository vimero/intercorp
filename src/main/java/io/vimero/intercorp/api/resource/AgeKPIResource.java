package io.vimero.intercorp.api.resource;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

public class AgeKPIResource {

    private double average;
    private double standard;

    public AgeKPIResource(double average, double standard) {
        this.average = average;
        this.standard = standard;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getStandard() {
        return standard;
    }

    public void setStandard(double standard) {
        this.standard = standard;
    }
}
