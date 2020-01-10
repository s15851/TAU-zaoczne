*** Settings ***
Documentation     A resource file with reusable keywords and variables.
Library           SeleniumLibrary

*** Variables ***
${SERVER}       https://s1.demo.opensourcecms.com/wordpress
${BROWSER}      Chrome
${DELAY}        1
${VALID USER}   opensourcecms
${INVALID USER}     test
${VALID PASSWORD}   opensourcecms
${INVALID PASSWORD}     test
${LOGIN URL}    ${SERVER}/wp-login.php
${WELCOME URL}  ${SERVER}/wp-admin/
${LOSTPASSWD URL}    ${SERVER}/wp-login.php?action=lostpassword


*** Keywords ***
Open Browser To Login Page
    Open Browser    ${LOGIN URL}    ${BROWSER}
    Title Should Be    Log In ‹ opensourcecms — WordPress

Go To Login Page
    Go To    ${LOGIN URL}
    Login Page Should Be Open

Login Page Should Be Open
    Location Should Be  ${LOGIN URL}

Go To Lost Your Password
    Click Element    xpath://*[@id="nav"]/a

Lost Password Page Should Be Open
    Location Should Be  ${LOSTPASSWD URL}

Input Username
    [Arguments]    ${username}
    Input Text    id:user_login    ${username}

Input Password
    [Arguments]    ${password}
    Input Text    id:user_pass    ${password}

Submit Credentials
    Click Button    name:wp-submit

Welcome Page Should Be Open
    Location Should Be  ${WELCOME URL}
    Title Should Be    Dashboard ‹ opensourcecms — WordPress

Login Should Fail And Display Error Message
    Element Should Be Visible   id:login_error

Remember Me Checkbox
    Click Element    xpath://*[@id="rememberme"]