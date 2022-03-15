pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('fetch') {
            steps {
                git url: 'https://github.com/kammora/SpringPetClinic.git', branch: 'master'
            }
        }
        

        stage('compile') {
            steps {
                bat "./mvn compile"
            }
        }

        stage('test') {
            steps {
            bat "./mvn test"
            }
        }

        stage('package') {
            steps {
            bat "./mvn package"
            }
        }
    }
}
