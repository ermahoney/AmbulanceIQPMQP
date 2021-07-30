cmake_minimum_required(VERSION 3.16.3)

project(lib)

add_library(${PROJECT_NAME} 
    core/linkedlist.cpp
    core/triagedPatient.cpp
    #gui/
)

target_include_directories(${PROJECT_NAME} PUBLIC
    ${PROJECT_SOURCE_DIR}/core
    #${PROJECT_SOURCE_DIR}/gui

)