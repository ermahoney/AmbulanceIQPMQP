cmake_minimum_required(VERSION 3.19.2)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON) 

project(AmbulanceIQPMQP)

# add subdirectories
add_subdirectory(ext)
add_subdirectory(src)