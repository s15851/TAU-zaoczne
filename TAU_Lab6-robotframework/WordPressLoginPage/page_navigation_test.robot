*** Settings ***
Documentation     A test suite with a single test for page navigation.
Resource          resource.robot

*** Test Cases ***
Page Navigation
    Open Browser To Login Page
    Maximize Browser Window
    Set Selenium Speed    ${DELAY}
    Login Page Should Be Open
    Go To Lost Your Password
    Lost Password Page Should Be Open
    [Teardown]    Close Browser