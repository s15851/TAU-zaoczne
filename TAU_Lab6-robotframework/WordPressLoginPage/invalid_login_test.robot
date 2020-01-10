*** Settings ***
Documentation     A test suite containing tests related to invalid login.
Suite Setup       Open Browser To Login Page
Suite Teardown    Close Browser
Test Setup        Go To Login Page
Test Template     Login With Invalid Credentials Should Fail
Resource          resource.robot

*** Test Cases ***               USER NAME        PASSWORD
Invalid Username                 ${INVALID USER}  ${VALID PASSWORD}
Invalid Password                 ${VALID USER}    ${INVALID PASSWORD}
Invalid Username And Password    ${INVALID USER}  ${INVALID PASSWORD}
Empty Username                   ${EMPTY}         ${VALID PASSWORD}
Empty Password                   ${VALID USER}    ${EMPTY}
Empty Username And Password      ${EMPTY}         ${EMPTY}

*** Keywords ***
Login With Invalid Credentials Should Fail
    Set Selenium Speed    ${DELAY}
    [Arguments]    ${username}    ${password}
    Input Username    ${username}
    Input Password    ${password}
    Submit Credentials
    Login Should Fail And Display Error Message

