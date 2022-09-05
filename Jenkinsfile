pipeline {
  agent {
    node {
      label 'windows maven gradle agent1'
    }

  }
  stages {
    stage('Clean') {
      steps {
        bat 'mvn -DskipTests clean'
      }
    }

    stage('Compile') {
      steps {
        bat 'mvn -DskipTests compile'
      }
    }

  }
}