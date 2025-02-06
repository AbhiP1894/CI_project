// pipeline {
//     agent any
//      tools {
//         maven "Maven 3.6.3"
//         jdk "JDK 11"
//     }         
      
//       stages {

//         stage('Initialize'){
//             steps{
//                 echo "PATH = ${M2_HOME}/bin:${PATH}"
//                 echo "M2_HOME = /opt/maven"
//             }
//         }
//            stage('Compile'){
//             steps{
//                 echo "COMPILE"
//             bat "mvn clean install"
//             }
//         }
          
//         stage('test'){
//             steps{
//                 echo "Test"
//             bat "mvn clean test"
//             }
//         }
          
//         stage('Sonar Analysis') {
//             steps {
            
//                 withSonarQubeEnv('SonarQube') {
//                     bat 'mvn sonar:sonar'
//                 }
//             }
//         } 
       
          
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
//     }
// }
pipeline {
    agent { label 'abhi-linux' }

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        
        stage('Git Clone - Master') {
            steps {
                withCredentials([gitUsernamePassword(credentialsId: 'git-cred', gitToolName: 'git')]) {
                    // Clean up any previous clone and then clone the 'master' branch
                    sh 'rm -rf CI_project || true'
                    sh 'git clone --branch master https://github.com/AbhiP1894/CI_project.git'
                }
            }
        }

        stage('Maven Validate - Master') {
            steps {
                // Run mvn validate inside the cloned repository directory for 'master' branch
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

    //     stage('Switch to CP-2-HomePage Branch') {
    //         steps {
    //             dir('CI_project') {
    //                 // Checkout to the 'CP-2-HomePage' branch for testing
    //                 sh 'git checkout CP-2-HomePage'
    //             }
    //         }
    //     }

    //     stage('Maven Test - CP-2-HomePage') {
    //         steps {
    //             // Run mvn test inside the 'CP-2-HomePage' branch
    //             dir('CI_project') {
    //                 sh 'mvn test'
    //             }
    //         }
    //     }
    }
}
