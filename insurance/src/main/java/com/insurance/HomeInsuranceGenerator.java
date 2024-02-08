package com.insurance;

public class HomeInsuranceGenerator {

    public static void main(String[] args) {
        HomeInsuranceGenerator hg = new HomeInsuranceGenerator();
        String val=hg.computePremium("2021.07.01", 60, 200000, 2,
                13, "M", "1960.12.01");

        System.out.println("Result====> "+val);
    }
	
      public String computePremium(String EffectiveDate, int HomeOwnerAge, int CoverageAmount,
                                 int TerritoryCode, int AgeOfHome, String ConstructionType, String PolicyHolderDOB) {
        float result;
        EffectiveDate = EffectiveDate.replace(".", "");
        PolicyHolderDOB = PolicyHolderDOB.replace(".", "");
        int efd = Integer.parseInt(EffectiveDate);
        int phd = Integer.parseInt(PolicyHolderDOB);

        int diff = efd - phd;
        System.out.println("Date Difference is " + diff);

        if (true == CoverageAmount < 60000) {
            result = 300;
        } else if (true == CoverageAmount < 100000) {
            result = 400;
        } else if (true == CoverageAmount < 200000) {
            result = 550;
        } else if (true == CoverageAmount < 300000) {
            result = 725;
        } else {
            return "Declined";
        }

        result *= (TerritoryCode == 1) ? 1.3 : (TerritoryCode == 2 || TerritoryCode == 3) ? 1.1 : 2;

        result *= (AgeOfHome >= 15 && AgeOfHome < 30) ? 1.3 : (AgeOfHome >= 30) ? 1.5 : 1;

        result = (result < 650) ? result + 100 : (result > 1200) ? result - 200 : result;

        result *= ConstructionType.equalsIgnoreCase("M") ? 1.5 : 2;

        if (diff < 550000)
            result = result - (result / 20);

        return String.valueOf(result);
    }
}
