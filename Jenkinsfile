pipeline {
    agent { label 'abhi-linux' }

    stages {
        stage('Maven verify') {
            steps {
                dir('CI_project') {
                    sh 'mvn verify'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                dir('CI_project') {
                    sh 'sonar-scanner'
                }
            }
        }

        stage('Docker Build') {
            when {
                expression {
                    return currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                dir('CI_project') {
                    sh 'docker build -t onkarko1106/abhidemo/abhi-java-app:latest .'
                }
            }
        }

        stage('Docker Image Push') {
            when {
                expression {
                    return currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                sh 'docker push onkarko1106/abhidemo/abhi-java-app:latest'
            }
        }
    }
}
