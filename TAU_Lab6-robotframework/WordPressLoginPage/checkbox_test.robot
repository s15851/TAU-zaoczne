*** Settings ***
Documentation     A test suite with a single test for checkbox.
Resource          resource.robot

*** Test Cases ***
Check Box
    Open Browser To Login Page
    Set Selenium Speed    ${DELAY}
    Checkbox Should Not Be Selected     xpath://*[@id="rememberme"]
    Remember Me Checkbox
    Checkbox Should Be Selected     xpath://*[@id="rememberme"]
    [Teardown]    Close Browser