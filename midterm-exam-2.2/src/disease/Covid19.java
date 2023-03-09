package disease;


import util.R0;
import util.SevereLevel;

public class Covid19 extends Disease {
    private R0 reproductionNumber;
    private String countryOfFirstAppearance;

    public Covid19() {
        super();
        this.setCountryOfFirstApperance("China");
        this.setReproductionNumber(new R0(2,3));
    }

    public SevereLevel severeLevel(boolean isVaccinated) {
        if (isVaccinated) {
            return SevereLevel.Less;
        } else {
            return SevereLevel.SevereIllness;
        }
    }

    public static int spread(int k, int n) {
        int res=0;
        for (int i=0; i<n; i++) {
            res += Math.pow(k, i+1);
        }
        return res;
    }

    public int minimumInfectionSpread(int n) {
        return spread(2, n);
    }

    public String toString() {
        return "Covid19";
    }


    public R0 getReproductionNumber() {
        return this.reproductionNumber;
    }

    public void setReproductionNumber(R0 reproductionNumber) {
        this.reproductionNumber = reproductionNumber;
    }

    public String getCountryOfFirstAppearance() {
        return this.countryOfFirstAppearance;
    }

    public void setCountryOfFirstApperance(String countryOfFirstApperance) {
        this.countryOfFirstAppearance = countryOfFirstApperance;
    }

}
