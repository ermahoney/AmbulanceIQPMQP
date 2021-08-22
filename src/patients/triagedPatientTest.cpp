/** Main file for triaged patient
 *
 * @author Alex Miera
 *
 */

#include <vector>
#include <iostream>
#include <stdio.h>
#include "../common/linkedlist.hpp"
#include "triagedPatient.hpp"
#include "triagedPatientTest.hpp"

int main()
{
    /* gets test results
     * note: true = pass and false = fail
     */
    TriagedPatientTest *ptest = new TriagedPatientTest();

    /* displays if tests have passed or failed */
    for (int i = 0; i < ptest->numTests; i++)
    {
        if (ptest->test[i])
        {
            printf("Test %i passed \n", i + 1);
        }
        else
        {
            printf("Test %i failed \n", i + 1);
        }
    }

    return 0;
}

bool TriagedPatientTest::nineWeights()
{
    printf("Test 1: nineWeights() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.10);
    weights.push_back(0.20);
    weights.push_back(0.30);
    weights.push_back(0.40);
    weights.push_back(0.50);
    weights.push_back(0.60);
    weights.push_back(0.70);
    weights.push_back(0.80);
    weights.push_back(0.90);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 1 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 356.07 && retrievableWelfare < 356.09;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::oneWeight()
{
    printf("Test 2: oneWeight() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.10);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 2 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 6.99 && retrievableWelfare < 7.01;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::noWeights()
{
    printf("Test 3: noWeights() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 3 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > -0.01 && retrievableWelfare < 0.01;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);
    return pass;
}

bool TriagedPatientTest::ninthWeightZero()
{
    printf("Test 4: ninthWeightZero() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.10);
    weights.push_back(0.20);
    weights.push_back(0.30);
    weights.push_back(0.40);
    weights.push_back(0.50);
    weights.push_back(0.60);
    weights.push_back(0.70);
    weights.push_back(0.80);
    weights.push_back(0.00);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 4 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 266.97 && retrievableWelfare < 266.99;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::firstWeightZero()
{
    printf("Test 5: firstWeightZero() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.00);
    weights.push_back(0.20);
    weights.push_back(0.30);
    weights.push_back(0.40);
    weights.push_back(0.50);
    weights.push_back(0.60);
    weights.push_back(0.70);
    weights.push_back(0.80);
    weights.push_back(0.90);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 5 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 349.07 && retrievableWelfare < 349.09;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::allWeightsZero()
{
    printf("Test 6: allWeightsZero() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);
    weights.push_back(0.00);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 6 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > -00.01 && retrievableWelfare < 00.01;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::belowExtractionTimeLimit()
{
    printf("Test 7: belowExtractionTimeLimit() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* changes variable outside its appropriate range */
    *(ppatient->mExtractionTime) = -1.00;

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.10);
    weights.push_back(0.20);
    weights.push_back(0.30);
    weights.push_back(0.40);
    weights.push_back(0.50);
    weights.push_back(0.60);
    weights.push_back(0.70);
    weights.push_back(0.80);
    weights.push_back(0.90);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 7 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 349.07 && retrievableWelfare < 349.09;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::belowBurnPercentLimit()
{
    printf("Test 8: belowBurnPercentLimit() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* changes variable outside its appropriate range */
    *(ppatient->mBurnPercent) = -1.00;

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.10);
    weights.push_back(0.20);
    weights.push_back(0.30);
    weights.push_back(0.40);
    weights.push_back(0.50);
    weights.push_back(0.60);
    weights.push_back(0.70);
    weights.push_back(0.80);
    weights.push_back(0.90);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 8 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 337.89 && retrievableWelfare < 337.91;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}

bool TriagedPatientTest::belowBloodOxygenLimit()
{
    printf("Test 10: belowBloodOxygenLimit() \n");

    /* creates and fills patient class */
    TriagedPatient *ppatient = new TriagedPatient();
    LinkedList *llist = new LinkedList();
    ppatient->createFactors(llist);

    /* changes variable outside its appropriate range */
    *(ppatient->mBloodOxygen) = -1.00;

    /* creates a vector of weights 
     *
     * note: the position of the weight determines which factor it will effect
     */
    std::vector<double> weights;
    weights.push_back(0.10);
    weights.push_back(0.20);
    weights.push_back(0.30);
    weights.push_back(0.40);
    weights.push_back(0.50);
    weights.push_back(0.60);
    weights.push_back(0.70);
    weights.push_back(0.80);
    weights.push_back(0.90);

    /* gets and checks the retrievable welfare result against the expected result value */
    double retrievableWelfare = ppatient->calculateRetrievableWelfare(weights, llist);
    printf("Test 10 output: %f \n\n", retrievableWelfare);
    bool pass = retrievableWelfare > 266.97 && retrievableWelfare < 266.99;

    /* frees the memory allocated to patient class */
    ppatient->deleteTriagedPatient(llist);
    free(ppatient);

    return pass;
}