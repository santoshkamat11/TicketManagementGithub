node('unix-slave'){

  stage('SCM Checkout'){
  
    git 'https://github.com/santoshkamat11/TicketManagementGithub'
  
  }
  
  stage('Compile-Package'){
  
    sh 'mvn clean install'
  
  }
  
  stage('Push the image'){
  
    sh 'sudo docker login -u santoshkamat11 -p police12@'
    sh 'sudo docker push santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
    echo 'Image pushed to the repository successfully'
    
  }
  
  stage('Pull the image'){
  
    sh 'sudo docker pull santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
    sh 'sudo docker run -p 7070:8080 santoshkamat11/ticket-booking:0.0.2-SNAPSHOT'
  
  }
  
  
}
