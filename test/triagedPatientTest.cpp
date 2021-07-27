#include <gtest/gtest.h>
#include <vector>
#include <stdio.h>
#include "../src/linkedlist.hpp"
#include "../src/triagedPatient.hpp"

TEST(triagedPatientTest, nineWeights) {
    TriagedPatient* patient = new TriagedPatient();
    LinkedList* llist = new LinkedList();

    patient->createFactorsLL(llist, patient);
    
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

    EXPECT_PRED_FORMAT2(testing::DoubleLE, 356.08, 356.08);
    patient->deleteTriagedPatient(llist, patient);
}

TEST(triagedPatientTest, oneWeight) {
    TriagedPatient* patient = new TriagedPatient();
    LinkedList* llist = new LinkedList();

    patient->createFactorsLL(llist, patient);
    
    std::vector<double> weights;
    weights.push_back(0.10);

    EXPECT_PRED_FORMAT2(testing::DoubleLE, 70.00, 70.00);
    patient->deleteTriagedPatient(llist, patient);
}

TEST(triagedPatientTest, noWeights) {
    TriagedPatient* patient = new TriagedPatient();
    LinkedList* llist = new LinkedList();

    patient->createFactorsLL(llist, patient);
    
    std::vector<double> weights;

    EXPECT_PRED_FORMAT2(testing::DoubleLE, 0.00, 0.00);
    patient->deleteTriagedPatient(llist, patient);
}

TEST(triagedPatientTest, ninthWeightZero) {
    TriagedPatient* patient = new TriagedPatient();
    LinkedList* llist = new LinkedList();

    patient->createFactorsLL(llist, patient);
    
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

    EXPECT_PRED_FORMAT2(testing::DoubleLE, 266.98, 266.98);
    patient->deleteTriagedPatient(llist, patient);
}

TEST(triagedPatientTest, firstWeightZero) {
    TriagedPatient* patient = new TriagedPatient();
    LinkedList* llist = new LinkedList();

    patient->createFactorsLL(llist, patient);
    
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

    EXPECT_PRED_FORMAT2(testing::DoubleLE, 349.08, 349.08);
    patient->deleteTriagedPatient(llist, patient);
}

TEST(triagedPatientTest, allWeightsZero) {
    TriagedPatient* patient = new TriagedPatient();
    LinkedList* llist = new LinkedList();
    LinkedList::LLNODE *pnode = NULL;

    patient->createFactorsLL(llist, patient);
    
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

    EXPECT_PRED_FORMAT2(testing::DoubleLE, 0.00, 0.00);
    patient->deleteTriagedPatient(llist, patient);
}



