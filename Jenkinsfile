pipeline{
    agent any
    stages{
        stage ('Compile Stage'){
            steps {
                withMaven(maven: 'maven_3_8_1') {
                    bat 'mvn clean install'
                }
            }
        }
        stage ('Test Stage'){
                    steps {
                        withMaven(maven: 'maven_3_8_1') {
                            bat 'mvn test'
                        }
                    }
                }
        stage ('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
            }
        }
    }
}