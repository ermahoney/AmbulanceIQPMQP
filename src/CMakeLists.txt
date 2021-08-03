cmake_minimum_required(VERSION 3.16.3)

project(src) # need to look at more examples

# .cpp files
add_library(${PROJECT_NAME} 
    common/linkedlist.cpp
    patients/triagedPatient.cpp
)

# .hpp file locations
target_include_directories(${PROJECT_NAME} PUBLIC
    ${PROJECT_SOURCE_DIR}/common
    ${PROJECT_SOURCE_DIR}/patients
)
