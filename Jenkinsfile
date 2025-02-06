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
        
           steps {
                    sh 'docker build -t onkarko1106/abhidemo/abhi-java-app:latest .'
                
            }
            steps {
                sh 'docker push onkarko1106/abhidemo/abhi-java-app:latest'
            }
        }
    }
}
