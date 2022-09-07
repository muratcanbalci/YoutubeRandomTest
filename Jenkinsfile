pipeline {
  agent {
    node {
      label 'windows'
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

    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }

  }
}