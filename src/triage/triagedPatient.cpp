/** Main file for triaged patient
 *
 * @author Alex Miera
 *
 */

#include <vector>
#include <iostream>
#include <stdio.h>
#include "linkedlist.h"
#include "triagedPatient.h"



int main(int argc, char *argv[]) {
    TriagedPatient patient1;
    TriagedPatient* ppatient1;

    ppatient1->factors = create();
    
    addtail(ppatient1->factors, ppatient1->getExtractionTime());
    addtail(ppatient1->factors, ppatient1->getBurnPercent());
    addtail(ppatient1->factors, ppatient1->getRespirationRate());
    addtail(ppatient1->factors, ppatient1->getTidalVolume());
    addtail(ppatient1->factors, ppatient1->getPulse());
    addtail(ppatient1->factors, ppatient1->getSystolicPressure());
    addtail(ppatient1->factors, ppatient1->getDiastolicPressure());
    addtail(ppatient1->factors, ppatient1->getTemperature());
    addtail(ppatient1->factors, ppatient1->getBloodOxygen());

    std::vector<double> weights;
    weights.push_back(0.1);
    weights.push_back(0.2);
    weights.push_back(0.3);
    weights.push_back(0.4);
    weights.push_back(0.5);
    weights.push_back(0.6);
    weights.push_back(0.7);
    weights.push_back(0.8);
    weights.push_back(0.9);

    double retrievableWelfare = calculateRetrievableWelfare(weights, ppatient1);
    printf("Retrievable welfare: %f", retrievableWelfare);
}



/** Function that calculates the patients likelyhood of survival, i.e. 
 *  retrievable welfare
 * 
 * @note number of factors is specified at runtime
 * 
 * @param weights
 * @param triagedPatient
 * @return weightedSum
 * @note low triage weight = green to yellow tag
 *       high triage weight = red to black tag
*/
static double calculateRetrievableWelfare(std::vector<double> weights, struct TriagedPatient *triagedPatient){
    double weightedSum = 0;
    LLNODE *pnode = get_first_node(triagedPatient->factors);

    for( int i = 0; i < weights.size(); i++ ){
        if( weights.at(i) != 0.0){
            weightedSum += weights.at(i) * (pnode->factor);
            pnode = get_next_node(pnode);
        }
    }
    return weightedSum;
}



/** Function that gets the time it takes to transfer the patient from the
 *  ground to the field hospital starting at the time a distress signal
 *  was sent to EMS (t_r) and ending at the time of arrival at a field 
 *  hospital (s_rh)
 * 
 * @param void
 * @return extractionTime
 * @note extractionTime is in minutes
*/

double TriagedPatient::getExtractionTime() {
    return 70;
}

double TriagedPatient::getBurnPercent() {
    return 90.9;
}

double TriagedPatient::getRespirationRate() {
    return 20;
}

double  TriagedPatient::getTidalVolume() {
    return 8;
}

double TriagedPatient::getPulse() {
    return 70;
}

double TriagedPatient::getSystolicPressure() {
    return 115;
}

double TriagedPatient::getDiastolicPressure() {
    return 70;
}

double TriagedPatient::getTemperature() {
    return 99.5;
}

double TriagedPatient::getBloodOxygen() {
    return 99;
}