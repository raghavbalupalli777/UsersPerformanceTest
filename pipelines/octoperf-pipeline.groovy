#!/usr/bin/env groovy
node {

    stage('Initialise') {
        /* Checkout the scripts */
        checkout scm: [
                $class: 'GitSCM',
                userRemoteConfigs: [
                        [
                                url: "https://github.com/raghavbalupalli777/UsersPerformanceTest.git",
                                credentialsId: "perf-user"
                        ]
                ],
                branches: [[name: "main"]]
        ], poll: false
    }

    stage('Complete any setup steps') {
        echo "Complete set-up steps"
    }

    stage('Execute Performance Tests') {
        dir("${WORKSPACE}/scripts") {
            bat "C:\Users\ragha\Downloads\apache-jmeter-5.4.1\apache-jmeter-5.4.1\bin\jmeter.bat -n -t Test_Plan_users123.jmx -l Test_Plan_users123.report.jtl"
        }
    }

    stage('Analyse Results') {
        echo "Analyse results"
    }
}

