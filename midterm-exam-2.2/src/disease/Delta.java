package disease;

import util.R0;
import util.SevereLevel;

public class Delta extends Covid19 {
    private int spikeProtein;    

    public Delta() {
        super();
        this.setSpikeProtein(10);
        this.setReproductionNumber(new R0(5, 7));
        this.setCountryOfFirstApperance("India");
    }

    public SevereLevel severeLevel(boolean isVaccinated) {
        if (isVaccinated) {
            return SevereLevel.MildOrLess;
        } else {
            return SevereLevel.SevereIllness;
        }
    }

    public int minimumInfectionSpread(int n) {
        return spread(5, n);
    }

    public String toString() {
        return "Delta";
    }


    public int getSpikeProtein() {
        return this.spikeProtein;
    }

    public void setSpikeProtein(int spikeProtein) {
        this.spikeProtein = spikeProtein;
    }

}
