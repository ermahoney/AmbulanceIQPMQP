cmake_minimum_required(VERSION 3.19.2)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON) 


# Creates the project library
#______________________________________________________________________________#

# sets varaibles
set(THIS src)
set(THIS_TEST src_test)

# enables testing for src
enable_testing()

# builds src library from the included .cpp files
add_library(${THIS} 
    common/linkedlist.cpp
    patients/triagedPatient.cpp
)

# locates .hpp file directories when compiling project
target_include_directories(${THIS} PUBLIC
    ${CMAKE_CURRENT_SOURCE_DIR}/common
    ${CMAKE_CURRENT_SOURCE_DIR}/patients
)



# Tests the project
#______________________________________________________________________________#

# builds src test executable
add_executable(${THIS_TEST} 
    patients/triagedPatientTest.cpp
)

# links libraries to executable
target_link_libraries(${THIS_TEST} PUBLIC
    gtest_main
    ${THIS}
)

include(GoogleTest)
gtest_discover_tests(${THIS_TEST})
