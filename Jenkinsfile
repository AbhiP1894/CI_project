pipeline {
    agent any
    tools {
        maven "MAVEN"
        jdk "JDK"
    }         
      
      stages {

        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
          
        stage('test'){
            steps{
                echo "Test"
            sh "mvn clean test"
            }
        }
          
        stage('Sonar Analysis') {
            steps {
            
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
          
        stage('Compile'){
            steps{
                echo "COMPILE"
            sh "mvn clean install"
            }
        }
          
//         stage('Upload_Artifact') {
//             steps {
//                 script{
//                def server = Artifactory.server 'artifactory'                
//                def uploadSpec = """{
//                   "files": [
//                     {
//                       "pattern": "target/*.jar",
//                       "target": "CI_Poc_Abhijeet/"
//                     }
//                  ]
//                 }"""
//                 server.upload(uploadSpec) 
//             }
//             }
//         }
    }
}
