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
               // sh 'docker build -t abhi-java-app .'
              script{ 
                  def dockImage = docker.build("abhi-java-app:${env.BUILD_ID}")
                  dockImage.push()
                  dockImage.push('latest')
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
