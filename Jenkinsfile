pipeline {
  agent any
  stages {
    stage('Init') {
      steps {
        echo 'Environment check'
        sh '''echo PATH = ${PATH}
echo M2_HOME = ${M2_HOME}
PATH=$PATH:$M2_HOME/bin'''
      }
    }
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            echo 'Running Tests'
            sh '''PATH=$PATH:$M2_HOME/bin
mvn test'''
          }
        }
        stage('Unit test') {
          steps {
            echo 'Running unit tests'
            sh '''PATH=$PATH:$M2_HOME/bin
mvn test'''
          }
        }
        stage('Integration tests') {
          steps {
            echo 'Running integration tests'
            sh '''PATH=$PATH:$M2_HOME/bin
mvn verify'''
          }
        }
      }
    }
    stage('Test Report') {
      steps {
        echo 'Creating test report'
        junit(testResults: '/target/**.xml', allowEmptyResults: true)
      }
    }
    stage('Build') {
      steps {
        echo 'Packaging application'
        sh '''PATH=$PATH:$M2_HOME/bin
mvn package -DskipTests=true'''
      }
    }
    stage('Staging') {
      steps {
        echo 'Staging deployment'
        sh 'echo "copy war to tomcat"'
      }
    }
    stage('Selenium Tests') {
      parallel {
        stage('Selenium Tests') {
          steps {
            echo 'Running Selenium Tests'
          }
        }
        stage('Regression tests') {
          steps {
            echo 'Running regression tests'
          }
        }
      }
    }
    stage('Human Validation') {
      steps {
        input 'Does the app on staging looks good?'
      }
    }
    stage('Production') {
      steps {
        echo 'Deploying to Production'
      }
    }
  }
  environment {
    M2_HOME = '/usr/share/maven/'
  }
}