*** Settings ***
Documentation     Simple example using SeleniumLibrary.
Library           SeleniumLibrary
Resource          resource.robot

*** Test Cases ***
Page Navigation
    Open Browser To Main Page
    Go To T-SHIRTS Tab
    T-SHIRTS Tab Should Be Open
    [Teardown]    Close Browser

Invalid Login
    Open Browser To Main Page
    Go To Login Page
    Set Selenium Speed     ${DELAY}
    Submit Sign In
    Alert Page Should Be Open  ${ALERT1 URL}
    Input Email    ${INVALID EMAIL}
    Input Password    ${INVALID PASSWORD}
    Submit Sign In
    Alert Page Should Be Open  ${ALERT1 URL}
    [Teardown]    Close Browser

Valid Login
    Open Browser To Main Page
    Go To Login Page
    Set Selenium Speed     ${DELAY}
    Input Email       ${VALID EMAIL}
    Input Password    ${VALID PASSWORD}
    Submit Sign In
    My Account Page Should Be Open
    [Teardown]    Close Browser

Invalid Registration
    Open Browser To Main Page
    Go To Login Page
    Set Selenium Speed     ${DELAY}
    Input Email Create    ${VALID EMAIL}
    Submit Create An Account
    Alert Page Should Be Open   ${ALERT2 URL}
    Input Email Create    ${INVALID EMAIL}
    Submit Create An Account
    Submit Register
    Alert Page Should Be Open   ${ALERT1 URL}
    [Teardown]    Close Browser

Valid Registration
    Open Browser To Main Page
    Go To Login Page
    Set Selenium Speed     ${DELAY}
    Input Email Create    ${VALID EMAIL2}
    Submit Create An Account
    Register Page Should Be Open
    Choose Gender
    Input First Name
    Input Last Name
    Input Register Password
    Select Day
    Select Month
    Select Year
    Input Company
    Input Address
    Input City
    Select State
    Input Post Code
    Input Phone
    Submit Register
    My Account Page Should Be Open
    [Teardown]    Close Browser
