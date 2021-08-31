# defines the version of cmake that was first used to build
cmake_minimum_required(VERSION 3.21.1 FATAL_ERROR)

# tells cmake where to look for other cmake files in the subdirectory
add_subdirectory(gui)
add_subdirectory(patients)
