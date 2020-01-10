*** Settings ***
Documentation     A test suite with a single test for valid login.
Resource          resource.robot

*** Test Cases ***
Valid Login
    Open Browser To Login Page
    Set Selenium Speed    ${DELAY}
    Input Username    ${VALID USER}
    Input Password    ${VALID PASSWORD}
    Submit Credentials
    Welcome Page Should Be Open
    [Teardown]    Close Browser