/** Function prototypes for calculating retrievable welfare
 *
 * @author Alex Miera
 */

#ifndef TRIAGED_PATIENT_TEST_H
#define TRIAGED_PATIENT_TEST_H

class TriagedPatientTest
{

public:
    bool mNineWeightsPass;
    bool mOneWeightPass;
    bool mNoWeightsPass;
    bool mNinthWeightZeroPass;
    bool mFirstWeightZeroPass;
    bool mAllWeightsZeroPass;
    bool mBelowExtractionTimeLimitPass;
    bool mBelowBurnPercentLimitPass;
    bool mBelowBloodOxygenLimitPass;

    int numTests = 9;

    bool test[9];

    TriagedPatientTest()
    {
        mNineWeightsPass = nineWeights();
        test[0] = mNineWeightsPass;

        mOneWeightPass = oneWeight();
        test[1] = mOneWeightPass;

        mNoWeightsPass = noWeights();
        test[2] = mNoWeightsPass;

        mNinthWeightZeroPass = ninthWeightZero();
        test[3] = mNinthWeightZeroPass;

        mFirstWeightZeroPass = firstWeightZero();
        test[4] = mFirstWeightZeroPass;

        mAllWeightsZeroPass = allWeightsZero();
        test[5] = mAllWeightsZeroPass;

        mBelowExtractionTimeLimitPass = belowExtractionTimeLimit();
        test[6] = mBelowExtractionTimeLimitPass;

        mBelowBurnPercentLimitPass = belowBurnPercentLimit();
        test[7] = mBelowBurnPercentLimitPass;

        mBelowBloodOxygenLimitPass = belowBloodOxygenLimit();
        test[10] = mBelowBloodOxygenLimitPass;
    }

    bool nineWeights();
    bool oneWeight();
    bool noWeights();
    bool ninthWeightZero();
    bool firstWeightZero();
    bool allWeightsZero();
    bool belowExtractionTimeLimit();
    bool belowBurnPercentLimit();
    bool belowBloodOxygenLimit();
};

#endif
