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
                cmd "./mvn compile"
            }
        }

        stage('test') {
            steps {
            cmd "./mvn test"
            }
        }

        stage('package') {
            steps {
            cmd "./mvn package"
            }
        }
    }
}
