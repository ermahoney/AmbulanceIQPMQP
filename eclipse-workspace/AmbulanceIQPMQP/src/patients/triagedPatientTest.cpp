//
//#include <gtest/gtest.h>
//#include <vector>
//#include <stdio.h>
//#include "triagedPatient.hpp"
//#include "../common/linkedlist.hpp"
//
//
//
////TEST(triagedPatientTest, nineWeights) {
//    /* creates and fills patient class */
//   // TriagedPatient* ppatient = new TriagedPatient();
//    //LinkedList* llist = new LinkedList();
//    //ppatient->createFactors(llist, ppatient);
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//  //  std::vector<double> weights;
//   // weights.push_back(0.10);
//   // weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 356.08, 356.08);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, oneWeight) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//     /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 70.00, 70.00);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, noWeights) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 0.00, 0.00);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, ninthWeightZero) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.00);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 266.98, 266.98);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, firstWeightZero) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.00);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 349.08, 349.08);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, allWeightsZero) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//    weights.push_back(0.00);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 0.00, 0.00);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, belowExtractionTimeLimit) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    *(ppatient->mExtractionTime) = -10.0;
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 347.08, 347.10);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, belowBurnPercentLimit) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    *(ppatient->mBurnPercent) = -0.01;
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 337.89, 337.90);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, aboveBurnPercentLimit) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    *(ppatient->mBurnPercent) = 100.01;
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 337.89, 337.9);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, belowBloodOxygenLimit) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    *(ppatient->mBloodOxygen) = -0.01;
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 266.98, 267);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
//
//
//TEST(triagedPatientTest, aboveBloodOxygenLimit) {
//    /* creates and fills patient class */
//    TriagedPatient* ppatient = new TriagedPatient();
//    LinkedList* llist = new LinkedList();
//
//    ppatient->createFactors(llist, ppatient);
//
//    *(ppatient->mBloodOxygen) = 100.01;
//
//    /* creates a vector of weights
//     *
//     * note that the position of the weight determines which factor the weight
//     * will effect
//     */
//    std::vector<double> weights;
//    weights.push_back(0.10);
//    weights.push_back(0.20);
//    weights.push_back(0.30);
//    weights.push_back(0.40);
//    weights.push_back(0.50);
//    weights.push_back(0.60);
//    weights.push_back(0.70);
//    weights.push_back(0.80);
//    weights.push_back(0.90);
//
//    EXPECT_PRED_FORMAT2(testing::DoubleLE, 266.98, 267);
//
//    ppatient->deleteTriagedPatient(llist, ppatient); /* frees the memory allocated
//    to patient class */
//}
//
