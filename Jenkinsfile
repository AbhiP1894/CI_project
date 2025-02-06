pipeline {
    agent { label 'abhi-linux' }

    stages {
        stage('Maven verify') {
            steps {
                sh 'mvn verify'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                sh 'sonar-scanner'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t abhi-java-app .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker tag abhi-java-app onkarko1106/abhi-java-app:latest'
                sh 'docker push onkarko1106/abhi-java-app:latest'
            }
        }
    }
}
