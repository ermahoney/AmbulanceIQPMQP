cmake_minimum_required(VERSION 3.16.3)



# Creates patient library
#______________________________________________________________________________#

# sets varaibles
set(THIS patient)
set(THIS_TEST patient_test)

# enables testing for src
enable_testing()

# builds src library from the included .cpp files
add_library(${THIS} 
    ../common/linkedlist.cpp
    triagedPatient.cpp
)

# locates .hpp file directories when compiling project
target_include_directories(${THIS} PUBLIC
    ${CMAKE_CURRENT_SOURCE_DIR}/../common
    ${CMAKE_CURRENT_SOURCE_DIR}
)



# Tests patient
#______________________________________________________________________________#

# builds src test executable
add_executable(${THIS_TEST} 
    triagedPatientTest.cpp
)

# links libraries to executable
target_link_libraries(${THIS_TEST} PUBLIC
    gtest_main
    ${THIS}
)

include(GoogleTest)
gtest_discover_tests(${THIS_TEST})
