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

    // stages {
    //     stage('Hello') {
    //         steps {
    //             echo 'Hello World'
    //         }
    //     }
        
    //     stage('Git Clone - Master') {
    //         steps {
    //             withCredentials([gitUsernamePassword(credentialsId: 'git-cred', gitToolName: 'git')]) {
    //                 // Clean up any previous clone and then clone the 'master' branch
    //                 sh 'rm -rf CI_project || true'
    //                 sh 'git clone --branch master https://github.com/AbhiP1894/CI_project.git'
    //             }
    //         }
    //     }

        stage('Maven verify') {
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
    }
stage('Docker Build') {
    steps {
        dir('CI_project') {
            sh '''
            docker build -t onkarko1106/abhidemo/abhi-java-app:latest .
            '''
        }
    }
}

}
