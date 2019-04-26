# x-mobile-test
Author: Juan Tapia

Here we have two versions:

    1.- Master branch using jQuery Ajax and Java EE
    2.- feature/app-weather-without-ajax-calls branch: using pure Java EE code without jQuery AJAX calls to backend

Steps to run application web from Master branch:

    1. git clone https://github.com/debianwak/x-mobile-test.git
    2. cd x-mobile-test
    3. mvn clean install
    4. mvn spring-boot:run
    5. open app web in browser url: http://localhost:8080/
    6. test it

Steps to run application web from feature/app-weather-without-ajax-calls branch:

    1. git clone https://github.com/debianwak/x-mobile-test.git
    2. cd x-mobile-test
    3. git checkout feature/app-weather-without-ajax-calls
    4. mvn clean install
    5. mvn spring-boot:run
    6. open app web in browser url: http://localhost:8080/
    7. test it

