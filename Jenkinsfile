pipeline {
  agent any
  stages {
          stage ('build'){
              steps {
                  echo 'build done'
              }
          post {
                 always {
                     jiraSendBuildInfo site: 'abhijeetfirstjirasite.atlassian.net', branch: 'CP-2-HomePage'
                 }
             }
          }
    }
}
