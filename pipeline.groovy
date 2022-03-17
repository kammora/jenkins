pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    triggers {
        pollSCM '* * * * *'
    }


    stages {
        stage('pull from github') {
            steps {
                git url: 'https://github.com/kammora/SpringPetClinic', branch: 'master'
            }
        }
        
        
        stage('clean') {
            steps {
                bat "mvn clean"
            }
        }
        
        stage('compile') {
            steps {
                bat "mvn compile"
            }
        }

        stage('test') {
            steps {
                bat "mvn test"
            }
        }

        stage('package') {
            steps {
                bat "mvn package"
            }
        }
    }
}
