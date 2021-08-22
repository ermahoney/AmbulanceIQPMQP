# derived from https://github.com/lszl84/wx_cmake_template

# defines the version of cmake that was first used to build
cmake_minimum_required(VERSION 3.21.1 FATAL_ERROR)

# defines the core project name and sets the language to c++
project(AmbulanceIQPMQP_core LANGUAGES CXX)

# defines the c++ language standard
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# hack for buggy CMake's FindwxWidgets script
if (DEFINED ENV_WX_CONFIG)
    set (ENV{WX_CONFIG} ${ENV_WX_CONFIG})
endif()

# may define wxWidgets as a static library 
# see https://cmake.org/cmake/help/latest/module/FindwxWidgets.html
set(wxWidgets_USE_STATIC 1)

# looks for wxWidgets package and if not found, will throw a fatal error
find_package(wxWidgets REQUIRED)

# defines which c++ files are used to build the project
set(SRCS 
    main.cpp
)

# loads and runs CMake code from wxWidgets convenience include file
# see https://cmake.org/cmake/help/latest/module/FindwxWidgets.html
include(${wxWidgets_USE_FILE})

# creates executable based on operating system
# see launch.json for executable directory location
if (APPLE)
    # create bundle on apple compiles
    add_executable(main MACOSX_BUNDLE ${SRCS} )
    # Set a custom plist file for the app bundle - needed for Mac OS Retina display
    set_target_properties(main PROPERTIES MACOSX_BUNDLE_INFO_PLIST ${CMAKE_CURRENT_SOURCE_DIR}/Info.plist)
else()
    # the WIN32 is needed for Windows in order for it to look for WinMain
    # instead of the main function. This is ignored on other systems,
    # so it works on all platforms
    add_executable(main WIN32 ${SRCS})
endif()

# links wxWidgets libraries to main executable
target_link_libraries(main PRIVATE 
    ${wxWidgets_LIBRARIES}
)