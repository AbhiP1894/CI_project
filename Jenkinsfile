pipeline {
    agent { label 'abhi-linux' }

    stages {
        stage('Maven verify') {
            steps {
                sh 'mvn verify'
            }
        }
        
        // stage('SonarQube Analysis') {
        //     steps {
        //         sh 'sonar-scanner'
        //     }
        // }

        stage('Build Docker Image') {
             steps {
                script {
                    def dockImage = docker.build("abhi-java-app:${env.BUILD_ID}")
                    withCredentials([usernameColonPassword(credentialsId: 'docker', usernameVariable: 'DOCKERHUB_USERNAME', 
passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                        sh "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
                        sh "docker tag abhi-java-app:${env.BUILD_ID} onkarko1106/abhi-java-app:${env.BUILD_ID}"
                        sh "docker push onkarko1106/abhi-java-app:${env.BUILD_ID}"
                        sh "docker push onkarko1106/abhi-java-app:latest"
                    }
                }
            }
        }

        // stage('Push Docker Image') {
        //     steps {
        //         sh 'docker tag abhi-java-app onkarko1106/abhi-java-app:latest'
        //         sh 'docker push onkarko1106/abhi-java-app:latest'
        //     }
        // }

        
    }
}
