# Ambulance IQPMQP
Author: Alex Miera, Emily Mahoney, Brandon Snapperman

# Motivation
This application allows users to both triage patients and get a ranking of the top field hospitals in the area, as marked on a map, for injured soldiers in a battle setting.

# Language
C++

# Running the Application with VSCode
Packages:
- C/C++ by Microsoft
- CMake by twxs
- CMake Tools by Microsoft
- CodeLLDB by Vadim Chugunov

# Notes on Running the Application
0. Check the blue bottom status bar and ensure that a compiler has been chosen
1. Go to the project root directory CMake and press Ctrl+s to allow CMake to configure the project
2. Ensure a build folder was created in the project rot directory, if so move on to step 3 else repeat step 1.
3. Press f5 or run the project; this will take a while if it is the first build
4. Check the blue bottom status bar and ensure that the start debug configuration is set to (msvc)
5. Ensure a Hello World window pops up

# Links for Sources

# Glossary
Time (according to doc/presentations/TimeOfInformation.ppt)
- t_i – Time of injury
- t_r – Time when vitals begin to be recorded and distress signal to EMS is sent
- a_r – Time of vehicle assignment
- s_rp – Time of arrival of service
- e_rp – Time of beginning of transport
- s_rh – Time of arrival at a field hospital
- e_rh – Time of transfer of patient’s history and vitals
- Extraction time – time between t_r and s_rh

Patient
- Retrievable welfare – The patient’s likelihood of survival, based on a variety of factors such as blood loss, distance from EMS, etc. 
- Point of injury – location where the patient was injured 

Drones
- Remotely piloted drone - drone piloted by a person from a control location that is not inside the drone
- Autonomous drone - drone that is piloted by artificial intelligence that may reside in the drone

Development
- Unit tests - tests of functions that are created after the function is implemented. They deliberately exercise each of the paths through the logic. They are therefore vulnerable to the same logical mistakes as the person who wrote the function.
- Test driven development tests - created before the function is implemented. The test is informed by the requirements, having no information about the implementation. The writer of the test considers all of the scenarios in which the function is to operate, and what possible inputs it can receive. If the function is to act defensively, the rejection actions should be checked. A set of test cases that represent the situations in which the function is to operate are created. The right answer for these test cases is figured out. The not-yet-implemented function is invoked, and its answer should be detected as being wrong for at least one test case. 
