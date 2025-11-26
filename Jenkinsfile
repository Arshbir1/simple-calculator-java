pipeline {
  agent any

  environment {
    GIT_REPO = 'https://github.com/Arshbir1/simple-calculator-java.git'
    DOCKERHUB_REPO = 'Snowden69/simple-calculator-java'
    DOCKERHUB_CRED = 'dockerhub-creds'   // create this credential id in Jenkins
  }

  stages {
    stage('Checkout') {
  steps {
    // reuse the pipeline SCM (the repo that provided the Jenkinsfile)
    checkout scm
  }
}


    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests=false clean package'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test -DtrimStackTrace=false'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Docker Build & Push') {
      when { expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' } }
      steps {
        script {
          sh "docker build -t ${DOCKERHUB_REPO}:${env.BUILD_NUMBER} ."
        }
        withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CRED}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
          sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
          sh "docker push ${DOCKERHUB_REPO}:${env.BUILD_NUMBER}"
        }
      }
    }
  }
}
