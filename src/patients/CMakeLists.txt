# defines the version of cmake that was first used to build
cmake_minimum_required(VERSION 3.21.1 FATAL_ERROR)

# defines the core project name and sets the language to c++
project(AmbulanceIQPMQP_triagedPatientTest LANGUAGES CXX)

# defines the c++ language standard
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${CMAKE_SOURCE_DIR}/common
)

# defines which c++ files are used to build the project
set(SRCS 
    ${CMAKE_SOURCE_DIR}/common/linkedlist.cpp
    triagedPatient.cpp
    triagedPatientTest.cpp
)

add_executable(triagedPatientTest ${SRCS})