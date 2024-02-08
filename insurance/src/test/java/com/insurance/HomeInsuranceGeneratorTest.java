package com.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HomeInsuranceGeneratorTest {

    @Test
    void testComputePremium3() {
        assertEquals("931.0",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 1, 1, "Construction Type", "42"));
    }

    @Test
    void testComputePremium4() {
        assertEquals("1178.0",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 60000, 1, 1, "Construction Type", "42"));
    }

    @Test
    void testComputePremium5() {
        assertEquals("Declined",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 550000, 1, 1, "Construction Type", "42"));
    }

    @Test
    void testComputePremium6() {
        assertEquals("1330.0",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 60000, 1, "Construction Type", "42"));
    }

    @Test
    void testComputePremium7() {
        assertEquals("817.0",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 2, 1, "Construction Type", "42"));
    }

    @Test
    void testComputePremium8() {
        assertEquals("817.0",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 3, 1, "Construction Type", "42"));
    }

    @Test
    void testComputePremium9() {
        assertEquals("1301.5",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 1, 60000, "Construction Type", "42"));
    }

    @Test
    void testComputePremium10() {
        assertEquals("1153.3",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 1, 15, "Construction Type", "42"));
    }


    @Test
    void testComputePremium11() {
        assertEquals("698.25", (new HomeInsuranceGenerator()).computePremium("42", 1, 1, 1, 1, "M", "42"));
    }


    @Test
    void testComputePremium12() {
        assertEquals("1520.0",
                (new HomeInsuranceGenerator()).computePremium("42", 1, 60000, 60000, 1, "Construction Type", "42"));
    }
}
