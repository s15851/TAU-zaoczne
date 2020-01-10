*** Settings ***
Documentation     A resource file with reusable keywords and variables.
Library           SeleniumLibrary

*** Variables ***
${SERVER}       automationpractice.com
${BROWSER}      Chrome
${DELAY}        1
${MAIN URL}    http://${SERVER}/index.php
${T-SHIRTS TAB URL}  http://${SERVER}/index.php?id_category=5&controller=category
${INVALID EMAIL}     fakemailtest@test.com
${VALID EMAIL}   testmaila@test.com
${VALID EMAIL2}   testmaila6662@test.com
${INVALID PASSWORD}     test
${VALID PASSWORD}   12345
${ALERT1 URL}    http://${SERVER}/index.php?controller=authentication
${ALERT2 URL}    http://${SERVER}/index.php?controller=authentication&back=my-account


*** Keywords ***
Open Browser To Main Page
    Open Browser    ${MAIN URL}    ${BROWSER}
    Title Should Be    My Store

Go To T-SHIRTS Tab
    Click Element      xpath://*[@id="block_top_menu"]/ul/li[3]/a

T-SHIRTS Tab Should Be Open
    Location Should Be  ${T-SHIRTS TAB URL}
    Title Should Be    T-shirts - My Store

Go To Login Page
    Click Element   class:login
#    Maximize Browser Window

Input Email
    [Arguments]    ${email}
    Input Text    id:email    ${email}

Input Password
    [Arguments]    ${passwd}
    Input Text    id:passwd    ${passwd}

# Submit credentials to login
Submit Sign In
    Click Button    id:SubmitLogin

Alert Page Should Be Open
    [Arguments]    ${error}
    Location Should Be   ${error}

My Account Page Should Be Open
    Title Should Be    My account - My Store

Input Email Create
    [Arguments]    ${email}
    Input Text    id:email_create    ${email}

# Submit credentials before filling registration form
Submit Create An Account
    Click Button    xpath://*[@id="SubmitCreate"]

# Submit credentials after filling registration form
Submit Register
    Click Button    xpath://*[@id="submitAccount"]

Register Page Should Be Open
    Title Should Be    Login - My Store

Choose Gender
    Select Radio Button    id_gender  1

Input First Name
    Input Text    id:customer_firstname  Kamil

Input Last Name
    Input Text    id:customer_lastname  Abc

Input Register Password
    Input Text    xpath://*[@id="passwd"]  ${VALID PASSWORD}

Select Day
    Select From List by Value    xpath://*[@id="days"]  22

Select Month
    Select From List by Value    xpath://*[@id="months"]  5

Select Year
    Select From List by Value    xpath://*[@id="years"]  1984

Input Company
    Input Text  xpath://*[@id='company']     PJWSTK

Input Address
    Input Text    xpath://*[@id="address1"]  Brzegi

Input City
    Input Text    xpath://*[@id="city"]  Miami

Select State
    Select From List by Value    xpath://*[@id="id_state"]  9

Input Post Code
    Input Text    xpath://*[@id="postcode"]  12345

Input Phone
    Input Text    xpath://*[@id="phone_mobile"]  123457876